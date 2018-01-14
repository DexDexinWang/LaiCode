
public class Solution2 {

	public static void main(String[] args) {
		System.out.println(power(2,4));
	}
	  //approach: use recursion to solve this problem.
	  //base case: power (a , 1) = a
	  //recursion rule: power (a, b) = power(a, b/2) * power(a, b/2);
	  
	  public static long power(int a, int b) {
	    //base case;
	    if (b == 1) {
	      return a;
	    }
	    if (b == 0) {
	      return 1;
	    }
	    //get half
	    long half = power(a, b/2);
	    //consider odd number for b
	    return b % 2 == 1 ? half * half * a : half * half;
	  }
	//Time Complexity: O(logb)
	//Space Complexity: O(logn)
}
