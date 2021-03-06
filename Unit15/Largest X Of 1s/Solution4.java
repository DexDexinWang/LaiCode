
public class Solution4 {

	public static void main(String[] args) {
		int[][] input = { {0, 0, 0, 0},

				  {1, 1, 1, 1},

				  {0, 1, 1, 1},

				  {1, 0, 1, 1} };
		System.out.println(largest(input));
	}

	/***
	 * Base case: 
	 * dpUpLeft[0][0] = matrix[0][0];
	 * dpUpLeft[i][0] = matrix[i][0];
	 * dpUpLeft[0][j] = matrix[0][j];
	 * dpUpRight[0][0] = matrix[0][0];
	 * dpUpRight[i][0] = matrix[i][0];
	 * dpUpRight[0][j] = matrix[0][j];
	 * dpDownLeft[rows - 1][cols - 1] = matrix[rows - 1][cols - 1];
	 * dpDownLeft[i][cols - 1] = matrix[i][cols - 1];
	 * dpDownLeft[rows - 1][j] = matrix[rows - 1][j];
	 * dpDownRight[rows - 1][cols - 1] = matrix[rows - 1][cols - 1];
	 * dpDownRight[i][cols - 1] = matrix[i][cols - 1];
	 * dpDownRight[rows - 1][j] = matrix[rows - 1][j];
	 * 
	 * Induction Rules:
	 * dpUpLeft[i][j] represents the maximum arm from upper left side to current position. 
	 * dpUpLeft[i][j] = dpUpLeft[i - 1][j - 1] + 1		where matrix[i][j] = 1   
	 * dpUpRight[i][j] represents the maximum arm from upper right side to current position. 
	 * dpUpRight[i][j] = dpUpRight[i - 1][j + 1] + 1		where matrix[i][j] = 1
	 * dpDownLeft[i][j] represents the maximum arm from down left side to current position. 
	 * dpDownLeft[i][j] = dpDownLeft[i + 1][j - 1] + 1		where matrix[i][j] = 1
	 * dpDownRight[i][j] represents the maximum arm from down left side to current position. 
	 * dpDownRight[i][j] = dpDownRight[i + 1][j + 1] + 1		where matrix[i][j] = 1  
	 * @param matrix
	 * @return
	 */
	public static int largest(int[][] matrix) {
		int rows = matrix.length;
		if (rows == 0 ) {
			return 0;
		}
		int cols = matrix[0].length; 
		if (cols == 0) {
			return 0;
		}
		
		int[][] dpUpLeft = createUpLeft(matrix, rows, cols);
		int[][] dpUpRight = createUpRight(matrix, rows, cols);
		int[][] dpDownLeft = createDownLeft(matrix, rows, cols);
		int[][] dpDownRight = createDownRight(matrix, rows, cols);
		
		int max = merge(dpUpLeft, dpUpRight, dpDownLeft, dpDownRight, rows, cols);
		return max;
	}
	
	private static int merge(int[][] m1, int[][] m2, int[][] m3, int[][] m4, int rows, int cols){
		int max = 0;
		for (int i = 0 ; i < rows ; i++) {
			for (int j = 0 ; j < cols ; j++) {
				m1[i][j] = Math.min(m1[i][j], m2[i][j]);
				m3[i][j] = Math.min(m3[i][j], m4[i][j]);
				m1[i][j] = Math.min(m1[i][j], m3[i][j]);
				max = Math.max(max, m1[i][j]);
			}
		}
		return max;
	}
	
	private static int[][] createUpLeft(int[][] matrix, int rows, int cols){
		int[][] dpUpLeft = new int[rows][cols];
		for(int i = 0 ; i < rows; i++) {
			for(int j = 0; j < cols; j++) {
				if (matrix[i][j] == 1) {
					if (i == 0 || j == 0) {
						dpUpLeft[i][j] = 1;
					} else {
						dpUpLeft[i][j] = dpUpLeft[i - 1][j - 1] + 1;
					}
				}
			}
		}
		return dpUpLeft;
	}
	private static int[][] createUpRight(int[][] matrix, int rows, int cols){
		int[][] dpUpRight = new int[rows][cols];
		for(int i = 0 ; i < rows; i++) {
			for(int j = cols - 1; j >= 0; j--) {
				if (matrix[i][j] == 1) {
					if (i == 0 || j == cols - 1) {
						dpUpRight[i][j] = 1;
					} else {
						dpUpRight[i][j] = dpUpRight[i - 1][j + 1] + 1;
					}
				}
			}
		}
		return dpUpRight;
	}
	
	private static int[][] createDownLeft(int[][] matrix, int rows, int cols){
		int[][] dpDownLeft = new int[rows][cols];
		for(int i = rows - 1 ; i >= 0; i--) {
			for(int j = 0; j < cols; j++) {
				if (matrix[i][j] == 1) {
					if (i == rows - 1 || j == 0) {
						dpDownLeft[i][j] = 1;
					} else {
						dpDownLeft[i][j] = dpDownLeft[i + 1][j - 1] + 1;
					}
				}
			}
		}
		return dpDownLeft;
	}
	
	private static int[][] createDownRight(int[][] matrix, int rows, int cols){
		int[][] dpDownRight = new int[rows][cols];
		for(int i = rows - 1 ; i >= 0; i--) {
			for(int j = cols - 1; j >= 0; j--) {
				if (matrix[i][j] == 1) {
					if (i == rows - 1 || j == cols - 1) {
						dpDownRight[i][j] = 1;
					} else {
						dpDownRight[i][j] = dpDownRight[i + 1][j + 1] + 1;
					}
				}
			}
		}
		return dpDownRight;
	}
}
