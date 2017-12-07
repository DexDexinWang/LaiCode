
/**
 * @author Dexin Wang
 * @Date Dec 5, 2017
 */
public class Solution6 {
	public static void main(String[] args) {
		String input = "abbbaaccz";
		System.out.println(deDup(input));
	}
	
	//what: to find duplicated characters and delete all of them, check the remaining characters iteratively 
	public static String deDup(String input) {
		//how: 1. corner case
		if (input == null || input.length() <= 1) {
			return input;
		}
		//2. iterate each character with stack structure.
		int slow = 0;
		int fast = 1;
		char[] array = input.toCharArray();
		
		while(fast < array.length) {
			//2.1. no duplicate and check next;
			//2.2. find the duplicated characters and delete them
			if (slow == -1 || array[fast] != array[slow]) {
				array[++slow] = array[fast++];
			} else {
				slow--;
				while (fast + 1 < array.length && array[fast] == array[fast + 1]) {
					fast++;
				}
				fast++;
			}
		}
		return new String(array, 0, slow + 1);
	}
	//Time Complexity: O(n)
	//Space Complexity: O(1) in-place
	
}
