
public class Solution8 {

	public static void main(String[] args) {
		int[] input = {3,4,1,2,7,6};
		System.out.println(maxProfit(input));
	}

	/**
	 * base case: 
	 * dp[0] = array[0]
	 * Induction rule:
	 * dp[i] presents the minimum price 0th to ith include;
	 * dp[i] = dp[i-1] 				where array[i] >= dp[i-1]
	 * dp[i] = array[i] 			otherwise
	 * @param array
	 * @return
	 */
	public static int maxProfit(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		int[] dp = new int[array.length];
		dp[0] = array[0];
		int maxProfit = 0;
		for (int i = 1; i < array.length ; i++) {
			if (array[i] >= dp[i - 1]) {
				dp[i] = dp[i - 1];
				maxProfit = Math.max(maxProfit, array[i] - dp[i]);
			} else {
				dp[i] = array[i];
			}
		}
		return maxProfit;
	}
	
	public static int maxProfit1(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		int minPrice = array[0];
		int maxProfit = 0;
		for (int i = 1; i < array.length ; i++) {
			if (array[i] >= minPrice) {
				maxProfit = Math.max(maxProfit, array[i] - minPrice);
			} else {
				minPrice = array[i];
			}
		}
		return maxProfit;
	}
	//Time complexity: O(n)
	//Space complexity: O(1);
}
