
/**
 * @author Dexin Wang
 * @Date Dec 5, 2017
 */
public class Solution8 {
	//remove all leading/trailing/duplicate space characters
	public static void main(String[] args) {
		String input = "I Love Yahoo[]";
		System.out.println(removeSpaces1(input));
	}
	
	//what: 1. find each word 2. add space for each word except the first word  
	public static String removeSpaces(String input) {
		//how: 1. corner case
		if (input.length() == 0) {
			return input;
		}
		//2. make a loop find each word
		char[] array = input.toCharArray();
		int slow = 0; 
		int fast = 0;
		int counter = 0;
		while (true) {
			while (fast < array.length && array[fast]==' ') {
				fast ++;
			}
			if (fast == array.length) {
				break;
			}
			if (counter > 0) {
				array[slow++] = ' ';
			}
			while (fast < array.length && array[fast]!=' ') {
				array[slow++] = array[fast++];
			}
			counter++;
		}
		return new String(array, 0, slow);
	}
	//Time Complexity: O(n)
	//Space Complexity: O(n)
	
	//what: check each character and decide whether it should be igrnored.  
	public static String removeSpaces1(String input) {
		//how: 1. corner case
		if (input.length() == 0) {
			return input;
		}
		//2. make a loop to check each character
		char[] array = input.toCharArray();
		int slow = 0; 
		for (int fast = 0 ; fast < array.length ; fast++) {
			//check whether it should be igrnoed.
			if (array[fast] == ' ' && (fast == 0 || array[fast - 1] == ' ')){
				continue;
			}
			array[slow++] = array[fast]; 
		}
		//3. to check tail
		if (slow > 0 && array[slow-1] == ' ') {
			return new String(array, 0, slow -1);
		}
		return new String(array, 0, slow);
	}
	//Time Complexity: O(n)
	//Space Complexity: O(n)

}
