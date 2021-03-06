
public class Solution2 {

	public static void main(String[] args) {
		System.out.println(diffBits(16, 8));
	}

	public static int diffBits(int a, int b) {
		return count(a ^ b);
	}
	
	//what: consider corner case where a = -min and b = max;
	private static int count(int n) {
		int counter = 0;
		while (n != 0) {
			counter += (n & 1);
			//could handle the negative numbers 
			n = n >>> 1;
		}
		return counter;
	}
	//Time Complexity: O(32) = O(1)
	//Space Complexity: O(1);
}
