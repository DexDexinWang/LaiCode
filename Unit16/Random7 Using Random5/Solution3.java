
public class Solution3 {

	public static void main(String[] args) {
		System.out.println(random7());
	}
	//what: use random5() to generate random7() with uniformly distribution.
	//how: 1. to get a randomX() which is greater than random 7() with exponent increase.
	//2. then generate value that is smaller then Y*random7() where Y*random7() < randomX();
	//3. use mode to get the result.
	public static int random7() {
		//1.
		int maxIn = 5;
		while(maxIn < 7) {
			maxIn *= 5;
		}
		int maxOut = maxIn / 7 * 7;
		while(true) {
			//2.
			int r = randomMax(maxIn);
			//3.
			if (r < maxOut) {
				return r % 7;
			}
		}
	}
	private static int randomMax(int value) {
		return (int)(Math.random() * value);
	}

}
