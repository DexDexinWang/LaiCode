
public class Solution2 {
	/*	 
	Longest Common Subsequence
	Find the length of longest common subsequence of two given strings.
	
	Assumptions
	
	The two given strings are not null
	Examples
	
	S = ¡°abcde¡±, T = ¡°cbabdfe¡±, the longest common subsequence of s and t is {¡®a¡¯, ¡®b¡¯, ¡®d¡¯, ¡®e¡¯}, the length is 4.
	 */
	
	//approach: solve the problem as dp
	  //base case:
	  //dp[0][j] = 0;
	  //dp[j][0] = 0;
	  //production rule:
	  //dp[i][j] represent the longest common subsequence of the s and t from 0 to ith and 0 to jth.
	  //dp[i][j] = dp[i - 1][j - 1]                 where s[i -1] == t[j-1]
	  //dp[i][j] = max(dp[i][j - 1], dp[i - 1][j])  
	  public int longest(String s, String t) {
	    int len1 = s.length();
	    int len2 = t.length();
	    if (len1 == 0 || len2 == 0) {
	      return 0;
	    }
	    int[][] dp = new int[len1 + 1][len2 + 1];
	    for (int i = 0; i <= len1; i++) {
	      for (int j = 0; j <= len2; j++) {
	        if (i == 0 || j == 0) {
	          dp[i][j] = 0;
	        } else if (s.charAt(i - 1) == t.charAt(j - 1)) {
	          dp[i][j] = dp[i - 1][j - 1] + 1;
	        } else {
	          dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
	        }
	      }
	    }
	    return dp[len1][len2];
	  }
	  //Time complexity: O(n^2)
	  //Space complexity: O(n^2)
}
