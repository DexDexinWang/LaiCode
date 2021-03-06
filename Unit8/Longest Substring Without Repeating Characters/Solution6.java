import java.util.HashSet;
import java.util.Set;

public class Solution6 {

	public static void main(String[] args) {
		String input = "123123a123";
		System.out.println(longest(input));
	}
	//what: find the adjacent longest string with a window 
	public static int longest(String input) {
		//how: 1. corner
		if(input == null || input.length() ==0) {
			return -1;
		}
		//2. define two points and one set.
		int max = 0;
		int slow = 0;
		int fast = 0;
		Set<Character> set = new HashSet<Character>();
		//3. iterate all character.
		while (fast < input.length()) {
			//3.1 find the duplicated character
			//3.2 find a new character
			if(set.contains(input.charAt(fast))) {
				set.remove(input.charAt(slow++));
			} else {
				set.add(input.charAt(fast++));
				max = Math.max(max, fast - slow);
			}
		}
		return max;
	}
	//time complexity: O(n)
	//space complexity: O(n)
}
