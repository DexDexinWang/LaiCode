
public class Solution5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/*
	Use the least number of comparisons to get the largest and smallest number in the given integer array. 
	Return the largest number and the smallest number.

	Assumptions
	
	The given array is not null and has length of at least 1
	Examples
	
	{2, 1, 5, 4, 3}, the largest number is 5 and smallest number is 1. return [5, 1].
	 */

	  //appraoch: compare each two elements and divide them into two subsets and find min and max with two pointers.
	  //slow: min ele will to the left side of slow includes slow.
	  //fast: max ele will to the right side of fast in cludes fast.
	  public int[] largestAndSmallest(int[] array) {
	    //corner case
	    if (array.length == 1) {
	      return new int[]{array[0],array[0]};
	    }
	    //define two pointers
	    int slow = 0;
	    int fast = array.length - 1;
	    while (slow < fast) {
	      if (array[slow] > array[fast]) {
	        swap(array, slow, fast);
	      }
	      slow++;
	      fast--;
	    }
	    //find min
	    int min = Integer.MAX_VALUE;
	    for(int i = 0; i <= slow; i++) {
	      min = Math.min(min,array[i]);
	    } 
	    //find max
	    int max = Integer.MIN_VALUE;
	    for(int i = fast; i < array.length; i++) {
	      max = Math.max(max,array[i]);
	    }
	    return new int[]{max, min};
	  }
	  
	  private void swap(int[] array, int i, int j) {
	    int temp = array[i];
	    array[i] = array[j];
	    array[j] = temp;
	  }
	  //Time Complexity: O(1.5n)
	  //Space Complexity: O(1)
}
