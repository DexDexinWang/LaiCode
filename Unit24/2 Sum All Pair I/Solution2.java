import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	  //approach: to solve the problem with HashMap
	  //hashMap: key, (current_value)   value, an arraylist to store the indexes they have the same key value.
	  public List<List<Integer>> allPairs(int[] array, int target) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    //save the ele`s informaiton 
	    Map<Integer, List<Integer>> map = new HashMap<>();
	    for (int i = 0 ; i < array.length ; i++) {
	      //find matched numbers.
	      List<Integer> indexes = map.get(target - array[i]);
	      if(indexes != null) {
	        for (Integer j: indexes) {
	          res.add(Arrays.asList(i,j));
	        }
	      }
	      //unmatch
	      if (!map.containsKey(array[i])) {
	        map.put(array[i], new ArrayList<Integer>());
	      }
	      //add index
	      map.get(array[i]).add(i);
	    }
	    return res;
	  }
	  //Time complexity: O(n^2);
	  //Space complexity: O(n)
}
