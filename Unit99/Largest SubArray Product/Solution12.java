
public class Solution12 {

	public static void main(String[] args) {
		double[] input = {2.0, -0.1, 4, -2, -1.5};
		System.out.println(largestProduct(input));
	}
	
	/*
	 * Base case: 
	 * dpMin[0] = array[0];
	 * dpMax[0] = array[0]
	 * Induction Rule: 
	 * dpMin[i] represents the minimum product value from 0th to ith.
	 * dpMax[i] represents the maximum product value from 0th to ith.
	 * dpMin[i] = Math.max(array[i], Math.max(dpMax[i-1] * array[i], dpMin[i-1] * array[i]));
	 * dpMax[i] = Math.min(array[i], Math.min(dpMax[i-1] * array[i], dpMin[i-1] * array[i]));
	 */
	public static double largestProduct(double[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		double max = array[0];
		double min = array[0];
		double result = array[0];
		for(int i = 1 ; i < array.length ; i++) {
			double temp = max;
			max = Math.max(array[i], Math.max(max * array[i], min * array[i]));
			min = Math.min(array[i], Math.min(temp * array[i], min * array[i]));
			if (max > result) result = max; 
		}
		return result;
	}

	//Time complexity: O(N);
	//Space complexity: O(1);
}
