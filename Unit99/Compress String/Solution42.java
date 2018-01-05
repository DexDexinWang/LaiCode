
public class Solution42 {

	public static void main(String[] args) {
		String input = "aabcddefffghhhh";
		System.out.println(compress(input));
	}
	//what: compress a string and change the repeated character format into a new string
	public static String compress(String input) {
		//how: 1. corner case.
		if (input.length() <= 1) {
			return input;
		}
		//2. define tow pointers.
		//left slow, all characters are compressed in the left side of slow.
		//right fast, all characters will be compressed in the right side of fast.
		//between slow and fast, all characters are unuseful.
		char[] array = input.toCharArray();
		int slow = 0;
	    int fast = 0;
	    //3. make a loop check all characters.
	    while (fast < array.length) {
	    	if (slow==0 || array[fast] != array[fast - 1]) {
	    	array[slow++] = array[fast++];
			} else {
				int counter = 2;
			    while(fast + 1 < array.length && array[fast] == array[fast + 1]) {
			    	counter++;
			        fast++;
			    }
			    fast++;
			    array[slow++] = (char)(counter + '0');
			}
		}
	    return new String(array, 0, slow);
	}
	//Time complexity: O(n);
	//Space complexity: O(n);
}
