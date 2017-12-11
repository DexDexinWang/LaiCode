import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1 {

	public static void main(String[] args) {
		int[] input = {2,3,4,3,5,6};
		System.out.println(Arrays.toString(kSmallest(input,1)));
	}
	
	//what: traverse each number check whehter it is in the most k smallest result.
	public static int[] kSmallest(int[] array, int k) {
		//how: 1. corner case
		if (array == null || array.length ==0) {
			return new int[0];
		}
		//2. create a priority queue as Max Heap to store the Kth number.
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer> (k ,
				new Comparator<Integer>() {
			@Override
			public int compare(Integer e1, Integer e2) {
				if (e1.equals(e2)) {
					return 0;
				}
				return e1 > e2 ? -1 : 1;
			}
		});
		//3. traverse all number from array into maxHeap
		for (int i = 0; i < array.length ; i++) {
			if (i < k) {
				maxHeap.offer(array[i]);
			} else if (array[i] < maxHeap.peek()) {
				maxHeap.poll();
				maxHeap.offer(array[i]);
			}
		}
		//4. save it into an array as result.
		int[] res = new int[maxHeap.size()];
		for (int i = maxHeap.size() - 1; i >= 0 ; i--) {
			res[i] = maxHeap.poll();
		}
		return res;
	}
	//Time Complexity: O(nlog(k))
	//Space Complexity: O(k)

}