
public class Solution4 {

	public static void main(String[] args) {
		System.out.println(hex(255));
	}
	//what: use divide and mod functions to convert a number as a hexadecimal number.
	public static String hex(int number) {
		//corner case 
		if (number == 0) {
			return "0x0";
		}
		//sb record all hexadecimal digit in reverse order.
		StringBuilder sb = new StringBuilder();
		while (number > 0) {
			int rem = number % 16 ;
			if (rem < 10) {
				sb.append((char)('0' + rem));
			} else {
				sb.append((char)('A' + rem - 10));
			}
			number = number /16;
		}
		//reverse all digits 
		sb.reverse();
		return "0x" + sb.toString();
	}
	//Time complexity: O(logn/log16)
	//Space complexity: O(logn/log16);
}
