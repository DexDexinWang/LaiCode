
public class Solution1 {
	/*
	Find the longest common substring of two given strings.

	Assumptions
	
	The two given strings are not null
	Examples
	
	S = ��abcde��, T = ��cdf��, the longest common substring of S and T is ��cd��
	 */
	
	
	  //base case;
	  //dp[0][0] = 0;
	  //dp[i][0] = 0;
	  //dp[0][j] = 0;
	  //production rule:
	  //dp[i][j] = represents the longest common substring of S (0th to ith) and sutstring of T (0th to jth)
	  //dp[i][j] = dp[i-1][j-1] + 1; s[i] = t[j]
	  //dp[i][i] = 0    ; otherwise;
	  public String longestCommon(String s, String t) {
	    int len1 = s.length();
	    int len2 = t.length();
	    if (len1 == 0 || len2 == 0) {
	      return "";
	    }
	    String res = "";
	    int max = 0;
	    int[][] dp = new int[len1 + 1][len2 + 1];
	    for(int i = 0; i <= len1; i++) {
	      for(int j = 0; j <= len2; j++) {
	        if (i == 0 || j == 0) {
	          dp[i][j] = 0;
	        } else if (s.charAt(i - 1) == t.charAt(j - 1)) {
	          dp[i][j] = dp[i - 1][j - 1] + 1;
	          if (dp[i][j] > max) {
	            max = dp[i][j];
	            res = s.substring(i - max, i);
	          }
	        } else {
	          dp[i][j] = 0;
	        }
	      }
	    }
	    return res;
	  }
}
