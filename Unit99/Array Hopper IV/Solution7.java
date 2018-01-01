
public class Solution7 {

	public static void main(String[] args) {
		int[] input = {4,2,1,3,0,0};
		System.out.println(minJump(input,2));
	}

	public static int minJump(int[] array, int index) {
		int len = array.length;
		int[] dp = new int[len];
		dp[len - 1] = 0;
		for (int i = len - 2; i >= index ; i--) {
			dp[i] = -1;
			for(int j = i + 1 ; j < len && j <= array[i] + i ; j++) {
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
		return dp[index];
	}

}
