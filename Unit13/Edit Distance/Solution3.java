
public class Solution3 {
	public static void main(String[] args) {
		System.out.println(editDistance("abcd", "dcba"));
	}
	/**
	 * base case: 
	 * 1. matrix[0][0] = 0
	 * 2. matrix[0][j] = j
	 * 3. matrix[i][0] = i
	 * Induction Rule:
	 * M[i][j] represents the minimum steps that the first ith characters of string could be the same of the first jth characters of sting2.
	 * 1. M[i][j] = M[i-1][j-1]		where s1[i-1] == s2[j-1]
	 * 2. M[i][j] = max(M[i-1][j-1] + 1, M[i][j-1] + 1, M[i-1][j] + 1) otherwise;
	 * @param one
	 * @param two
	 * @return
	 */
	public static int editDistance(String one, String two) {
		int len1 = one.length();
		int len2 = two.length();
		if (len1 == 0) {
			return len2;
		} else if (len2 == 0) {
			return len1;
		}
		
		int[][] matrix = new int[len1 + 1][len2 + 1];
		for(int i = 0 ; i <= len1 ; i++) {
			for (int j = 0 ; j <=len2 ; j++) {
				if (i == 0) {
					matrix[i][j] = j;
				} else if (j== 0) {
					matrix[i][j] = i;
				} else if (one.charAt(i - 1) == two.charAt(j - 1)){
					matrix[i][j] = matrix[i - 1][j - 1];
				} else {
					matrix[i][j] = Math.min(matrix[i - 1][j] + 1, matrix[i][j - 1] + 1);
					matrix[i][j] = Math.min(matrix[i - 1][j - 1] + 1, matrix[i][j]);
				}
			}
		}
		return matrix[len1][len2];
	}
	//time complexity: O(n^2)
	//space complexity: O(n^2)
}
