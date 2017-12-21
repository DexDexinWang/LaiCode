import java.util.Arrays;

public class MyHashMap<K,V> {
	public static final int DEFAULT_CAPACITY = 10;
	public static final float DEFAULT_LOAD_FACTOR = 0.75f; 
	private Node<K,V>[] array;
	private int size;
	private float loadFactor;
	
	public MyHashMap() {
		this(DEFAULT_CAPACITY, DEFAULT_LOAD_FACTOR);
	}
	
	@SuppressWarnings("unchecked")
	public MyHashMap(int cap, float loadFactor) {
		if (cap <= 0) {
			throw new IllegalArgumentException("cap can not be <= 0");
		}
		this.array  = (Node<K,V>[]) (new Node[cap]); 
		this.size = 0;
		this.loadFactor = loadFactor;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public void clear() {
		Arrays.fill(this.array, null);
		size = 0;
	}
	
	private int hash(K key) {
		if (key == null) {
			return 0;
		}
		return key.hashCode() & 0X7FFFFFFF;
	}
	
	private int getIndex(K key) {
		return hash(key) % array.length;
	}
	
	private int getIndex(K key, Node<K,V>[] newArray) {
		return hash(key) % newArray.length;
	}
	
	private boolean equalsValue(V v1, V v2) {
		return v1 != null && v1.equals(v2) || v1 == v2;
	}
	
	public boolean containsValue(V value) {
		if (isEmpty()) {
			return false;
		}
		
		for (Node<K, V> node : array) {
			while (node != null) {
				if (equalsValue(node.value, value)) {
					return true;
				}
				node = node.next;
			}
		}
		return false;
	}
	
	private boolean equalsKey(K k1, K k2) {
		return k1 != null && k1.equals(k2) || k1 == k2;
	}
	
	public boolean containsKey(K key) {
		int index = getIndex(key);
		Node<K, V> node = array[index];
		while (node != null) {
			if (equalsKey(node.key, key)) {
				return true;
			}
			node = node.next;
		}
		return false;
	}
	
	public V get(K key) {
		int index = getIndex(key);
		Node<K, V> node = array[index];
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
		Node<K, V> head = array[index];
		Node<K, V> node = head;
		while (node !=null) {
			if (equalsKey(node.key, key)) {
				V result = node.value;
				node.value = value;
				return result;
			}
			node = node.next;
		}
		Node<K, V> newNode = new Node(key, value);
		newNode.next = head;
		array[index] = newNode;
		size++;
		if(needRehashing()) {
			rehashing();
		}
		return null;
	}
	
	public V put(K key, V value, Node<K, V>[] newArray) {
		int index = getIndex(key,newArray);
		Node<K, V> head = newArray[index];
		Node<K, V> node = head;
		while (node !=null) {
			if (equalsKey(node.key, key)) {
				V result = node.value;
				node.value = value;
				return result;
			}
			node = node.next;
		}
		Node<K, V> newNode = new Node(key, value);
		newNode.next = head;
		newArray[index] = newNode;
		return null;
	}
	
	private boolean needRehashing() {
		float ratio = (size + 0.0f) / array.length;
		return ratio >=loadFactor;
	}
	
	private void rehashing() {
		@SuppressWarnings("unchecked")
		Node<K,V>[] newArray =(Node<K, V>[]) new Node[(int)(array.length * 1.5)];
		int newSize = 0;
		for (Node<K, V> node : array) {
			while (node != null) {
				put(node.getKey(), node.getValue(), newArray);
				newSize++;
				node = node.next;
			}
		}
		this.array = newArray;
		this.size = newSize;
	}
	
	public V remove(K key) {
		int index = getIndex(key);
		Node<K, V> node = array[index];
		if (node == null) {
			return null;
		} else if (equalsKey(node.key, key)) {
			array[index] = node.next;
			return node.value;
		} else {
			while (node.next != null) {
				if (equalsKey(node.next.key, key)){
					Node<K, V> temp = node.next;
					node.next = temp.next;
					temp.next = null;
					size--;
					return temp.value;
				}
			}
		}
		return null;
	}
}
