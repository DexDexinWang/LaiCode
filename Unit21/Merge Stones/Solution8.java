
public class Solution8 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//approach: DP
	//base case: dp[i][i] = 0;
	//induction rule: dp[i][j] represents the minimum cost to move stone i to j;
	//dp[i][j] = dp[i][k] + dp[k][j] + weights[i to j]
 	public int minCost(int[] stones) {
		if (stones.length == 1) {
			return 0;
		}
		//define 2D array to store cost
		int len = stones.length;
		int[][] cost = new int[len][len];
		//define 2D array to store value for DP
		int[][] dp = new int[len][len];
		for(int i = len - 1; i >= 0; i--) {
			for(int j = i; j < len; j++) {
				if (i == j) {
					dp[i][j] = 0;
					cost[i][j] = stones[i];
					continue;
				}
				cost[i][j] = cost[i][j - 1] + stones[j]; 
				dp[i][j] = Integer.MAX_VALUE;
				for(int k = i; k < j; k++) {
					dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k + 1][j]);
				}
				dp[i][j] += cost[i][j];
			}
		}
		return dp[0][len - 1];
	}
 	//Time complexity: O(n^2);
 	//Space complexity: O(n^2);
}
