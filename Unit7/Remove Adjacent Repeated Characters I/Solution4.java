
/**
 * @author Dexin Wang
 * @Date Dec 5, 2017
 */
public class Solution4 {

	public static void main(String[] args) {
		String input = "aaaabbbcccccdddd";
		System.out.println(deDup(input));
	}
	//what: find each adjacent repeated character and keep it once.
	public static String deDup(String input) {
		//how: 1. corner case
		if (input == null || input.length() == 0) {
			return input;
		}
		//2. iterate each character to find the adjacent repeated character 
		char[] array = input.toCharArray();
		int slow = 0;
		int fast = 1;
		while (fast < array.length) {
			//3. ignore the same character
			if (array[slow] == array[fast]) {
				fast++;
			} else {
				array[++slow] = array[fast++];
			}
		}
		return new String(array, 0, slow+1);
	}
	//Time Complexity: O(n)
	//Space Complexity: O(1) in-place
}
