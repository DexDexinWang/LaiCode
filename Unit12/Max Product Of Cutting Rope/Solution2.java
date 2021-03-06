
public class Solution2 {

	public static void main(String[] args) {
		System.out.println(maxProduct(5));
	}

	  //approach: solve it as a dp 
	  //base case: dp[0] = 0; dp[1] = 1
	  //induction rule: dp[i] represents the max product for i length rope;
	  // len = 2 ====> case 1: dp[2] = max(dp[2 - 1],2) * 1 
	 	// len = 3 ====> max (case 1: dp[3] = max(dp[3 - 1],2) * 1  case 2: dp[3] = max(dp[3 - 2], 1) * 2))
	  // dp[i] = max(dp[j],j) * (i-j) where 0 < j < i
	  public static int maxProduct(int length) {
	    //define an array to store values 
	    int[] dp = new int[length + 1];
	    dp[0] = 0;
	    dp[1] = 0; 
	    //traverse all value for induction rule;
	    for (int i = 2; i <= length; i++) {
	      for (int j = 1; j < i; j++) {
	        dp[i] = Math.max(Math.max(dp[j],j) * (i-j),dp[i]);
	      }
	    }
	    return dp[length];
	  }
	  
	//Time complexity: O(n^2);
	//Space complexity: O(n);
	
}
