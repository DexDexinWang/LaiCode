
public class Solution9 {

	public static void main(String[] args) {

	}
	
	  //DP
	  //dp[i][j] represents the first i chars in input matches the first j chars in pattern matches
	  //base case: dp[0][0] = true; dp[0][j + 1] = dp[0][j - 1] where dp[0][j] == '*'
	  //induction rule: 
	  //dp[i][j] = dp[i - 1][j - 1] where input[i] == pattern[j] || pattern[j] = '.'
	  //dp[i][j] = dp[i][j - 2]     where pattern[j] = '*' && input[j - 1] != pattern[i];
	  //dp[i][j] = dp[i - 1][j] || dp[i][j - 1] || dp[i][j - 2]  where pattern[j] = '*' && (input[j - 1]= pattern[i] || input[j - 1] = '.') 
	  //dp[i][j] = false;
	  public boolean isMatch(String input, String pattern) {
	    int len1 = input.length();
	    int len2 = pattern.length();
	    //define 2D array for DP
	    boolean[][] dp = new boolean[len1 + 1][len2 + 1];
	    //base case;
	    dp[0][0] = true;
	    for(int j = 1; j <= len2; j++) {
	      if (pattern.charAt(j - 1) == '*') {
	        dp[0][j] = dp[0][j - 2];
	      }
	    }
	    //induction rule;
	    for(int i = 1; i <= len1; i++) {
	      for (int j = 1; j<= len2; j++) {
	        if (input.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) == '.') {
	          dp[i][j] = dp[i - 1][j - 1];
	        } else if (pattern.charAt(j - 1) == '*') {
	          if (input.charAt(i - 1) != pattern.charAt(j - 1) && pattern.charAt(j- 1)!= '.') {
	          	dp[i][j] = dp[i][j - 2];
	          } else {
	            dp[i][j] = dp[i][j - 1] || dp[i - 1][j] || dp[i][j - 2];
	          }
	        }
	      }
	    }
	    return dp[len1][len2];
	  }

}
