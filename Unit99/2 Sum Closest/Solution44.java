import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution44 {

	public static void main(String[] args) {
		int[] input = {3, 4, 0, -1, 3, 0, 5};
		System.out.println(closest1(input, 1));
	}
	/* Find the pair of elements in a given array that sum to 
	 * a value that is closest to the given target number. 
	 * Return the values of the two numbers.
	 */
	//what: find the most closet sum of tow number from the the array.
	public static List<Integer> closest(int[] array, int target) {
		List<Integer> res = new ArrayList<Integer>();
		//how: 1. corner case  
		if (array == null || array.length <= 1) {
			return res;
		}
		//2. sort the array;
		Arrays.sort(array);
		//3. define two pointers to traverse each possible sum.
		int i = 0;
		int j = array.length - 1;
		int diff = Integer.MAX_VALUE;
		while (i < j) {
			//3.1 find the target
			if (array[j] + array[i] == target) {
				res.clear();
				res.add(array[i]);
				res.add(array[j]);
				return res;
			} else {
				//3.2 check the diff for the sum and target.  
				int check = Math.abs(target - (array[i] + array[j]));
				if (check < diff) {
					diff = check;
					res.clear();
					res.add(array[i]);
					res.add(array[j]);
				}
				//3.3 move the pointers.
				if (array[i] + array[j] > target) {
					j--;
				} else {
					i++;
				}
			}
		}
		return res;
	}
	//Time complexity: O(n) 
	//Space complexity: O(1)
	
	public static List<Integer> closest1(int[] array, int target) {
		List<Integer> res = new ArrayList<Integer>();
		if (array == null || array.length <=  1) {
			return res;
		}
		Arrays.sort(array);
		int left = 0;
		int right = array.length - 1;
		while (left + 1 < right) {
			int mid = left + (right - right) / 2;
			if (array[left] + array[right] < target) {
				if (array[mid] + array[right] < target) {
					left = mid;
				} else {
					left ++;
				}
			} else if (array[left] + array[right] > target) {
				if (array[left] +  array[mid] > target) {
					right = mid;
				} else {
					right--;
				}
			} else {
				break;
			}
		}
		res.add(array[left]);
		res.add(array[right]);
		return res;
	}
}
