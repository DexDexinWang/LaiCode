
public class Solution6 {
	public static void main(String[] args) {
		int[] input = {4,2,1,3,0,0};
		System.out.println(minJump(input));
	}
	/**
	 * Base case: dp[n] == 0;
	 * Induction Rule: 
	 * dp[i] represents the minimum steps could jump out of the array.
	 * dp[i] = min{dp[j]} + 1 where j > i that 0 <= j <= array[i] + i;
	 * @param array
	 * @return
	 */
	public static int minJump(int[] array) {
		int len = array.length;
		int[] dp = new int[len + 1];
		dp[len] = 0;
		for (int i = len - 1; i >= 0 ; i--) {
			dp[i] = -1;
			for (int j = i + 1 ; j <= len && j <= array[i] + i ; j++) {
				if (dp[i] == -1) {
					dp[i] = dp[j];
				} else if (dp[j] != -1 && dp[j] < dp[i]) {
					dp[i] = dp[j];
				}
			}
			if(dp[i] != -1) {
				dp[i]++;
			}
		}
		return dp[0];
	}

}
