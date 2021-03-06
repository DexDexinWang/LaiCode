
public class Solution7 {
	public static void main(String[] args){
		Solution7 s = new Solution7();
		String input = "(()()(()";
		System.out.println(s.longestValidParentheses(input));
	}
	 //DP
	  //base case: dp[0] = 0
	  //induction rule: dp[i] represents  number the valid pair parentheses from k. where k < j
	  //dp[i] = dp[i - 1] + 2 + previous valid pair parenthese
	  public int longestValidParentheses(String s) {
	    if (s == null || s.length() <= 1) {
	      return 0;
	    }
	    int[] dp = new int[s.length()];
	    int counter = 0;
	    int max = 0;
	    for(int i = 0; i < s.length(); i++) {
	      if (s.charAt(i) == '(') {
	         counter++;
	      } else if (s.charAt(i) == ')' && counter >0) {
	        dp[i] = dp[i - 1] + 2;
	        if (i - dp[i] > 0) {
	        dp[i] += dp[i-dp[i]];
	        }
	        counter--;
	      }
	      max = Math.max(max, dp[i]);
	    }
	    return max;
	  }
	  //Time complexity: O(n)
	  //Space compelxity: O(n);
}
