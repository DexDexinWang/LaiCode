import java.util.Arrays;

public class Solution1 {
	/*
	 Given a sorted integer array, remove duplicate elements. 
	 For each group of elements with the same value keep only one of them. 
	 Do this in-place, using the left side of the original array and 
	 maintain the relative order of the elements of the array. 
	 Return the array after deduplication.
	 */
	
	  //approach: traverse eles from left to right with two pointers, slow and fast
	  //slow, all eles to the left side of slow pointer include slow are the final result to return.
	  //fast, all eles to the right side of fast pointer include fast will be processed.
	  //others, are not useful
	  public int[] dedup(int[] array) {
	    //corner case: 
	    if (array.length <= 1) {
	      return array;
	    }
	    //define pointers and traverse all elements.
	    int slow = 0;
	    for (int fast = 1; fast < array.length; fast++) {
	      if (array[fast] != array[slow]) {
	        array[++slow] = array[fast];
	      }
	    }
	    //return all eles from 0th to slow include slow;
	    return Arrays.copyOf(array, slow + 1);
	  }
	  //Time complexity: O(n);
	  //Space complexity: O(1);
}
