
public class Solution11 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	//DP
	//dp[i] represents the minimum # of square numbers that are sum to n;
	//base case: dp[0] = 0; dp[1] = 1;
	//induction rule: dp[i] = dp[j] + 1 where j < i;
    public int integerBreak(int n) {
        if (n == 0 || n == 1) {
        	return 1;
        }
        //define an array to store values for DP
        int[] dp = new int[n];
        dp[0] = 0;
        dp[1] = 1;
        for(int i = 2; i <= n; i++) {
        	dp[i] = i;
        	int j = 1;
        	while (j* j <= i) {
        		dp[i] = Math.min(dp[i - j * j] + 1, i);
        		j++;
        	}
        }
        return dp[n];
    }
}
