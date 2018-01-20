
public class Solution1 {

	public static void main(String[] args) {

	}
	/*
	 Determine if two given Strings are one edit distance.

	One edit distance means you can only insert one character/delete one character/replace one character to another character in one of the two given Strings and they will become identical.
	
	Assumptions:
	
	The two given Strings are not null
	Examples:
	
	s = "abc", t = "ab" are one edit distance since you can remove the trailing 'c' from s so that s and t are identical
	
	s = "abc", t = "bcd" are not one edit distance
	 */

	//approach: solve the problem as dynamic program
	  //base rule:
	  // dp[0][0] = 0;
	  // dp[0][j] = j;
	  // dp[i][j] = i;
	  //Induction rule:
	  // dp[i][j] represents the minimal steps that first ith characters of s are the same as first jth characters of t
	  // dp[i][j] = min(dp[i-1][j-1], dp[i-1][j], dp[i][j-1]) +1 where s.charAt(i-1) != t.charAt(j-1);
	  // dp[i][j] = dp[i - 1][j - 1] otherwise
	  public boolean oneEditDistance(String s, String t) {
	    int len1 = s.length();
	    int len2 = t.length();
	    //corner case;
	    if (Math.abs(len1 - len2) >= 2) {
	      return false;
	    }
	    //define 2D array to store the minimum steps
	    int[][] dp = new int[len1 + 1][len2 + 1];
	    for (int i = 0 ; i <= len1; i++) {
	      for (int j = 0; j <= len2; j++) {
	        if (i == 0) {
	          dp[i][j] = j;
	        } else if (j == 0) {
	          dp[i][j] = i;
	        } else if (s.charAt(i - 1) == t.charAt(j - 1)) {
	          dp[i][j] = dp[i - 1][j - 1];
	        } else {
	          dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
	          dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
	        }
	      }
	    }
	    if (dp[len1][len2] == 1) {
	      return true;
	    }
	    return false;
	  }
	  //Time Complexity: O(n^2);
	  //Space Complexity: O(n^2);
	  
	  
}
