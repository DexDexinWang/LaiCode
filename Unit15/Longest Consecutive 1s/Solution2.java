
public class Solution2 {

	public static void main(String[] args) {
		int[] input = {0,1,1,1,0,1,0,1,0,1,1};
		System.out.println(longest(input));
	}
	
	/**
	 * base case: 
	 * dp[0] = array[0]
	 * induction rule:
	 * dp[i] represents the number of largest consecutive 1s
	 * dp[i] = dp[i - 1] + array[i] where array[i] = 1
	 * 		 = 0					otherwise
	 * @param array
	 * @return
	 */
	public static int longest(int[] array) {
		if (array.length == 0) {
			return 0;
		}
		int prev = 0;
		int max = 0;
		for(int i = 0 ; i < array.length ; i++) {
			if(array[i] == 1) {
				prev++;
				max = Math.max(max, prev);
			} else {
				prev = 0;
			}
		}
		return max;
	}
	//Time complexity: O(n)
	//Space complexity: O(1)
}
