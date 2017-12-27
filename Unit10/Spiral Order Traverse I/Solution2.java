import java.util.ArrayList;
import java.util.List;

public class Solution2 {

	public static void main(String[] args) {
		int[][] input = {{1,2},{3,4}}; //{{1,2,3},{4,5,6},{7,8,9}};
		System.out.println(spiral(input));
		System.out.println(spiral1(input));
	}
	//what: it iteratively traverse nodes from outer most cycle to inner most cycle.
	public static List<Integer> spiral1(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		int n =matrix.length;
		int start = 0;
		int end = n - 1;
		while (start < end) {
			for (int i = start ; i <= end ; i++) {
				res.add(matrix[start][i]);
			}
			for (int i = start + 1 ; i <= end - 1 ; i++) {
				res.add(matrix[i][end]);
			}
			for (int i = end ; i >= start ; i--) {
				res.add(matrix[end][i]);
			}
			for (int i = end - 1 ; i >= start + 1; i--) {
				res.add(matrix[i][start]);
			}
			start++;
			end--;
		}
		if (start == end) {
			res.add(matrix[start][end]);
		}
		return res;
	}
	//Time complexity: O(n);
	//Space Complexity: O(n);
	
	//what: it traverses each node from the outer most cycle to the inner most cycle recursively.
	public static List<Integer> spiral(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		spiralHelper(matrix, 0, matrix.length, res);
		return res;
	}
	
	private static void spiralHelper(int[][] matrix, int offset, int size, List<Integer> res) {
		//1. base case  
		if (size == 0) {
			return;
		}
		if (size == 1) {
			res.add(matrix[offset][offset]);
			return;
		}
		
		//2. print the numbers in the current cycle 
		for (int i = 0 ; i < size - 1; i++) {
			res.add(matrix[offset][offset + i]);
		}
		for (int i = 0; i < size - 1; i++) {
			res.add(matrix[offset + i][size - 1 + offset]);
		}
		for (int i = size - 1 ; i > 0 ; i--) {
			res.add(matrix[offset + size - 1][i + offset]);
		}
		for (int i = size - 1 ; i > 0 ; i--) {
			res.add(matrix[i + offset][offset]);
		}
		//3. trying to solve next inner cycle where matrix size - 2 , and offerset + 1;
		spiralHelper(matrix, offset + 1, size - 2, res);
	}
	
	//Time complexity: O(n);
	//Space Complexity: O(n);
}
