
public class Solution4 {

	public static void main(String[] args) {
		int[] input = {1,2,3,3,3,3,3,4,5};
		System.out.println(firstOccur(input, 3));
	}

	//what: find the first occurrence with binary search on ordered data
	public static int firstOccur(int[] array, int target) {
		//how: 1. corner case
		if (array == null || array.length == 0) {
			return -1;
		}
		//2. iteratively search the value to reduce the range 
		int left = 0; 
		int right = array.length - 1;
		while (left < right -1) {
			int mid = left + (right - left) / 2;
			if (array[mid] >= target) {
				right = mid;
			} else {
				left = mid;
			}
		}
		//3. find the numbers in the range
		if (array[left] == target) {
			return left;
		} else if (array[right] == target) {
			return right; 
		}
		return -1;
	}
	//Time Complexity: O(logn)
	//Space Complexity: O(1)
}
