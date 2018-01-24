import java.util.Arrays;

public class Solution3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  //approach: use two pointers to solve the problem. 
	  //all eles to the left side of slow(excluded slow) will be the return result.
	  //all eles to the right side of fast will be processed
	  public int[] removeElement(int[] input, int value) {
	    if (input == null || input.length == 0) {
	      return input;
	    }
	    int slow = 0;
	    for (int fast = 0; fast < input.length; fast++) {
	      if (input[fast] == value) {
	        continue;
	      }
	      input[slow++] = input[fast];
	    }
	    return Arrays.copyOf(input, slow);
	  }
	  //Time complexity: O(n);
	  //Space complexity: O(1);
}
