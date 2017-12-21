import java.util.LinkedList;
import java.util.List;

/**
 * @author Dexin Wang
 * @Date Dec 6, 2017
 */
public class Solution3 {

	public static void main(String[] args) {
		System.out.println(validParentheses(3));
	}
	//what: find all possible pairs where the the number of left parentheses is more then the number of right parenthese 
	public static List<String> validParentheses(int n) {
		List<String> res = new LinkedList<String>();
		//2. create temporary space to save pair values;
		char[] temp = new char[2*n];
		helper(n, n, 0, temp, res);
		return res;
	}
	//3.recursively check possible pairs.
	private static void helper(int left, int right, int index, char[] temp, List<String> res) {
		//3.1 base case
		if (left == 0 && right == 0) {
			res.add(new String(temp));
			return;
		}
		//3.1 always try left parentheses first
		if (left > 0) {
			temp[index] = '(';
			helper(left - 1, right, index + 1, temp, res);
		}
		//3.2 always check the number of the right parentheses is less equal than the number of the right parentheses
		if (right > left) {
			temp[index] = ')';
			helper(left, right - 1, index + 1, temp, res);
		}
	}
	//Time Complexity: O(1) + O(2) + O(4) + ....O(2^2n) = O(4^n)
	//Space Complexity: O(2n)

}
