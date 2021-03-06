import java.util.HashMap;
import java.util.Map;

public class Solution3 {

	public static void main(String[] args) {
		int[] input = {3,9,8,2,5,1};
		System.out.println(longestConsecutive(input));
	}
	/*Given an unsorted array of integers, 
	 * find the length of the longest consecutive elements sequence.
	 */
	//what: find the longest consecutive elements sequence.
	public static int longestConsecutive(int[] array) {
		//how: 1. corner case
		if (array == null || array.length == 0) {
			return 0;
		}
		//2. define a hashmap to stores the max length for boundaries.
		//2.1 if num is in hashmap.  If yes, continaue
		//2.2 if num is not in hashmap, check their neighbors, and update their boundries for consecutive elements.
		Map<Integer, Integer> ranges = new HashMap<>();
		int max = 0;
		for(int num : array) {
			if (ranges.containsKey(num)) {
				continue;
			}
			int left = ranges.getOrDefault(num -1, 0);
			int right = ranges.getOrDefault(num + 1, 0);
			int sum = left + right + 1;
			max = Math.max(max, sum);
			
			if (left > 0) ranges.put(num - left, sum);
			if (right > 0) ranges.put(num + right, sum);
			ranges.put(num, sum);
		}
		return max;
	}
	//Time complexity: O(n)
	//Space complexity: O(n)

}
