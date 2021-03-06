
public class Solution35 {

	public static void main(String[] args) {
		String input = "abbc";
		System.out.println(deDup(input));
	}
	
	/*
	 * Remove adjacent, repeated characters in a given string, 
	 * leaving no character for each group of such characters. 
	 * The characters in the string are sorted in ascending order.
	 */

	public static String deDup(String input) { 
		if(input == null || input.length() <= 1) {
			return input;
		}
		char[] array = input.toCharArray();
		int i = -1;
		int j = 0;
		while (j < array.length) {
			if (i == - 1 || array[i] != array[j]) {
				array[++i] = array[j++];
			} else {
				//use a count to record whether i should go back.
				int count = 2;
				while(i + 1 < array.length && array[j] == array[j + 1 ]) {
					count++;
					j++;
				}
				if (count >= 2) {
					i--;
				}
				j++;
			}
		}
		return new String(array, 0 , i + 1);
	}
	
	//Time complexity: O(n);
	//Space complexity: O(n);

}
