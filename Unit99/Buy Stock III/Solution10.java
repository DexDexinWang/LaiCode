import java.util.Iterator;
import java.util.PriorityQueue;

public class Solution10 {

	public static void main(String[] args) {
		int[] input = {3,4,1,2,6,2,3,5,1,7,3,8};
		System.out.println(maxProfit(input));
	}
	
	/**
	 * Base case: 
	 * dp[0] = 0;
	 * Induction Rule:
	 * dp[i] represents the local maximum profit from the last minimum price.
	 * dp[i] = dp[i] + array[i] - array[i - 1] 	where array[i - 1] <= array[i];
	 * dp[i] = 0								otherwise;
	 * @param array
	 * @return
	 */
	
	public static int maxProfit(int[] array) {
		PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();
		int[] dp = new int[array.length];
		dp[0] = 0;
		for (int i = 1 ; i < array.length; i++) {
			if (array[i - 1] <= array[i]) {
				dp[i] = dp[i - 1] + array[i] - array[i - 1];
			} else {
				pollMinHeap(minHeap, dp[i-1]);
				dp[i] = 0;
			}
		}
		if (dp[array.length - 1] != 0) {
			pollMinHeap(minHeap, dp[array.length - 1]);
		}
		int res = 0;
		Iterator<Integer> it = minHeap.iterator();
		while(it.hasNext()) {
			res+=it.next();
		}
		return res;
	}
	
	private static void pollMinHeap(PriorityQueue<Integer> minHeap, int num) {
		if (minHeap.isEmpty() || num > minHeap.peek()) {
			if (minHeap.size() >= 2) {
				minHeap.poll();
			}
			minHeap.offer(num);
		}
	}

}
