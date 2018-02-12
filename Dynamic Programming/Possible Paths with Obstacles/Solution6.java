
public class Solution6 {
	  //DP
	  //base case: dp[0][0] = 1;
	  //induction rule: dp[i][j] represents the # of path from <0,0> to <i,j>;
	  //dp[i][j] = dp[i][j - 1] + dp[i - 1][j] where matrix[i][j] == 0;
	  //dp[i][j] = 															where matrix[i][j] == 1;
	  public int possiblepath(int[][] matrix) {
	    //corner case
	    int len1 = matrix.length;
	    if (len1 == 0) {
	      return 0;
	    } 
	    int len2 = matrix[0].length;
	    if (len2 == 0) {
	      return 0;
	    }
	    int[][] dp = new int[len1][len2];
	    for(int i = 0; i < len1; i++) {
	      for(int j = 0; j < len2; j++) {
	        if (matrix[i][j] == 0) {
	          if (i ==0 || j == 0) {
	            dp[i][j] = 1;
	          } else {
	            dp[i][j] = dp[i][j - 1] + dp[i - 1][j];
	          }
	        }
	      }
	    }
	    return dp[len1 - 1][len2 - 1];
	  }
	  //Time complexity: O(n^2)
	  //space complexity: O(n^2);
}
