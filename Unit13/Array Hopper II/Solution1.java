
public class Solution1 {

	public static void main(String[] args) {
		int[] input = {4,2,1,2,0,0};
		System.out.println(minJump(input));
	}
	
	/**
	 * Base Case: M[len - 1] = 0;
	 * Induction Rules: 
	 * 1. M[i] = the minimum number of steps to move from ith to nth position.
	 * 2. M[i] = min(M[j]) +1   where j > i and j can be reached from i by only one jump. 
	 * @param array
	 * @return
	 */
	public static int minJump(int[] array) {
		if (array.length == 1) {
			return 0;
		}
		int len = array.length;
		int[] M = new int[len];
		M[len - 1] = 0;
		for (int i = array.length -2 ; i >= 0 ; i--) {
			M[i] = -1;
			for (int j = i + 1; j <= array[i] + i && j < array.length; j++) {
				if (M[i] == -1) { 
					M[i] = M[j];
				} else if (M[j] != -1 && M[i] > M[j]) {
					M[i] = M[j];
				}
			}
			if (M[i] != 0) {
				M[i]++;
			}
		}
		return M[0];
	}

	
	  //approach: solve the problem as DP
	  //base case: dp[0] = 0;
	  //induction rule: dp[i] represents the minimum steps to jump from 0th to ith include i;
	  //dp[i] = min (dp[k]) where dp[k] is reachable from k to dp[i];
	  //dp[i] =  -1 not reachable.
	  public int minJump1(int[] array) {
	    if (array.length == 1) {
	      return 0;
	    }
	    //define an array to store value for DP
	    int[] dp = new int[array.length];
	    //base case;
	    dp[0] = 0;
	    //for loop for induction rule 
	    for(int i = 1; i < array.length; i++) {
	      dp[i] = -1; // means unreachable 
	      for (int j = i - 1; j >=0; j--) {
	        if (array[j] + j >= i && dp[j]!= -1) {
	          if (dp[i] == -1 || dp[i] > dp[j] + 1) {
	            dp[i] = dp[j] + 1;
	          }
	        }
	      }
	    }
	    return dp[array.length - 1];
	  }
	  //Time complexity: O(n^2);
	  //Spcae complexity: O(n);
}
