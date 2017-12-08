
public class Solution7 {

	public static void main(String[] args) {
		String input = "abc";
		System.out.println(reverse(input));
	}

	//what: reverse each character in the string.
	public static String reverse(String input) {
		//how: 1. corner case
		if (input.length() <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		//2. swap each character
		for (int i = 0, j = array.length - 1; i < j; i++ , j--) {
			char temp = array[i];
			array[i] = array[j];
			array[j] = temp;
		}
		return new String(array);
	}
	//Time Complexity: O(n)
	//Space Complexity: O(1) in-place.
}
