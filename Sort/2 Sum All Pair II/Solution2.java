import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution2 {

	public static void main(String[] args) {
		int[] input = {3, 5, 3, 2, 4, 5, 5, 4, 3, 4};
		System.out.println(allPairs(input, 8));
	}

	/*Find all pairs of elements in a given array that sum to 
	 * the pair the given target number. Return all the distinct pairs of values.
	 */
	//what: find all pairs from arrays, that the sum of each pair is equal to target
	public static List<List<Integer>> allPairs(int[] array, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		//how: 1. corner case
		if(array == null || array.length < 2) {
			return res;
		}
		//2. define a map store the target - array[i], and current index;
		Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		//3. traverse all numbers in the array.
		for(int i = 0; i < array.length; i++) {
			Integer value = map.get(array[i]);
			if (value == null) {
				map.put(target - array[i], i);
			} else {
				List<Integer> temp = new ArrayList<Integer>();
				temp.add(array[i]);
				temp.add(array[value]);
				if (!res.contains(temp)) {
					res.add(temp);
				}
			}
		}
		return res;
	}
	//Time complexity: O(n);
	//Space complexity: O(n);
}
