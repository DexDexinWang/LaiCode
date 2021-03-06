import java.util.Arrays;

public class Solution7 {

	public static void main(String[] args) {
		Solution7 s = new Solution7();
		int[] input1 = new int[]{1,3,7,9,13};
		System.out.println(s.minCost2(input1, 16));
	}

	  //Assumption: all numbers in cuts are smaller than length.
	  //Approach: solve the problem as a dynamic problem with an 2D dimension array.
	  //base rule;
	  //dp[0][1] = 0;
	  //dp[1][2] = 0;
	  //dp[2][3] = 0;
	  //dp[3][4] = 0;
	  //induction rule:
	  //dp[i][j] represents the minimum cost cutting the wood between index i and index j in the input array.
	  //the final solution return is the value of M[0][4];
	  //dp[i][j] = dp[i][k] + dp[k][j] + (array[j] - array[i]) where i< k < j;
	public int minCost(int[] cuts, int length) {
		//helper function to calculate the total cost;
		int[] helper = new int[cuts.length + 2];
		helper[0] = 0;
		for(int i = 0; i < cuts.length; i++) {
			helper[i + 1] = cuts[i];
		}
		helper[helper.length - 1] = length;
		int[][] dp = new int[helper.length][helper.length];
		for(int i = 1; i < helper.length; i++) {
			for(int j = i - 1; j >= 0; j--) {
				if(j+1 ==i) {
					dp[j][i] = 0;
				} else {
					dp[j][i] = Integer.MAX_VALUE;
					for(int k = j + 1; k <= i - 1; k++) {
						dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[k][i]);
					}
					dp[j][i] += helper[i] - helper[j];
				}
			}
		}
	    System.out.println(Arrays.toString(helper));
		return dp[0][helper.length - 1];
	}

	  public int minCost2(int[] cuts, int length) {
		    int len = cuts.length;
		    //define one dimensional array to store weight for each wood piece; 
		    int[] weights = new int[len + 2];
		    weights[0] = 0;
		    for(int i = 0; i < len; i++) {  
		      weights[i + 1] = cuts[i];
		    }
		    weights[len + 1] = length;
		    //define an two dimensional array to store values. 
		    int[][] dp = new int[len + 2][len + 2];
		    for (int i = len; i >= 0; i--) {
		      for (int j = i + 1; j <= len + 1; j++) {
		        if (i + 1 == j) {
		          dp[i][j] = 0;
		        } else {
			        dp[i][j] = Integer.MAX_VALUE;
			        for(int k = i + 1 ; k < j; k++) {
			          dp[i][j] = Math.min(dp[i][j], dp[i][k] + dp[k][j]);
			        }
			        dp[i][j] += weights[j] - weights[i];
		        }
		      }
		    }
		    return dp[0][len + 1];
		  }
}
