
public class Solution3 {

	public static void main(String[] args) {
		int[] input = {2,4,3,1,6,1,1,1,0};
		System.out.println(canJump(input));
	}
	
	/**
	 * Base case: M[n] = true;
	 * Induction Rule: 
	 * 1. M[i] = represents whether the current directly or indirectly jump to the last element from ith to nth.
	 * 2. M[i] = true 			where the ith element could jump to jth element and jth element is true;
	 * 	  	   = false 			otherwise
	 * @param array
	 * @return
	 */
	public static boolean canJump(int[] array) {
		if (array.length <= 1) {
			return true;
		}
		boolean[] record = new boolean[array.length];
		record[array.length - 1] = true;
		for (int i = array.length - 2 ; i >= 0 ; i--) {
			if (checkNextIth(record, i, array[i])) {
				record[i] = true;
			}
			else {
				record[i] = false;
			}
		}
		return record[0];
	}
	
	private static boolean checkNextIth(boolean[] record, int cur, int next) {
		for(int i = cur + 1; i <= cur + next; i++) {
			if (record[i]) {
				return true;
			}
		}
		return false;
	}

	//time complexity: O(n^k) where k is the largest valeu in A[n]
	//space complexity: O(n)
	
	  //approach: solve the problem as DP
	  //base case: dp[i] = true; if it starts to jump from the last one. it should be ture;
	  //induction rule: dp[i] = true			where dp[i + (0 to dp[i])] = true
	  //								dp[i] = flase			other wise
	  public static boolean canJump1(int[] array) {
	    if (array.length == 1) {
	      return true;
	    }
	    //define an array to store boolean values.
	    boolean[] dp = new boolean[array.length];
	    //base case;
	    dp[array.length - 1] = true;
	    //traverse all values for indocution rule
	    for (int i = array.length - 2; i >= 0; i--) {
	      for (int j = i + 1; j < array.length && j <= array[i] + i; j++) {
	        if (dp[j]) {
	          dp[i] = true;
	          break;
	        }
	      }
	    }
	    return dp[0];
	  }
	  //Time complexity: O(n^2); 
	  //Space compleixty: O(n);
	
	 public boolean canJump2(int[] array) {
		    if(array.length == 1) {
		      return true;
		    }
		    int cur = 0;
		    int max = 0;
		    for (int i = 0; i < array.length; i++) {
		    	if (cur < i) {
		    		if(cur == max) {
		    			return false;
		    		}
		    		cur = max;
		    	}
		    	max = Math.max(max, array[i] + i);
		    }
		    return true;
	 }

}
