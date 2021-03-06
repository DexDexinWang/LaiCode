
public class Solution9 {

	public static void main(String[] args) {
		int[] input = {1,3};
		System.out.println(maxProfit(input));
	}

	/**
	 * Base Case: 
	 * dp[0] = 0;
	 * Induction Rule:
	 * dp[i] represents the total Profit from 0th to ith include ith price 
	 * dp[i] = dp[i - 1]  			where array[i - 1] >= array[i];
	 * 		 = dp[i - i] + array[i] - array[i - 1] 		otherwise;
	 * @param array
	 * @return
	 */
	
	public static int maxProfit(int[] array) {
		int[] dp = new int[array.length];
		dp[0] = 0;
		for (int i = 1 ; i < array.length; i++) {
			if (array[i - 1] >= array[i]) {
				dp[i] = dp[i - 1];
			}
			else {
				dp[i] = dp[i - 1] + array[i] - array[i - 1];
			}
		}
		return dp[array.length - 1];
	}

	public static int maxProfit1(int[] array) {
		int maxProfit = 0;
		for (int i = 1 ; i < array.length; i++) {
			if (array[i - 1] < array[i]) {
				maxProfit += array[i] - array[i - 1];
			}
		}
		return maxProfit;
	}
	// Time Complexity: O(n);
	// Space Complexity: O(1);
}
