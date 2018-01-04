
public class Solution16 {

	public static void main(String[] args) {
		System.out.println(stairs(5));
	}
	
	/**
	 * Base Case:
	 * dp[1] = 1;
	 * dp[2] = 2;
	 * Induction Rule:
	 * dp[i] = dp[i - 1] + dp[i - 2];
	 * @param n
	 * @return
	 */
	public static int stairs(int n) {
		if (n <= 2) {
			return n;
		}
		int[] dp = new int[n + 1];
		dp[1] = 2;
		dp[2] = 3;
		for(int i = 3; i <= n ; i++) {
			dp[i] = dp[i - 1] + dp[i - 2];
		}
		return dp[n];
	}
	
	public static int stairs1(int n) {
		if (n <= 2) {
			return n;
		}
		int one = 1;
		int two = 2;
		for(int i = 3; i <= n ; i++) {
			int temp = one + two;
			one = two;
			two = temp;
		}
		return two;
	}
	//Time complexity: O(n);
	//Space complexity: O(1);
}
