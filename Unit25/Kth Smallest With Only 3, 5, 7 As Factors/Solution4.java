import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class Solution4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  public long kth(int k) {
		    PriorityQueue<Long> pq = new PriorityQueue<>(2*k); 
		    Set<Long> set = new HashSet<>();
		    long seed = 3 * 5 * 7L;
		    set.add(seed);
		    pq.offer(seed);
		    for (int i = 0; i < k - 1; i++) {
		      seed = pq.poll();
		      addSeed(set,pq,seed * 3);
		      addSeed(set,pq,seed * 5);
		      addSeed(set,pq,seed * 7);
		    }
		    return pq.peek();
		  }
		  private void addSeed(Set<Long> set, PriorityQueue<Long> pq, Long seed) {
		    if (!set.contains(seed)) {
		      pq.offer(seed);
		      set.add(seed);
		    }
		  }
		  
	//Time complexity: O(k*log(K))
	//Space complexity: O(K);
}
