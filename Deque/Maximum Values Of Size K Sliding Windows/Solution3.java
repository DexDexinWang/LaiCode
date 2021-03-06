import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution3 {

	public static void main(String[] args) {
		int[] input = {5,2,1,4,3,6,2,8,3,1,4};
		System.out.println(maxWindows(input, 4));
		System.out.println(maxWindows1(input, 4));

	}

	public static List<Integer> maxWindows(int[] array, int k) {
		List<Integer> res = new ArrayList<>();
		for(int i = 0 ; i <= array.length - k; i++) {
			int max = array[i];
			for(int j = 1; j < k; j++) {
				if (array[i + j] > max) {
					max = array[i + j];
				}
			}
			res.add(max);
		}
		return res;
	}
	//Time Complexity: O(n ^ 2);
	//Space Compelxity:O(1);

	//approach: use a deque to solve the problem. 
	public static List<Integer> maxWindows1(int[] array, int k) {
		List<Integer> res = new ArrayList<>();
		//use a deque to record the index of numbers that make a descending order.
		Deque<Integer> deque = new LinkedList<Integer>();
		for(int i = 0; i < k; i++) {
			//check first K elements, and save the indexes into deque.
			while(!deque.isEmpty() && array[i] >= array[deque.peekLast()]) {
				deque.pollLast();
			}
			deque.offerLast(i);
		}
		
		for(int i = k ; i < array.length; i++) {
			res.add(array[deque.peekFirst()]);
			//remove the indexes that will be polled. because of take out elements from the window.
			while(!deque.isEmpty() && deque.peekFirst() <= i - k) {
				deque.removeFirst();
			}
			//maintain the descending order for new number that was input to window.
			while(!deque.isEmpty() && array[i] >= array[deque.peekLast()]) {
				deque.removeLast();
			}
			deque.addLast(i);
		}
		res.add(array[deque.peekFirst()]);
		return res;
	}
	//Time complexity:O(n);
	//Space compelxity:O(k);
}
