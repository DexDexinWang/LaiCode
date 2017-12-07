import java.util.HashSet;
import java.util.Set;

/**
 * @author Dexin Wang
 * @Date Dec 5, 2017
 */
public class Solution9 {

	public static void main(String[] args) {
		String input1 = "abccdddazzcda";
		String input2 = "ac";
		System.out.println(remove(input1, input2));
	}

	//what: 1.find the required character.  2.remove the reqired character 
	public static String remove(String input, String t) {
		//how: 1. corner case
		if (input == null || input.length() == 0 || t == null || t.length() == 0) {
			return input;
		}
		//2.convert Strings 
		char[] array = input.toCharArray();
		Set<Character> set = new HashSet<Character>();
		for (int i = 0 ; i < t.length() ; i++) {
			set.add(t.charAt(i));
		}
		//3. find the required character
		int slow = 0; 
		int fast = 0;
		while (fast < array.length) {
			if (set.contains(array[fast])) {
				fast++;
			} else {
				array[slow++] = array[fast++]; 
			}
		}
		//4. return the subset of String
		return new String(array, 0, slow);
	}
	//Time Complexity: O(n)
	//Space Complexity: O(m) for Hash Set, O(1) in-place 

}
