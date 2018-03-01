import java.util.ArrayList;
import java.util.List;

public class Solution1 {
	public static void main(String[] args) {
		Solution1 s = new Solution1();
		int[] input = new int[]{10,11,1,2,12,3,4};
		System.out.println(s.longest(input));
	}
	  //DP
	  //dp[i] represents the longest subsequence from 0th to ith elements (include ith).
	  //base case: dp[0] = 1;
	  //induction rule: dp[i] = max(dp[k]) + 1 where array[k] < array[i]
	  public int longest1(int[] array) {
	  	if (array.length <= 1) {
	      return array.length;
	    }
	    //create an array to store values for DP
	    int[] dp = new int[array.length];
	    dp[0] = 1;
	    int max = 1;
	    for(int i = 1; i < array.length; i++) {
	      dp[i] = 1;
	      for(int k = 0; k < i; k++) {
	        if (array[k] < array[i] && dp[k] + 1 > dp[i]) {
	          dp[i] = dp[k] + 1;
	          max = Math.max(max,dp[i]);
	        }
	      }
	    }
	    return max;
	  }
	  //Time complexity: O(n^2)
	  //Space complexity: O(n^2)
	  
	  //dp[i] represets the 
	  public int longest(int[] array) {
		  if (array.length <= 1) {
			  return array.length;
		  }
		   //create an array to store values for DP
		  int[] dp = new int[array.length + 1];
		  dp[1] = array[0];
		  int end = 1;
		  for(int i = 1; i < array.length; i++) {
		     int index = findClosest(array[i], dp, 1 ,end);
		     if (index == end){
		    	 dp[++end] = array[i];
		     } else {
		    	 dp[index + 1]  = array[i];
		     }
		  }
		  return end;
	  }
	  
	  private int findClosest(int target, int[] array, int left, int right) {
		  while (left <= right) {
			  int mid = left + (right - left) / 2;
			  if (array[mid] >= target) {
				right = mid - 1;
			  } else {
				left = mid + 1;
			  }
		  }
		  return right;
	  }
	  //time complexity: O(n*logn);
	  //Space compelxity:O(n);
}
