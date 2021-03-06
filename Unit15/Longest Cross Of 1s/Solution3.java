
public class Solution3 {

	public static void main(String[] args) {
		int[][] input  = {{1,1,1,0,1},{1,0,1,1,1},{1,1,1,1,1},{1,0,1,1,0},{0,0,1,1,0}};
		System.out.println(largest(input));
	}
	/**Base rule
	 * dpLeft[0][0] = matrix[0][0];
	 * dpLeft[i][0] = matrix[i][0];
	 * dpUp[0][0] = matrix[0][0];
	 * dpUp[0][j] = matrix[0][j];
	 * dpDown[rows-1][cols-1] = matrix[rows-1][cols-1];
	 * dpDown[rows-1][j] = matrix[rows-1][j];
	 * dpRight[rows-1][cols-1] = matirx[rows-1][cols-1];
	 * dpRight[i][cols-1] = matirx[i][cols-1];
	 * Induction Rules:
	 * dpLeft[i][j] represents the maximum consecutive 1s for left side of cross 1s in ith jth;
	 * dpLeft[i][j] = dpLeft [i-1][j] + 1	where maxtrix[i][j]=1;  
	 * dpLeft[i][j] = 0		otherwise;
	 * dpUp[i][j] represents the maximum consecutive 1s for Up side of cross 1s in ith jth;
	 * dpUp[i][j] = dpUp [i][j-1] + 1	where maxtrix[i][j]=1;  
	 * dpUp[i][j] = 0		otherwise;
	 * dpRight[i][j] represents the maximum consecutive 1s for right side of cross 1s in ith jth;
	 * dpRight[i][j] = dpRight [i-1][j] + 1	where maxtrix[i][j]=1;  
	 * dpRight[i][j] = 0	otherwise;
	 * dpDown[i][j] represents the maximum consecutive 1s for down side of cross 1s in ith jth;
	 * dpDown[i][j] = dpDown [i][j-1] + 1	where maxtrix[i][j]=1;  
	 * dpDown[i][j] = 0		otherwise;
	 * @param matrix
	 * @return
	 */
	public static int largest(int[][] matrix) {
		int rows = matrix.length;
		if (rows == 0) {
			return 0;
		}
		int cols = matrix[0].length;
		if (cols == 0) {
			return 0;
		}
		
		int[][] dpLeftUp = doLeftUp(matrix, rows, cols);
		int[][] dpRightDown = doRightDown(matrix, rows, cols);
		return merge(dpLeftUp, dpRightDown, rows, cols);
	}
	
	private static int[][] doLeftUp(int[][] matrix, int rows, int cols){
		int[][] dpLeft = new int[rows][cols];
		int[][] dpUp = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j< cols; j++) {
				if (matrix[i][j] == 1) {
					if (i == 0 && j == 0) {
						dpLeft[i][j] = 1;
						dpUp[i][j] = 1;
					} else if (i == 0) {
						dpUp[i][j] = 1;
						dpLeft[i][j] = dpLeft[i][j - 1] + 1;
					} else if (j == 0) {
						dpLeft[i][j] = 1;
						dpUp[i][j] = dpUp[i - 1][j] + 1;
					} else {
						dpLeft[i][j] = dpLeft[i][j - 1] + 1;
						dpUp[i][j] = dpUp[i - 1][j] + 1;
					}
				}
			}
		}
		merge(dpLeft, dpUp, rows, cols);
		return dpLeft;
	}
	
	private static int[][] doRightDown(int[][] matrix, int rows, int cols){
		int[][] dpRight = new int[rows][cols];
		int[][] dpDown = new int[rows][cols];
		for (int i = rows - 1; i >= 0; i--) {
			for (int j = cols - 1; j >= 0; j--) {
				if (matrix[i][j] == 1) {
					if (i == rows - 1 && j == cols - 1) {
						dpRight[i][j] = 1;
						dpDown[i][j] = 1;
					} else if (i == rows - 1) {
						dpDown[i][j] = 1;
						dpRight[i][j] = dpRight[i][j + 1] + 1;
					} else if (j == cols - 1) {
						dpRight[i][j] = 1;
						dpDown[i][j] = dpDown[i + 1][j] + 1;
					} else {
						dpRight[i][j] = dpRight[i][j + 1] + 1;
						dpDown[i][j] = dpDown[i + 1][j] + 1;
					}
				}
			}
		}
		merge(dpRight, dpDown, rows, cols);
		return dpRight;
	}
	
	private static int merge(int[][] m1, int[][] m2, int rows, int cols) {
		int max = 0;
		for(int i = 0 ; i < rows ; i++) {
			for (int j = 0 ; j < cols ; j++) {
				m1[i][j] = Math.min(m1[i][j], m2[i][j]);
				max = Math.max(max, m1[i][j]);
			}
		}
		return max;
	}
	
	
	
	
	
	
	  //DP
	  //Base case: 
	  //upLeft[0][j] = matrix[0][j]
	  //upLeft[i][0] = matrix[i][0]
	  //upRight[0][j] = matrix[0][j]
	  //..
	  //downLeft[n - 1][j] = matrix[n - 1][j]
	  //..
	  //upLeft[n - 1][j] = matrix[n -1][j]
	  //..
	  //Induction Rule: 
	  //upLeft[i][j] = upLeft[i - 1][j - 1] + 1 where upLeft[i][j] = 1;
	  //upLeft[i][j] = 0 where upLeft[i][j] = 0;
	  //..
	  public int largest1(int[][] matrix) {
	    int len1 = matrix.length;
	    if (len1 == 0) {
	      return 0;
	    }
	    int len2 = matrix.length;
	    if (len2 == 0) {
	      return 0;
	    }
	    int[][] upLeft = upLeft(matrix,len1,len2);
	    int[][] upRight = upRight(matrix,len1,len2);
	    int[][] downLeft = downLeft(matrix,len1,len2);
	    int[][] downRight = downRight(matrix,len1,len2);
	    int globalMax = 0;
	    for(int i = 0; i < len1; i++) {
	      for(int j = 0; j < len2; j++) {
	        upLeft[i][j] = Math.min(upLeft[i][j], upRight[i][j]);
	        upLeft[i][j] = Math.min(upLeft[i][j], downLeft[i][j]);
	        upLeft[i][j] = Math.min(upLeft[i][j], downRight[i][j]);
	        globalMax = Math.max(globalMax, upLeft[i][j]);
	      }
	    }
	    return globalMax;
	  }
	  private int[][] upLeft(int[][] matrix, int len1, int len2) {
	    int[][] dp = new int[len1][len2];
	    for(int i = 0; i < len1; i++) {
	      for(int j = 0; j < len2; j++) {
	        if (i == 0 || j == 0) {
	          dp[i][j] = matrix[i][j];
	        } else if (matrix[i][j] == 1) {
	          dp[i][j] = dp[i - 1][j - 1] + 1;
	        } else {
	          dp[i][j] = 0;
	        }
	      }
	    }
	    return dp;
	  }
	  
	  private int[][] upRight(int[][] matrix, int len1, int len2) {
	    int[][] dp = new int[len1][len2];
	    for(int i = 0; i < len1; i++) {
	      for(int j = len2 - 1; j >= 0; j--) {
	        if (i == 0 || j == len2 - 1) {
	          dp[i][j] = matrix[i][j];
	        } else if (matrix[i][j] == 1) {
	          dp[i][j] = dp[i - 1][j + 1] + 1;
	        } else {
	          dp[i][j] = 0;
	        }
	      }
	    }
	    return dp;
	  }
	  
	  private int[][] downLeft(int[][] matrix, int len1, int len2) {
	    int[][] dp = new int[len1][len2];
	    for(int i = len1 - 1; i >= 0; i--) {
	      for(int j = 0; j < len2; j++) {
	        if (i == len1 - 1 || j == 0) {
	          dp[i][j] = matrix[i][j];
	        } else if (matrix[i][j] == 1) {
	          dp[i][j] = dp[i + 1][j - 1] + 1;
	        } else {
	          dp[i][j] = 0;
	        }
	      }
	    }
	    return dp;
	  }
	  
	  private int[][] downRight(int[][] matrix, int len1, int len2) {
	    int[][] dp = new int[len1][len2];
	    for(int i = len1 - 1; i >= 0; i--) {
	      for(int j = len2 - 1; j >= 0; j--) {
	        if (i == len1 - 1 || j == len2 - 1) {
	          dp[i][j] = matrix[i][j];
	        } else if (matrix[i][j] == 1) {
	          dp[i][j] = dp[i + 1][j + 1] + 1;
	        } else {
	          dp[i][j] = 0;
	        }
	      }
	    }
	    return dp;
	  }
	
}
