import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Solution1 {

	public static void main(String[] args) {
		int[] input = {2,3,4,3,5,6};
		Solution1 s= new Solution1();
		System.out.println(Arrays.toString(s.kSmallest1(input,4)));
	}
	
	//what: traverse each number check whehter it is in the most k smallest result.
	public static int[] kSmallest(int[] array, int k) {
		//how: 1. corner case
		if (array == null || array.length ==0 || k == 0) {
			return new int[0];
		}
		//2. create a priority queue as Max Heap to store the Kth number.
		PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer> (k , Collections.reverseOrder());
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

	
	
	public int[] kSmallest1(int[] array, int k) {
		// Coner case
		if(array.length == 0 || k == 0) {
		return new int[0];
		}
		// find the kth smallest element
		quickSelect(array, 0, array.length -1, k - 1);
		// copy the elements to array and sort
		int[] result = Arrays.copyOf(array,k);
		Arrays.sort(result);
		return result;
		}

		private void quickSelect(int[] array, int left, int right, int target) {
		if(left >= right) {
			return;
		}
		int mid = partition(array, left, right);
		if(mid == target) {
		return;
		}else if(mid < target) {
		quickSelect(array, left, mid - 1, target);
		}else{
		quickSelect(array, mid + 1, right, target);
		}
		}

		private int partition(int[] array, int left, int right) {
		int pivot = array[right];
		int start = left;
		int end = right - 1;
		while(start <= end) {
		if(array[start] < pivot){
		start++;
		}else if(array[end] >= pivot){
		end--;
		}else{
		swap(array, start++, end--);
		}
		}
		swap(array, start, right);
		return start;
		}

		private void swap(int[] array, int a, int b) {
		int temp = array[a];
		array[a] = array[b];
		array[b] = temp;
		}


}
