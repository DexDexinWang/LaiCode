import java.util.Arrays;

public class Solution2 {

	public static void main(String[] args) {
		Solution2  s = new Solution2();
		int[] input = new int[]{-1};
		System.out.println(Arrays.toString(s.largestSum(input)));
	}
	 //DP
	  //dp[i] represents the maximum sum from kth element to ith element include i;
	  //dp[0] = array[0];
	  //dp[i] = dp[i - 1] + array[i] if dp[i - 1] >=0
	  //dp[i] = array[i]
	  public int[] largestSum(int[] array) {
	    int[] res = new int[]{Integer.MIN_VALUE, 0, 0};
	    int begin = 0;
	    int curSum = array[0];
	    for (int i = 1; i < array.length; i++) {
	      if (curSum < 0) {
	         curSum = array[i];
	         begin = i;
	      } else {
	        curSum += array[i];
	      }
	      if (curSum > res[0]) {
	        res[0] = curSum;
	        res[1] = begin;
	        res[2] = i;
	      }
	    }
	    return res;
	  }
	  //Time complexity: O(n);
	  //Space complexit: O(n);
}
