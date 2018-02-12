
public class Solution5 {
	  //DP
	  //base case: dp[0][0] = grid[i][j]
	  //induction rule: dp[i][j] represents the minimim sum from <0,0> to <i,j>
	  //dp[i][j] = min(dp[i][j-1],dp[i - 1][j]) + grid
	  public int miniSum(int[][] grid) {
	    int len1 = grid.length;
	    if (len1 == 0) {
	      return 0;
	    }
	    int len2 = grid[0].length;
	    if (len2 == 0) {
	      return 0;
	    }
	    for(int i = 0; i < len1; i++) {
	      for(int j = 0; j < len2; j++) {
	        if (i == 0 && j ==0) {
	          grid[i][j] = grid[i][j];
	        } else if (i == 0) {
	          grid[i][j] = grid[i][j - 1] + grid[i][j];
	        } else if (j == 0) {
	          grid[i][j] = grid[i][j] + grid[i - 1][j];
	        } else {
	          grid[i][j] = Math.min(grid[i][j - 1],grid[i - 1][j]) + grid[i][j];
	        }
	      }
	    }
	    return grid[len1 - 1][len2 - 1];
	  }
	  //Time complexity: O(n^2);
	  //Space complexity: O(n^2);
}
