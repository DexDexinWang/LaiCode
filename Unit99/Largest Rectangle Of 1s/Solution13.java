
public class Solution13 {
	public static void main(String[] args) {
		int[][] input = {{0, 0, 0, 0},{1, 1, 1, 1},{0, 1, 1, 1},{1, 0, 1, 1}};
		System.out.println(largest(input));
	}
	
	/**
	 * Base case: 
	 * dpLeft[0][0] = matrix[0][0];
	 * dpLeft[i][0] = matrix[i][0]; 
	 * dpUp[0][0] = matrix[0][0];
	 * dpUp[0][j] = matrix[0][j];
	 * 
	 * Induction Rules:
	 * dpLeft[i][j] = dpLeft[i][j-1] + 1 when matrix[i][j] = 1;
	 * dpUp[i][j] = dpUp[i - 1][j] + 1 when matrix[i][j] = 1;
	 * @param matrix
	 * @return
	 */
	public static int largest(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] dpLeft = new int[rows][cols];
		int[][] dpUp = new int[rows][cols];
		int max = 0;
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (matrix[i][j] == 1) {
					if (i == 0 || j == 0) {
						dpUp[i][j] = 1;
						dpLeft[i][j] = 1;
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
		return 0;
	}

}
