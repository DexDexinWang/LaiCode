
public class Solution12 {

	public static void main(String[] args) {
		String s = "abcbdabcdeee";
		String target = "abcd";
		System.out.println(ShortestTargetSubSequence(s,target));
	}
	
	//DP
	//dp[i][j] represent the longest mathed subsequence
	//dp[i][0] = 0;
	//dp[0][j] = 0
	//dp[i][j] = dp[][]
	public static int ShortestTargetSubSequence2(String s, String t) {
		if (s == null || s.length() == 0 || t == null || t.length() == 0) {
			return -1;
		}
		int len1 = s.length();
		int len2 = t.length();
		int[][] dp = new int[len1 + 1][len2 + 1];
		for(int i = 0; i <= len1; i++) {
			for (int j = 0; j <= len2; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = len1 + 1;
				} else {
					dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j]);
					if (s.charAt(i - 1) == t.charAt(j - 1)) {
						dp[i][j] = Math.min(dp[i][j], dp[i -1][j - 1] + 1);
					}
				}
			}
		}
		int ans = len1 + 1;
		int x = -1;
		for(int i = 0; i <=len1; i ++) {
			if (dp[i][len2] < ans) {
				x = i;
				ans = dp[i][len2];
			}
		}
		return x - len2;
	}

		//DP
		//dp[i][j] represent the length that contains t;  
		//dp[i][0] = 0;
		//dp[k][j] = max; 0 < k <= t.length;
		//dp[i][j] = dp[i - 1][j - 1] + 1 where s[i - 1] = t[j - 1]
		//dp[i][j] = dp[i - 1][j] + 1	  otherwise
	public static String ShortestTargetSubSequence(String s, String t) {
		if (s == null || s.length() == 0 || t == null || t.length() == 0) {
			return "";
		}
		int len1 = s.length();
		int len2 = t.length();
		int[][] dp = new int[len1 + 1][len2 + 1];
		int max = len1+ 1;
		for(int i = 0; i <= len1; i++) {
			for (int j = 1; j <= len2; j++) {
				dp[i][j] = max;
				if (i != 0){
					dp[i][j] = Math.min(dp[i][j], 1 + dp[i - 1][j]);
					if (s.charAt(i - 1) == t.charAt(j - 1)) {
						dp[i][j] = Math.min(dp[i][j], dp[i -1][j - 1] + 1);
					}
				}
			}
		}
		
		int ans = len1 + 1;
		int x = -1;
		for(int i = 0; i <=len1; i ++) {
			if (dp[i][len2] < ans) {
				x = i;
				ans = dp[i][len2];
			}
		}
		System.out.println(x);
		System.out.println(ans);
		return s.substring(x-ans, x);
	}
	
	
}
