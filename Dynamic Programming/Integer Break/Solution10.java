
public class Solution10 {

	public static void main(String[] args) {
		
	}
	//dp[i] represent the maximum product of numbers which sum of numbers is i;
	//dp[2] = 1;
    public int integerBreak(int n) {
    	int[] dp = new int[n + 1];
    	dp[1] = 1;
    	for(int i = 2; i <= n; i++) {
    		for(int j = 1; j < i; j++) {
    			dp[i] = Math.max(dp[i],Math.max(dp[i - j], i -j) * Math.max(j,dp[j]));
    		}
    	}
    	return dp[n];
    }
}
