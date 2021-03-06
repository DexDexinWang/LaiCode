
public class Solution6 {

	public static void main(String[] args) {
		int[][] input = {{1,1,1,1},{1,0,0,1},{1,0,0,1},{1,1,1,1}};
		System.out.println(largest(input));
	}

	/***
	 * Base rule: 
	 * Left[0][0] = 
	 * @param matrix
	 * @return
	 */
	private static int largest(int[][] matrix) {
		int max = 0;
		int rows = matrix.length;
		int cols = matrix[0].length;
		int[][] left = new int[rows + 1][cols + 1];
		int[][] up = new int[rows + 1][cols + 1];
		for (int i = 0; i < rows; i++) {
			for (int j = 0; j < cols ; j++) {
				if (matrix[i][j] == 1) {
					left[i + 1][j + 1] = left[i + 1][j] + 1;
					up[i + 1][j + 1] = up[i][j + 1] + 1;
					for (int maxLen = Math.min(left[i+1][j+1],up[i+1][j+1]) ; maxLen >=1 ; maxLen--) {
						if (left[i+2 -maxLen][j+1] >= maxLen && up[i + 1][j+2 - maxLen] >= maxLen) {
							max = Math.max(max, maxLen);
							break;
						}
					}
				}
			}
		}
		return max;
	}
}
