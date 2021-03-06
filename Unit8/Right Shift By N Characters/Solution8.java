
public class Solution8 {

	public static void main(String[] args) {
		String input = "abcdefgh";
		System.out.println(rightShift(input,3));
	}
	
	//what: reverse the part of n characters and keep their orders.
	public static String rightShift(String input, int n) {
		//how: 1. corner case
		if (input == null || input.length() <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		n = n % array.length;
		//2.1 reverse the left part
		reverse(array, 0, array.length - 1 - n);
		//2.2 reverse the right part
		reverse(array, array.length - n, array.length - 1);
		//2.3 reverse all;
		reverse(array, 0, array.length - 1);
		return new String(array);
	}

	private static void reverse (char[] array, int i, int j) {
		while (i < j) {			
			char temp = array[i];
			array[i] = array[j]; 
			array[j] = temp;
			i++;
			j--;
		}
	}
	//Time Complexity: O(n)
	//Space Complexity: O(1) in-place.
}
