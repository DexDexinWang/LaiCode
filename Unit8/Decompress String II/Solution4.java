
public class Solution4 {

	public static void main(String[] args) {
		System.out.println(decompress("a2b3e4"));
	}

	public static String decompress(String input) {
		StringBuilder sb  = new StringBuilder();
		int index = 0; 
		while (index < input.length()) {
			char temp = input.charAt(index++);
			int times = 0;
			while (index < input.length() && input.charAt(index) >='0' && input.charAt(index) <='9') {
				times = times * 10 + (input.charAt(index) - '0');
				index++;
			}
			for (int i = 0; i < times; i++) {
				sb.append(temp);
			}
		}
		return sb.toString();
	}
	//Time Complexity: O(n)
	//Space Complexity: O(n)
}
