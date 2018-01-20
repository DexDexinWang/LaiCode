
public class Solution1 {

	public static void main(String[] args) {
		System.out.println(minCuts("abcbd"));
	}
	  //approach: regard it a DP problem
	  //Base case: dp[0] = 0; only one character no cut.
	  //Induction Rule: 
	  //dp[i] represents minimum cuts from 0th element to ith elements includes ith.
	  //dp[i] = dp[j] + 1 where parlindrom(j, i] will be true;
	  //dp[i] = 0         parlindrom [0th, ith] will be tree;
	  public static int minCuts(String input) {
	    //corner case
	    if (input.length() <= 1) {
	      return 0;
	    }
	    //define space for dp
	    int[] dp = new int[input.length()];
	    for (int i = 1; i < input.length(); i++) {
	      //dp[i] = 0;
	      if (palindrome(input, 0, i)) {
	        dp[i] = 0;
	        continue;
	      }
	      //set default value
	      dp[i] = Integer.MAX_VALUE;
	      for(int j = 0; j < i; j++) {
	        if (palindrome(input, j + 1, i)) {
	          //dp[i] = dp[j] + 1;
	          dp[i] = Math.min(dp[i], dp[j] + 1);
	        }
	      }
	    }
	    return dp[input.length() - 1];
	  }
	  
	  //helper function to check wheher part of input is palindrome.
	  private static boolean palindrome(String input, int i, int j) {
	    while (i < j) {
	      if (input.charAt(i) != input.charAt(j)) {
	        return false;
	      }
	      i++;
	      j--;
	    }
	    return true;
	  }
	  //Time Complexity: O(n^3)
	  //Space Complexity: O(n^2)
}