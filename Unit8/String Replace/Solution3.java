public class Solution3 {

	public static void main(String[] args) {
		String input1 = "dodododo";
		String input2 = "dod";
		String input3 = "T";
		System.out.println(replace(input1,input2,input3));
	}

	public static String replace(String input, String s, String t) {
		StringBuilder sb = new StringBuilder();
		int fromIndex = 0;
		int matchedIndex = input.indexOf(s, fromIndex);
		while (matchedIndex != -1) {
			sb.append(input, fromIndex, matchedIndex).append(t);
			fromIndex = matchedIndex + s.length();
			matchedIndex = input.indexOf(s, fromIndex);
		}
		sb.append(input, fromIndex, input.length());
		return sb.toString();
	}
	// Time Complexity: O(n) 
	// space Complexity: O(n)
}
