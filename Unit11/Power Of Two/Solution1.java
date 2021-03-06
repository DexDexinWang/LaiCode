
public class Solution1 {
	public static void main(String[] args) {
		int input = 16;
		System.out.println(isPowerOfTwo(input));
	}
	
	//what: consider a number is power of 2 in two ways: 
	//1. consider the number is positive number
	//2. count the number of 1 that is only 1 time.
	public static boolean isPowerOfTwo(int number) {
		//return number > 0 && count(number) == 1;
		return number > 0  && count1(number) == 1;
	}
	
//	private static int count(int number) {
//		int counter = 0;
//		for (int i = 0 ; i < 31 ; i++) {
//			counter += (number & 1);
//			number = number >> 1;
//		}
//		return  counter;
//	}
	//count 1s only for positive number. could finish early.
	private static int count1(int number) {
		int counter = 0;
		while (number > 0) {
			counter += (number & 1);
			number = number >> 1;
		}
		return  counter;
	}
	
	//Time Complexity: O(32) = O(1)
	//Space Complexity: O(1)
	
	public static boolean isPowerOfTwo1(int number) {
		return ( (number & (number-1)) == 0 && number > 0);
	}
	//Time Complexity: O(1)
	//Space Complexity: O(1);
	
}
