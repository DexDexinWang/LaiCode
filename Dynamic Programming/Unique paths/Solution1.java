
public class Solution1 {

	public static void main(String[] args) {
		System.out.println(uniquePaths(3,5));
	}

	/**
	 * Base case:
	 * dp[i][j] = 1 where i = 0 || j = 0;
	 * Induction case:
	 * dp[i][j] represents how many ways could arriave dp[i][j] from dp[0][0];
	 * dp[i][j] = dp[i][j-1] + dp[i - 1][j] 
	 * @param m
	 * @param n
	 * @return
	 */
	public static int uniquePaths(int m, int n) {
		int[][] matrix = new int[m][n];
		for (int i = 0 ; i < m ; i++) {
			for (int j = 0 ; j < n ; j++) {
				if (i == 0 && j == 0) {
					matrix[i][j] = 1;
				} else {
					matrix[i][j] = matrix[i][j - 1] + matrix[i - 1][j];
				}
				
			}
		}
		return matrix[m - 1][n - 1];
	}

	//Time complexity:O(n^2);
	//Space complexity:O(n^2);
}
