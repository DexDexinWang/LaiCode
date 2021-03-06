import java.util.Arrays;

public class Solution11 {

	public static void main(String[] args) {
		int[] input = {1,2};
		System.out.println(Arrays.toString(moveZero(input)));
	}
	
	/*
	Given an array of integers, move all the 0s to the right end of the array.
	The relative order of the elements in the original array need to be maintained.
	Assumptions:
	
	The given array is not null.
	Examples:
	{1} --> {1}
	{1, 0, 3, 0, 1} --> {1, 3, 1, 0, 0}
	 */

	//approach: use an iteration to travese eles from left to right two pointers, slow and fast
	  //slow, all eles to the left side of the slow pointer are the final result to return
	  //fast, all eles to the right side to the fast pointer will be processed.
	  public static int[] moveZero(int[] array) {
	    //corner case
	    if (array.length <= 1) {
	      return array;
	    }
	    //define pointers and traverse all eles
	    int slow = 0;
	    for (int fast = 0; fast < array.length; fast++) {
	      if (array[fast] != 0) {
	        array[slow++] = array[fast];
	      }
	    }
	    //fill remining eles as 0
	    for (int i = slow; i < array.length; i++) {
	      array[i] = 0;
	    }
	    return array;
	  }
	  //Time Complexity: O(n)
	  //Space Complexity: O(1)
}
