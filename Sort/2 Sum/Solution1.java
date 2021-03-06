import java.util.HashSet;
import java.util.Set;

public class Solution1 {
	public static void main(String[] args) {
		int[] input = {2,3,4,3,5,5};
		System.out.println(existSum(input,6));
	}
	
	/*
	 * Determine if there exist two elements in a given array,
	 *  the sum of which is the given target number.
	 */
	//what: to find whether the array contains a sum of 2 numbers that is target.
	public static boolean existSum(int[] array, int target) {
		//how: 1. corner case
		if (array == null || array.length <= 1) {
			return false;
		}
		//2. define a Set to store the value becuase each check is O(1) 
		Set<Integer> set = new HashSet<Integer>();
		//3. traverse all integer form array. 
		for (int i = 0 ; i < array.length ; i++) {
			if (set.contains(array[i])) {
				return true;
			} else {
				set.add(target - array[i]);
			}
		}
		return false;
	}
	//Time complexity : O(n)
	//Space complexity: O(n)

}
