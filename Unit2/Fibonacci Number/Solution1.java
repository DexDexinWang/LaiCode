
public class Solution1 {

	public static void main(String[] args) {
		System.out.println(fibonacci(6));
	}
	
	  //approach: regard it as dynamic problem.
	  //base case: dp[0]= 0; dp[1] =1; dp[2] = 2;
	  //Induction Rule: dp[i] represent the fibonacci number of ith.
	  //dp[i] = dp[i - 1] + dp[i - 2];
	  public static long fibonacci(int K) {
	    //corner case;
	    if (K <= 0) {
	      return 0;
	    } else if (K == 1) {
	      return 1;
	    }
	    //save dp[i - 2];
	    long prevPrev = 0;
	    //save dp[i - 1];
	    long prev = 1;
	    for (int i = 2; i <= K; i++) {
	      long temp = prevPrev + prev;
	      prevPrev = prev;
	      prev = temp;
	    }
	    return prev;
	  }
	//Time Complexity: O(n);
	//Space Complexity: O(1);
}
