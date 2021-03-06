
public class Solution4 {

	public static void main(String[] args) {
		int[][] input = {{1,1,1},{1,1,1},{1,1,0}};
		System.out.println(largest(input));
	}

	/**
	 * Base case: 
	 * 1.M[0][0] = input[0][0]
	 * 2.M[0][j] = input[0][j]
	 * 3.M[i][0] = input[i][0]
	 * Induction rules: 
	 * M[i][j] represents the how large square of 1s in the square from the left corner to the current position. 
	 * 1. M[i][j] = 
	 * Math.min(M[i - 1][j - 1] + 1, 
	 * M[i - 1][j] + 1, M[i][j - 1] + 1)
	 * where input[i][j] == 1
	 * 2. M[i][j] = 0 
	 * @param matrix
	 * @return
	 */
	public static int largest(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int max = 0;
		int[][] dp = new int[rows][cols];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = matrix[i][j];
				} else if (matrix[i][j] == 1) {
					dp[i][j] = Math.min(dp[i - 1][j] + 1, dp[i][j - 1] + 1);
					dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + 1);
				}
				max = Math.max(max, dp[i][j]);
			}
		}
		return max;
	}
	//Time complexity: O(n^2)
	//Space complexity: O(n^2)

}
