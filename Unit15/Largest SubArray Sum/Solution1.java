
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
		if (array.length == 0) {
			return 0;
		}
		//the subset should be at least one size;
		int prev = array[0];
		int max = array[0];
		for(int i = 1 ; i < array.length ; i++) {
			if(prev >= 0) {
				prev += array[i];
			} else {
				prev = array[i];
			}
			//[-5,-2,1,5] it should be updated each time.
			max = Math.max(max, prev);
		}
		return max;
	}


}
