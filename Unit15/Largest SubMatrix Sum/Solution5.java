
public class Solution5 {

	public static void main(String[] args) {
		int[][] input = { {1, -2, -1, 4},

				  {1, -1,  1, 1},

				  {0, -1, -1, 1},

				  {0,  0,  1, 1} };
		System.out.println(largest(input));
	}

	/**
	 * 
	 * @param matrix
	 * @return
	 */
	public static int largest(int[][] matrix) {
		int rows = matrix.length;
		int cols = matrix[0].length;
		int max = Integer.MIN_VALUE;
		for (int i = 0 ; i < rows ; i++) {
			int[] cur = new int[cols];
			for (int j = i ; j < rows; j++) {
				add(cur, matrix[j]);
				max = Math.max(max, max(cur));
			}
		}
		return max;
	}
	
	private static void add(int[] cur, int[] add) {
		for (int i = 0 ; i < cur.length ; i++) {
			cur[i] += add[i];
		}
	}
	
	private static int max(int[] cur) {
		int result = cur[0];
		int temp = cur[0];
		for (int i = 1 ; i < cur.length ; i++) {
			temp = Math.max(temp + cur[i], cur[i]);
			result = Math.max(result, temp);
		}
		return result;
	}
}
