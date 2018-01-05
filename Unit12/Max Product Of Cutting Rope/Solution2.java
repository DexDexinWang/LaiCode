
public class Solution2 {

	public static void main(String[] args) {
		System.out.println(maxProduct(5));
	}

	/**
	 * Base case: M[1] = 0;  that is invalid, because one meter could not be cut
	 * Induction rule:
	 * 1. M[i] = presents that the max number from multiple cases in one cut.
	 * 2. M[i] = max(case1, case2, case .... case[i-1]);
	 * @param length
	 * @return
	 */
	public static int maxProduct(int length) {
		if (length <= 1) {
			return 0;
		}
		int[] M =new int[length + 1];
		M[0] = 0;
		M[1] = 0;
		for(int i = 1 ; i <= length ; i++) {
			int curMax = 0;
			for (int j = 1; j < i ; j++) {
				curMax = Math.max(curMax, Math.max(M[j], j) * (i - j));
			}
			M[i] = curMax;
		}
		return M[length];
	}
	//Time complexity: O(n^2);
	//Space complexity: O(n);
	
}