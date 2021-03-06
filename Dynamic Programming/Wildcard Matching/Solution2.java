
public class Solution2 {

	public static void main(String[] args) {

	}
	/*
		Given two strings where first string is a normal string and second string may contain wild card characters. Write a function that returns true if the two strings match. The following are allowed wildcard characters in first string. 
		* --> Matches with 0 or more instances of any character or set of characters.
		? --> Matches with any one character.
		
		Assumptions:
		
		The two strings are both not null.
		Assume there is no more than one '*' adjacent to each other.
		Examples:
		
		input = "abc", pattern = "?*", return true.
	 */
	
	//what: find whether the pattern and input are comparable.

	  //DP
	  //base case: dp[0][0] = true; dp[0][j] = dp[0][j - 1] while pattern[j] = '*';
	  //dp[i][j] represents whether the first i chars in input matches the first j chars in pattern.
	  //dp[i][j] = dp[i - 1][j - 1] while input[i - 1] = pattern[j - 1] || pattern[j - 1] = '?'
	  //dp[i][j] = dp[i - 1][j] || dp[i][j - 1] where pattern[j] = '*'
	  //dp[i][j] = false  otherwise
	  public boolean match(String input, String pattern) {
	    //define 2D array for DP
	    int len1 = input.length();
	    int len2 = pattern.length();
	    boolean[][] dp = new boolean[len1 + 1][len2 + 1];
	    //base case
	    dp[0][0] = true;
			for(int j = 1; j <= len2; j++) {
	      if (pattern.charAt(j - 1) == '*') {
	        dp[0][j] = dp[0][j - 1];
	      }
	    }
	    //induction rule
	    for(int i = 1; i <= len1; i++) {
	      for (int j = 1; j <= len2; j++) {
	        if (input.charAt(i - 1) == pattern.charAt(j - 1) || pattern.charAt(j - 1) =='?') {
	          dp[i][j] = dp[i - 1][j - 1];
	        } else if (pattern.charAt(j - 1) =='*') {
	          dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
	        } else {
	          dp[i][j] = false;
	        }
	      }
	    }
	    return dp[len1][len2];
	  }
	  //Time Complexity: O(n^2)
	  //Space Complexity: O(n^2)
}
