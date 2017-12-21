import java.util.Arrays;

public class HashMap1<K, V> {
	class Node<K, V> {
		final K key;
		V value;
		Node<K, V> next;
		Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		public K getKey() {
			return this.key;
		}
		
		public V getValue() {
			return this.value;
		}
		
		public void setValue(V value) {
			this.value = value;
		}
	}
	
	public static final int DEFAULT_CAPACITY = 10;
	public static final float DEFAULT_LOAD_FACTOR = 0.75f;
	private int size;
	private Node<K,V>[] array;
	private float loadFactor;
	
	HashMap1() {
		this(DEFAULT_CAPACITY,DEFAULT_LOAD_FACTOR);
	}
	
	HashMap1(int cap, float loadFactor) {
		this.array = (Node<K,V>[]) new Node[cap];
		this.size = 0; 
		this.loadFactor = loadFactor;
	}
	
	private int getIndex(K key){
		return hashCode(key) % array.length;
	}
	
	private int hashCode(K key) {
		return key.hashCode() & 0x7FFFFFFF;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public void clear() {
		Arrays.fill(array, null);
		size = 0;
	}
	
	private boolean equalsKey(K k1, K k2) {
		return k1!= null && k1.equals(k2) || k1 == k2 ; 
	}
	
	public boolean containsKey(K key) {
		int index = hashCode(key);
		Node<K,V> node = array[index];
		while (node != null) {
			if (equalsKey(node.key,key)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}
	
	private boolean equalsValue(V v1, V v2) {
		return v1!= null && v1.equals(v2) || v1 == v2 ; 
	}
	
	public boolean containsValue(V value) {
		if (isEmpty()) {
			return false;
		}
		for (Node<K,V> node : array) {
			while (node != null) {
				if (equalsValue(node.value, value)){
					return true;
				}
				node = node.next;
			}
		}
		return false;
	}
	
	public V get(K key) {
		int index = hashCode(key);
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
		int index = hashCode(key);
		Node<K,V> head = array[index];
		Node<K,V> node = head;
		while (node != null) {
			if (equalsKey(node.key, key)) {
				V res = node.value;
				node.value = value;
				return res;
			}
			node = node.next;
		}
		Node<K,V> newNode = new Node(key, value);
		newNode.next = head;
		array[index] = newNode;
		size++;
		if (needRehashing()) {
			rehashing();
		}
		return null;
	}
	
	private boolean needRehashing() {
		return (size + 0.0f) / array.length > loadFactor;
	}
	
	private void rehashing() {
		
	}
	
	public V remove(K key) {
		int index = hashCode(key);
		Node<K,V> node = array[index];
		if (equalsKey(node.key, key)) {
			array[index] = node.next;
			return node.value;
		}
		while (node.next != null) {
			if (equalsKey(node.next.key, key)) {
				Node<K,V> temp = node;
				node.next= temp.next;
				temp.next = null;
				return temp.value;
			}
		}
		return null;
	}
}
