import java.util.Arrays;

public class Solution4 {

	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(spiralGenerate(4)));
	}

	public static int[][] spiralGenerate(int n) {
		int[][] matrix = new int[n][n];
		if (n == 0) {
			return matrix;
		}
		spiralGenerate(matrix, 0, n, 1);
		return matrix;
	}
	
	public static void spiralGenerate(int[][] matrix, int offset, int size, int counter) {
		if (size == 0) {
			return ;
		}
		if (size == 1) {
			matrix[offset][offset] = counter;
			return;
		}
		
		for (int i = 0 ; i < size - 1 ; i++) {
			matrix[offset][offset + i] = counter++;
		}
		for (int i = 0 ; i < size - 1 ; i++) {
			matrix[offset + i][size - 1 + offset] = counter++;
		}
		for (int i = size - 1 ; i >= 1 ; i--) {
			matrix[offset + size - 1][offset + i] = counter++ ;
		}
		for (int i = size - 1 ; i >= 1 ; i--) {
			matrix[offset + i][offset] = counter++;
		}
		spiralGenerate(matrix, offset + 1, size - 2, counter);
	}
	//Time complexity: O(n*m);
	//Space complexity: O(n*m);
	
}
