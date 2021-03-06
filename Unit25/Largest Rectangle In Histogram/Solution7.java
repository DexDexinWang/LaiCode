import java.util.Deque;
import java.util.LinkedList;

public class Solution7 {
	public static void main(String[] args) {
		int[] input = new int[]{2,1,3,4,5,2,6};
		Solution7 s= new Solution7();
		System.out.println(s.largest(input));
	}
	
	  public int largest(int[] array) {
		    Deque<Integer> stack = new LinkedList<>();
		    int max = 0;
		    for (int i = 0; i <= array.length; i++) {
		      int next = i != array.length ? array[i] : 0;
		      while (!stack.isEmpty() && array[stack.peekFirst()] > next) {
		        int height = array[stack.pollFirst()];
		        int leftBoundary = stack.isEmpty() ? 0 : stack.peekFirst() + 1;
		        max = Math.max(max, height * (i - leftBoundary));
		      }
		      stack.offerFirst(i);
		    }
		    return max;
		  }
}
