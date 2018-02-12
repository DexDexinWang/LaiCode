
public class Solution1 {
	
	public static void main(String[] args) {
		int[] input = {-5,-2,1,-3};
		System.out.print(largestSum(input));
	}
	/**
	 * Base case: M[0] = input[0]
	 * Induction Rule:
	 * M[i] represents the maximum sum from 0th to ith that included ith element.
	 * M[i] = input[i - 1] + input[i] 	when M[i-1] >= 0
	 * 		= input[i] 					otherwise;
	 * @param array
	 * @return
	 */
	 public static int largestSum(int[] array) {
		    //use two variables to save the current max and global max;
		    int cur = array[0];
		    int max = array[0];
		    //traverse all values for induction rule.
		    for(int i = 1 ; i < array.length; i++) {
		      if (cur < 0) {
		        cur = array[i];
		      } else {
		        cur += array[i];
		      }
		      max = Math.max(cur, max);
		    }
		    return max;
		  }
		  //time complexit:O(n);
		  //space: O(1);

}
