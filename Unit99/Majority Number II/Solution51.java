import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution51 {

	public static void main(String[] args) {
		int[] input = {1,2,1,2,1};
		System.out.println(majority(input));
	}
	/**
	 * Given an integer array of length L, 
	 * find all numbers that occur more than 1/3 * L times if any exist.
	 */
	public static List<Integer> majority(int[] array) {
		List<Integer> res =  new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0 ; i < array.length ; i++) {
			map.put(array[i], map.getOrDefault(array[i], 0) + 1);
		}
		int nums = array.length / 3;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > nums){
				res.add(entry.getKey());
			}
		}
		return res;
	}
	//Time complexity: O(n)
	//Space complexity: O(n)

}
