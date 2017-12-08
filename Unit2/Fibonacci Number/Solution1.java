
public class Solution1 {

	public static void main(String[] args) {
		System.out.println(fibonacci(6));
	}
	
	//what: calculate fibonacci number iteratively
	public static long fibonacci(int K) {
		//how: 1. corner case
		if (K == 1) {
			return 1;
		} else if (K == 0) {
			return 0;
		}
		
		//2. define two variables for each iteration
		int one = 0;
		int two = 1;
		for ( int i = 2 ; i <= K ; i++) {
			int temp = one + two;
			one = two;
			two = temp;
		}
		return two;
	}
	//Time Complexity: O(n);
	//Space Complexity: O(1);
}