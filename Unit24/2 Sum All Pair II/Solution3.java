import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution3 {

	public static void main(String[] args) {
		int[] input = new int[]{1, 1, 5, 5, 11, 11, 11, 11};
		System.out.print(allPairs(input, 10));
	}
	  //approach: I will sort array first, and check target with two pointers
	  public static List<List<Integer>> allPairs(int[] array, int target) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    int left = 0;
	    int right = array.length - 1;
	    Arrays.sort(array);
	    while (left < right) {
	    	if (left > 0 && array[left] == array[left - 1]) {
	    		left++;
	    		continue;
	    	}
	    	int cur = array[left] + array[right];
	    	if (cur == target) {
	    		res.add(Arrays.asList(array[left],array[right]));
	    		left++;
	    		right--;
	    	} else if (cur < target) {
	    		left++;
	    	} else {
	    		right--;
	    	}
	    }
	    return res;
	  }
}
