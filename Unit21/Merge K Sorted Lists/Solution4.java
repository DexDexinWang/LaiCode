import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import generator.ListNode;

public class Solution4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	  //approach: sort k linkedlist together with Priority Queue.
	  public ListNode merge(List<ListNode> listOfLists) {
	    //corner case
	    if (listOfLists == null || listOfLists.size() == 0) {
				return null;
			}
	    ListNode dummy = new ListNode(-1);
	    int k = listOfLists.size();
	    //create minHeap to get the smallest Node each time.
	    PriorityQueue<ListNode> minHeap = new PriorityQueue<>(k, 
	      new Comparator<ListNode>() {
	        @Override 
	        public int compare(ListNode n1, ListNode n2) {
	          if(n1.value == n2.value) {
	            return 0;
	          }
	          return n1.value < n2.value ? -1 : 1;
	        }
	      }
	    );
	    //put all heads into minHeap
	    for(int i = 0; i < k; i++) {
	      if (listOfLists.get(i) != null) {
	        minHeap.offer(listOfLists.get(i));
	      }
	    }
	    ListNode cur = dummy;
	    //reverse all nodes.
	    while(!minHeap.isEmpty()) {
	      cur.next = minHeap.poll();
	      cur = cur.next;
	      if (cur.next != null) {
	        minHeap.offer(cur.next);
	      }
	    }
	    
	    return dummy.next;
	  }
	  //Time complexity: O(nlogk); where k is the size of listOfLists. n is the number of all nodes from sorted list.
	  //space complexity: O(k);

}
