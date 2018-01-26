import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution4 {

	public static void main(String[] args) {
		int[] input = new int[]{1, 1, 5, 5, 11, 11, 11, 11};
		System.out.print(allTriples(input, 11));
	}
	
	//approach: use three pointers to move three pointers. 
	  public static List<List<Integer>> allTriples(int[] array, int target) {
	    Arrays.sort(array);
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    for (int i = 0; i < array.length - 2; i++) {
	      if (i > 0 && array[i] == array[i - 1]) {
	        continue;
	      }
	      int j = i + 1; 
	      int k = array.length - 1;
	      int remaining = target - array[i];
	      while (j < k) {
	        if (array[j] + array[k] == remaining) {
	          res.add(Arrays.asList(array[i],array[j++],array[k--]));
	          while (j < k && array[j-1] == array[j]) {
	            j++;
	          }
	        } else if (array[j] + array[k] < remaining) {
	          j++;
	        } else {
	          k--;
	        }
	      }
	    }
	    return res;
	  }
	  //Time complexity:O(n)
	  //Space complexity: O(1)
}
