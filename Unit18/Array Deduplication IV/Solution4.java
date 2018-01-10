import java.util.Arrays;

public class Solution4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	/*
	Given an unsorted integer array, remove adjacent duplicate elements repeatedly, 
	from left to right. For each group of elements with the same value do not keep any of them.
	Do this in-place, using the left side of the original array. Return the array after deduplication.

	Assumptions
	The given array is not null
	Examples
	{1, 2, 3, 3, 3, 2, 2} ¡ú {1, 2, 2, 2} ¡ú {1}, return {1}
	 */
	  //approach: use an iteration to check all eles from left to right with two pointers: slow and fast.
	  //slow, all eles to the left side of slow includes slow are final result to return.
	  //fast, all eles to the right side of fast includes fast will be processed.
	  public int[] dedup(int[] array) {
	    //corner case
	    if (array.length <= 1) {
	      return array;
	    }
	    //define pointers and check each ele in array.
	    int slow = -1;
	    int fast = 0;
	    while (fast < array.length) {
	      if (slow == - 1 || array[slow] != array[fast]) {
	        array[++slow] = array[fast++];
	      } else {
	        slow--;
	        //igrone all repeated eles.
	        while (fast + 1 < array.length && array[fast] == array[fast + 1]) {
	          fast++;
	        }
	        fast++;
	      }
	    }
	    return Arrays.copyOf(array, slow + 1);
	  }
	  //Time Complexity: O(n)
	  //Space Complexity: O(1);
}
