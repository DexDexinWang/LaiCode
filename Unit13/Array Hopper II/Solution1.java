
public class Solution1 {

	public static void main(String[] args) {
		int[] input = {4,2,1,2,0,0};
		System.out.println(minJump(input));
	}
	
	/**
	 * Base Case: M[len - 1] = 0;
	 * Induction Rules: 
	 * 1. M[i] = the minimum number of steps to move from ith to nth position.
	 * 2. M[i] = min(M[j]) +1   where j > i and j can be reached from i by only one jump. 
	 * @param array
	 * @return
	 */
	public static int minJump(int[] array) {
		if (array.length == 1) {
			return 0;
		}
		int len = array.length;
		int[] M = new int[len];
		M[len - 1] = 0;
		for (int i = array.length -2 ; i >= 0 ; i--) {
			M[i] = -1;
			for (int j = i + 1; j <= array[i] + i && j < array.length; j++) {
				if (M[i] == -1) { 
					M[i] = M[j];
				} else if (M[j] != -1 && M[i] > M[j]) {
					M[i] = M[j];
				}
			}
			if (M[i] != 0) {
				M[i]++;
			}
		}
		return M[0];
	}


}