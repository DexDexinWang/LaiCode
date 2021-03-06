
public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	  //approach: solve the problem with the solution for Longest common subsequence problem. 
	  public int leastInsertion(String input) {
	    if (input == null || input.length() <= 1) {
	      return 0;
	    }
	    StringBuilder sb = new StringBuilder(input);
	    String reverse = sb.reverse().toString();
	    int n = input.length();
	    return n - lcs(input, reverse, n, n);
	  }
	  //solve the longest common subsequence problem as dynamic propblem.
	  //base case: 
	  //dp[0][0] = 0;
	  //dp[i][0] = 0;
	  //dp[0][j] = 0;
	  //induction rule: 
	  //dp[i][j] represents the maximum number of the longest common subsequence.
	  private int lcs(String a, String b, int m, int n) {
	    int[][] dp = new int[m + 1][n + 1];
	    for (int i = 0; i <= n; i++) {
	      for (int j = 0; j <= n; j++) {
	        if (i == 0 || j == 0) {
	          dp[i][j] = 0;
	        } else if (a.charAt(i - 1) == b.charAt(j - 1)) {
	          dp[i][j] = dp[i - 1][j - 1] + 1;
	        } else {
	          dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
	        }
	      }
	    }
	    return dp[m][n];
	  }
	  //Time Complexity: O(n^2);
	  //Space Complexity: O(n^2);
}
