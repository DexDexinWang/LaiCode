import java.util.ArrayList;
import java.util.List;

public class Solution7 {

	public static void main(String[] args) {
		System.out.println(nqueens(1));
	}

	//what: find all possible permutation for n queens where they are not valid.
	public static List<List<Integer>> nqueens(int n) {
		List<List<Integer>> res= new ArrayList<List<Integer>>();
		List<Integer> cur = new ArrayList<Integer>();
		nqueens(n, cur, res);
		return res;
	}
	
	private static void nqueens(int n, List<Integer> cur, List<List<Integer>> res) {
		//how: 1.base case. n queens has been put in the table. then add current positions into the result. 
		if (cur.size() == n) {
			res.add(new ArrayList<Integer>(cur));
			return;
		}
		//2. try all possible positions.
		for (int i = 0 ; i < n ; i++) {
			//2.1 if the position is not valid, then prone or ignore the next possible siutations.
			if (valid(cur, i)) {
				cur.add(i);
				nqueens(n, cur, res);
				cur.remove(cur.size() - 1);
			}
		}
	}
	
	//compare whether a new position is qulified for the current situation.
	private static boolean valid(List<Integer> cur, int column) {
		int row = cur.size();
		for (int i = 0; i < row ; i++) {
			// in the horizontal or vertical lines.  ||  in the same oblique line. 
			if (cur.get(i) == column || Math.abs(cur.get(i) - column) == row - i) {
				return false;
			}
		}
		return true;
	}
	// Time complexity: O(n£¡ *n);
	// Space complexity: O(n^2);
}
