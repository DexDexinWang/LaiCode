import java.util.Arrays;

public class Solution3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	/*
	Given a sorted integer array, remove duplicate elements. 
	For each group of elements with the same value do not keep any of them. 
	Do this in-place, using the left side of the original array and and maintain 
	the relative order of the elements of the array. Return the array after deduplication.
	 */
	  //approach: user an iteration to traverse all eles with tow pointers: slow and fast
	  //slow, all eles to the left side of slow includes slow are final result to return.
	  //fast, all eles to the right side of fast includes fast will be proceesed.
	  //others are not useful.
	  public int[] dedup(int[] array) {
	    //corner case
	    if (array.length <= 1) {
	      return array;
	    }
	    //define pointers
	    int slow = 0;
	    int fast = 1;
	    //flag will show wheher the ele in slow pointer need to be deleted.
	    boolean flag = false;
	    while (fast < array.length) {
	      if (array[slow] == array[fast]) {
	        flag = true;
	        fast++;
	      } else if (flag) {
	        array[slow] = array[fast++];
	        flag = false;
	      } else {
	        array[++slow] = array[fast++];
	      }
	    }
	    //return eles to the left side of slow
	    return Arrays.copyOf(array, flag? slow : slow + 1);
	  }
	  //Time complexity: O(n)
	  //Space complexity: O(1)
}
