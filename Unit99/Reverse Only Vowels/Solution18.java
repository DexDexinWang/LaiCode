
public class Solution18 {

	public static void main(String[] args) {
		System.out.println(reverse("reverse"));
	}
	//what: reverse vowels(a,e,i,o,u) in the given string.
	public static String reverse(String input) {
		//how: 1. corner case;
		if (input == null || input.length() <= 1) {
			return input;
		}
		//2. define a char array and two pointers in order to reverse  
		char[] array = new char[input.length()];
		int i = 0; 
		int j = array.length - 1;
		//3. check each character
		while (i < j) {
			if (!check(array[i])) {
				i++;
			} else if (!check(array[j])) {
				j++;
			} else {
				swap(array, i, j);
			}
		}
		//4. return.
		return new String(array);
	}

	private static void swap(char[] array, int i , int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	private static boolean check(char ch) {
		if(ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch=='u') {
			return true;
		}
	    return false;
	}
	//Time complexity: O(n);
	//Space complexity: O(n);
}
