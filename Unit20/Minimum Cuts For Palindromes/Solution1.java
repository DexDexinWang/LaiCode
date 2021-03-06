import java.util.Arrays;

public class Solution1 {

	public static void main(String[] args) {
		
		Solution1 s = new Solution1();
		boolean[][] matrix = s.createMatrix("abc");
		for (int i = 0; i < matrix.length;i++) {
			System.out.println(Arrays.toString(matrix[i]));
		}
		
		
		//System.out.println(minCuts("abcbd"));
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
	  //Space Complexity: O(n)
	  
	  
	  public int minCuts1(String input) {
		    //corner case
		    if (input.length() <= 1) {
		      return 0;
		    }
		    boolean[][] matrix = createMatrix(input);
		    int[] dp = new int[input.length()];
		    for (int i = 1; i < input.length(); i++) {
		      //dp[i] = 0;
		      if (matrix[0][i]) {
		        dp[i] = 0;
		        continue;
		      }
		      //set default value
		      dp[i] = Integer.MAX_VALUE;
		      for(int j = 0; j < i; j++) {
		        if (matrix[i][j]) {
		          dp[i] = Math.min(dp[i], dp[j] + 1);
		        }
		      }
		    }
		    return dp[input.length() - 1];
		  }
	  //Time complexity: O(n^2);
	  //Space complexity: O(n^2);
	  
	  private boolean[][] createMatrix(String str) {
		  int len = str.length();
		  boolean[][] temp = new boolean[len][len];
		  for (int i = len - 1; i >= 0; i--) {
			  for(int j = len - 1; j >= i; j--) {
				  if (i == j) {
					  temp[i][j] = true;
				  } else if (i + 1 == j){
					  temp[i][j] = str.charAt(i) == str.charAt(j);
				  } else {
					  temp[i][j] = (str.charAt(i) == str.charAt(j)) && temp[i + 1][j - 1];
				  }
			  }
		  }
		  return temp;
	  }
	  
}
