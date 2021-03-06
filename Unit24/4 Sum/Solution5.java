import java.util.HashMap;
import java.util.Map;

public class Solution5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  //Approach two pointers: i < j < k < l to find sum for a combination that is equal to target.
	  public boolean exist(int[] array, int target) {
	    Map<Integer,Integer> map = new HashMap<Integer, Integer>();
	    for (int j = 1 ; j < array.length; j++) {
	      for (int i = 0 ; i < j ; i++) {
	        int sum = array[i] + array[j];
	        if (map.containsKey(target - sum) && map.get(target - sum) < i) {
	          return true;
	        }
	        if (!map.containsKey(sum)) {
	          map.put(sum, j);
	        }
	      }
	    }
	    return false;
	  }
	  //Time complexity: O(n^2)
	  //Space complexity: O(n^2)
}
