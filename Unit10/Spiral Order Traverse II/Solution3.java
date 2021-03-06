import java.util.ArrayList;
import java.util.List;

public class Solution3 {

	public static void main(String[] args) {
		int[][] input = {{1,2,3,4},{5,6,7,8},{9,10,11,12}};
		System.out.println(spiral(input));
		System.out.println(spiral1(input));
	}
	//what: iteratively traverse nodes from the outer most cycle to inner most cycle.
	public static List<Integer> spiral1(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		//define boundaries
		int left = 0; 
		int right = matrix[0].length - 1;
		int up = 0;
		int down = matrix.length - 1;
		//check each cycles
		while (left < right && up < down) {
			for (int i = left ; i <= right ; i++) {
				res.add(matrix[up][i]);
			}
			for (int i = up + 1 ; i <= down - 1 ; i++) {
				res.add(matrix[i][right]);
			}
			for (int i = right ; i >= left ; i--) {
				res.add(matrix[down][i]);
			}
			for (int i = down - 1 ; i >= up + 1 ; i--) {
				res.add(matrix[i][left]);
			}
			left++;
			up++;
			right--;
			down--;	
		}
		//check there is no element left;
		if (left > right || up > down) {
			return res;
		}
		//if there is a row or a column or an element then add them.
		if (left == right) {
			for (int i = up; i <= down; i++) {
				res.add(matrix[i][left]);
			}
		}
		else {
			for (int i = left; i <= right; i++) {
				res.add(matrix[up][i]);
			}
		}
		return res;
	}
	//Time complexity: O(n*m);
	//Space complexity: O(n*m);
	

	public static List<Integer> spiral(int[][] matrix) {
		List<Integer> res = new ArrayList<Integer>();
		if (matrix.length == 0) {
			return res;
		}
		spiralHelper(matrix, 0, matrix.length - 1, 0, matrix[0].length - 1, res);
		return res;
	}
	
	public static void spiralHelper(int[][] matrix, int up, int down, int left, int right, List<Integer> res) {
		if (left > right || up > down) {
			return ;
		}
		if (left == right) {
			for (int i = up ; i <= down ; i++) {
				res.add(matrix[i][left]);
			}
			return;
		} else if (up == down) {
			for (int i = left ; i <= right ; i++) {
				res.add(matrix[up][i]);
			}
			return;
		}
		for (int i = left ; i <= right ; i++) {
			res.add(matrix[up][i]);
		}
		for (int i = up + 1 ; i <= down - 1 ; i++) {
			res.add(matrix[i][right]);
		}
		for (int i = right ; i >= left ; i--) {
			res.add(matrix[down][i]);
		}
		for (int i = down - 1; i >= up + 1 ; i--) {
			res.add(matrix[i][left]);
		}
		spiralHelper(matrix, up + 1, down - 1, left + 1 , right - 1 , res);
	}
	//Time complexity: O(n*m);
	//Space complexity: O(n*m);
	
}
