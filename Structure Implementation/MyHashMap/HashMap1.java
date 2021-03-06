import java.util.Arrays;

public class HashMap1<K, V> {
	public static class Node<K, V> {
		final K key;
		V value;
		Node<K, V> next;
		Node (K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {
			return key;
		}
		
		public V getValue() {
			return value;
		}
		
		public void setValue(V value) {
			this.value = value;
		}
	}
	
	public static final int DEFAULT_CAPACITY = 10;
	public static final float DEFAULT_LOAD_FACTOR = 0.75f;
	private int size;
	private Node<K, V>[] array;
	private float loadFactor;
	
	HashMap1() {
		this(DEFAULT_CAPACITY , DEFAULT_LOAD_FACTOR);
	}
	
	HashMap1(int cap, float loadFactor) {
		this.size = 0;
		this.array  = (Node<K, V>[]) (new Node[cap]); 
		this.loadFactor = loadFactor;
	}
	
	private int hashCode(K key) {
		return key.hashCode() & 0x7FFFFFFF;
	}
	private int getIndex(K key) {
		return hashCode(key) % array.length;
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size == 0;
	}
	public void clear() {
		Arrays.fill(array, null);
		size = 0;
	}
	
	private boolean equalsKey(K o1, K o2) {
		return o1 != null && o1.equals(o2) || o1 == o2;
	}
	
	private boolean equalsValue(V o1, V o2) {
		return o1 != null && o1.equals(o2) || o1 == o2;
	}
	
	public V get(K key) {
		int index = getIndex(key);
		Node<K,V> node = array[index];
		while (node != null) {
			if (equalsKey(node.key, key)) {
				return node.value;
			}
			node = node.next;
		}
		return null;
	}
	
	public V put(K key, V value) {
		int index = getIndex(key);
		Node<K,V> head = array[index];
		Node<K,V> node = head;
		while (node != null) {
			if (equalsKey(node.key, key)){
				V res = node.value;
				node.value = value;
				return res;
			}
			node = node.next;
		}
		Node<K,V> newHead = new Node(key, value);
		newHead.next = head;
		array[index] = newHead;
		size++;
		if (needRehashing()) {
			reHashing();
		}
		return null;
	}
	
	public boolean containsKey(K key) {
		int index = getIndex(key);
		Node<K,V> node = array[index];
		while (node != null) {
			if (equalsKey(node.key, key)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}
	
	public boolean containsValue(V value) {
		for (Node<K,V> node: array) {
			while (node != null) {
				if (equalsValue(node.value, value)) {
					return true;
				}
				node = node.next;
			}
		}
		return false;
	}
	
	@SuppressWarnings("null")
	public V revmoe(K key) {
		int index = getIndex(key);
		Node<K,V> node = array[index];
		if (node == null) {
			return null;
		} else if (equalsKey(node.key, key)) {
			V temp = node.value;
			array[index] = node.next;
			node = null;
			size--;
			return temp;
		} else {
			while (node.next != null) {
				if (equalsKey(node.next.key, key)) {
					V temp = node.next.value;
					array[index] = node.next.next;
					node.next = null;
					size--;
					return temp;
				}
			}
		}
		return null;
	}
	
	private boolean needRehashing() {
		return (size + 0.0f) / array.length > loadFactor;
	}
	
	private void reHashing() {
		
	}
}
