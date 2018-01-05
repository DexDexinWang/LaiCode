

public class Solution34 {

	public static void main(String[] args) {
		String input = "aaaabbbbc";
		System.out.println(deDup(input));
	}
	
	/*
	 * Remove adjacent, repeated characters in a given string, 
	 * leaving only two characters for each group of such characters. 
	 * The characters in the string are sorted in ascending order.
	 */
	//what: 
	public static String deDup(String input) {
		if (input == null || input.length() <= 2) {
			return input;
		}
		//define two pointers. 
		//1. all numbers on the left side of i is result for remove steps;
		//2. all numbers on the right side of j is uncheck numbers;
		//3. all numbers between left and right are numbers that should be removed.
		char[] array = input.toCharArray();
		int i = 0;
		int j = 1;
		while (j < array.length) {
			if (array[i] == array[j] && i > 0 && array[i - 1] == array[j] ) {
				j++;
				continue;
			}
			array[++i] = array[j++];
		}
		return new String(array, 0, i + 1);
	}
	//Time Complexity: O(n)
	//Space Complexity: O(n)

}