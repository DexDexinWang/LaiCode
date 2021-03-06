
public class Solution8 {

	public static void main(String[] args) {
		String input1 = "laioffercom";
		String input2 = "l10";
		System.out.println(match1(input1,input2));
	}
	
	public static boolean match(String input, String pattern) {
		return match(0, 0, input, pattern);
	}
	
	//what: recursively check each character and each number from input to pattern.
	private static boolean match(int p1, int p2, String input, String pattern) {
		//how: 1. corner case
		if (p1 == input.length() && p2 == pattern.length()) {
			return true;
		} else if (p1 >= input.length() || p2 >= pattern.length()) {
			return false;
		}
		//2.1 check characters
		if (pattern.charAt(p2) < '0' && pattern.charAt(p2) > '9') {
			if (pattern.charAt(p2) == input.charAt(p1)) {
				return match(p1 + 1, p2 + 1, input, pattern);
			} else {
				return false;
			}
		}
		//2.2 check numbers
		int counter = 0;
		while (p2 < pattern.length() && pattern.charAt(p2) >= '0' && pattern.charAt(p2) <= '9' ) {
			counter = counter * 10 + pattern.charAt(p2) - '0';
			p2++;
		}
		return match(p1 + counter, p2, input, pattern);
	}
	//Time complexity: O(n);
	//Space complexity: O(n) call stacks;

	//what: iteratively check each character and each number from input to pattern.
	private static boolean match1(String input, String pattern) {
		int i = 0;
		int j = 0;
		//how: compare each character character or number
		while (i < pattern.length() && j < input.length()) {
			if (i >= input.length()) {
				return false;
			}
			//compare characters
			if (pattern.charAt(i) < '0' || pattern.charAt(i) > '9') {
				if (pattern.charAt(i) == input.charAt(j)) {
					i++;
					j++;
				} else {
					return false;
				}
			} else {
				//compare numbers
				int count = 0;
				while (i < pattern.length() && pattern.charAt(i) >= '0' && pattern.charAt(i) <= '9') {
					count = count * 10 + (pattern.charAt(i) - '0');
					i++;	
				}
				j +=count;
			}
		}
		
		if (i == pattern.length() && j == input.length()) {
			return true;
		}
		return false;
	}
	//Time complexity: O(n);
	//Space complexity: O(1);
	
}
