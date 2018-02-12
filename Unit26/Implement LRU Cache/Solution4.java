import java.util.HashMap;
import java.util.Map;

//1. quick find, hashmap
//2. quick insert, linkedlist
//3. quick delete, doublely linkedlist.
//4. move recently used at the beginning, doublely linkedlist.
public class Solution4<K, V> {
	  class dLinkedList<V>{
	    dLinkedList<V> prev;
	    dLinkedList<V> next;
	    V value;
	    public dLinkedList(V value) {
	      this.value = value;
	    }
	  }
	  dLinkedList<V> head;
	  dLinkedList<V> tail;
	  Map<K,dLinkedList<V>> searchMap;
	  int cap;
	  // limit is the max capacity of the cache
	  public Solution4(int limit) {
	  	cap = limit;
	    searchMap = new HashMap<K,dLinkedList<V>>();
	    head = null;
	    tail = null;
	  }
	  
	  public void set(K key, V value) {
	  	dLinkedList target = searchMap.get(key);
	    if (target == null) {
	      addDLL(new dLinkedList(value));
	      searchMap.put(key, head);
	    } else {
	      target.value = value;
	      updateHead(target);
	    }
	    if (searchMap.size() > cap) {
	      deleteTail();
	    }
	  }
	  
	  public V get(K key) {
	    dLinkedList target = searchMap.get(key);
	    if (target == null) {
	      return null;
	    } else {
		  updateHead(target);
	      return target.value;
	    }
	  }
	  
	  private void addDLL(dLinkedList dll) {
	      if (head == null) {
	      head = dll;
	      tail = dll;
	      } else {
	        dll.next = head;
	      	head.prev = dll;
	        head = dll;
	      }
	  }
	  
	  private void updateHead(dLinkedList dll) {
	    if (head == null) {
	      head = dll;
	      tail = dll;
	    } else {
	      dll.prev.next = dll.next;
	      dll.next.prev = dll.prev;
	      dll.prev = null;
	      dll.next = head;
	      head.prev = dll;
	      head = dll;
	    }
	  }
	  
	  private void deleteTail() {
	    if (tail == null) {
	      return;
	    }
	    if (tail == head) {
	      tail = null;
	      head = null;
	    }
	    dLinkedList prev = tail.prev;
	    tail.prev.next = null;
	    tail.prev = null;
	    tail = prev;
	  }
}
