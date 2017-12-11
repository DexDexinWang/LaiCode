import java.util.Arrays;

public class Solution9 {

	public static void main(String[] args) {
		int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(Arrays.toString(search(input, 5)));
	}
	
	//what: find a target in a sorted 2D array with binary search 
	public static int[] search(int[][] matrix, int target) {
		//how: 1. corner case
		if (matrix == null || matrix.length == 0 || matrix[0].length ==0) {
			return new int[0];
		}
		//2. convert the problem as 1D array;
		int rows = matrix.length;
		int cols = matrix[0].length;
		int len = rows * cols;
		//3. traverse the 1D array with binary search
		int left = 0;
		int right = len - 1;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			int row = mid / cols;
			int col = mid % cols;
			if (matrix[row][col] == target) {
				return new int[]{row,col};
			} else if (matrix[row][col] < target) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return new int[0];
	}
	//Time Complexity: O(log(m * n))
	//Space Complexity: O(1)
}
