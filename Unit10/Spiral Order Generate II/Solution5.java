import java.util.Arrays;

public class Solution5 {

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString( spiralGenerate(4,5)));
	}
	
	public static int[][] spiralGenerate(int m, int n) {
		int[][] matrix = new int[m][n];
		if (m == 0) {
			return matrix;
		}
		spiralGenerate(matrix, 0, m - 1, 0, n - 1, 1);
		return matrix;
	}

	private static void spiralGenerate(int[][] matrix, int up, int down, int left, int right, int counter) {
		if (left > right || up > down) {
			return ;
		}
		if (left == right) {
			for (int i = up ; i <= down ; i++) {
				matrix[i][left] = counter++;
			}
			return;
		} else if (up == down) {
			for (int i = left ; i <= right ; i++) {
				matrix[up][i] = counter ++;
			}
			return;
		}
		for (int i = left ; i <= right ; i++) {
			matrix[up][i] = counter++;
		}
		for (int i = up + 1 ; i <= down - 1 ; i++) {
			matrix[i][right] = counter++;
		}
		for (int i = right ; i >= left ; i--) {
			matrix[down][i] = counter++;
		}
		for (int i = down - 1 ; i >= up + 1 ; i--) {
			matrix[i][left] = counter++;
		}
		spiralGenerate(matrix, up + 1, down - 1, left + 1, right - 1, counter);
	}
}
