
public class Solution2 {

	public static void main(String[] args) {
		String input = "Google love I";
		System.out.println(reverseWords(input));
	}

	//what: to swap each character in each word, and swap each wrod`s position.
	public static String reverseWords(String input) {
		//how: 1. corner case
		if(input == null || input.length() == 0) {
			return input;
		}
		char[] array = input.toCharArray();
		
		//2. reverse all characters
		reverse(array, 0, array.length - 1);
		
		//3. reverse each words from slow to fast
		int slow = 0;
		for (int fast = 0 ; fast < array.length ; fast++) {
			if (array[fast]!= ' ' && (fast==0 || array[fast - 1] == ' ')) {
				slow = fast;
			}
			if (array[fast] != ' ' && (fast == array.length - 1 || array[fast + 1] == ' ')){
				reverse(array, slow, fast);
			}
		}
		return new String(array);
	}
	
	//reverse letters from i to j
	private static void reverse (char[] array, int i, int j) {
		while (i < j) {			
			char temp = array[i];
			array[i] = array[j]; 
			array[j] = temp;
			i++;
			j--;
		}
	}
	//Time Complexity: O(n/2) + O(n/2) = O(n)
	//Space Complexity: O(n);
}
