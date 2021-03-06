
public class Solution33 {

	public static void main(String[] args) {
		String input = "google/q?flo wer market";
		System.out.println(encode(input));
	}
	/*
	 * In URL encoding, whenever we see an space " ", we need to replace it with "20%". 
	 * Provide a method that performs this encoding for a given string.
	 */
	public static String encode(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < input.length(); i++) {
			if(input.charAt(i) == ' ') {
				sb.append("20%");
			} else {
				sb.append(input.charAt(i));
			}
		}
		return sb.toString();
	}
	//Time complexity: O(n)
	//Space complexity: O(n)
}
