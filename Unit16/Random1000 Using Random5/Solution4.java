
public class Solution4 {

	public static void main(String[] args) {
		System.out.println(random1000());
	}

	public static int random1000() {
		int maxIn = 5;
	    while (maxIn < 1000) {
	      maxIn *=5;
	    }
	    int maxOut = maxIn /1000 * 1000;
	    while (true) {
	      int r = (int)(Math.random() * maxIn);
	      while (r < maxOut) {
	        return r % 1000;
	      }
	    }
	}
}
