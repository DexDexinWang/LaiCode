
public class Solution43 {
	
	public static void main(String[] args) {
		String input = "acb2c4";
		System.out.println(decompress(input));
	}
	
	//what: decompress a given string that include number which shows the number of previous characters
	public static String decompress(String input) {
		//1. corner case.
		if(input.length() <= 1) {
			return input;
		}
		//2. create a StringBuilder.
		StringBuilder sb = new StringBuilder();
		//3. check each character from input and decompress them and insert into sb.
		for(int i = 0 ; i < input.length() ; i++) {
			if (Character.isDigit(input.charAt(i))) {
				int time = (int)(input.charAt(i) - '0');
				char repeat = input.charAt(i - 1);
				for(int j = 2; j <= time ; j++ ){
					sb.append(repeat);
				}
			} else {
				sb.append(input.charAt(i));
			}
		}
		return sb.toString();
	}
	// Time complexity: O(n); where n is the total of character * times.
	// Space complexity: O(n);
}
