import java.util.Arrays;

public class Solution2 {
	public static void main(String[] args) {
		int[] input = {1,1,1,2,2,3,3};
		System.out.println(Arrays.toString(dedup(input)));
	}
	/*
	 Given a sorted integer array, remove duplicate elements. 
	 For each group of elements with the same value keep at most two of them. 
	 Do this in-place, using the left side of the original array and maintain the 
	 relative order of the elements of the array. Return the array after deduplication.
	*/
	//approach: traverse all eles from left to right with two pointers, slow and fast;
	//slow: all eles to the left side of slow (include slow) are the final result to return.
	//fast: all eles to the right side of fast (include fast) will be processed.
	//others are not useful.
	  public static int[] dedup(int[] array) {
		    //corner case
		    if (array.length <= 2) {
		      return array;
		    } 
		    //define pointers and traverse eles in a loop.
		    int slow = 1;
		    for (int fast = 2; fast < array.length ; fast++) {
		      if (array[fast] != array[slow - 1]) {
		        array[++slow] = array[fast];
		      }
		    }
		    //return all eles to the left side of slow includes slow.
		    return Arrays.copyOf(array, slow + 1);
		  }
	  //Time complexity: O(n);
	  //Space complexity: O(1);

}
