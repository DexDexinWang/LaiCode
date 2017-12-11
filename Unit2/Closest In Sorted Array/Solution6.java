
public class Solution6 {

	public static void main(String[] args) {
		int[] input = {1,1,3,3,3,3,3,4,5};
		System.out.println(closest(input, 2));
	}

	//what: find the closest target with binary search on ordered array
	public static int closest(int[] array, int target) {
		//how: 1. corner case
		if (array == null || array.length == 0) {
			return -1;
		}
		
		//2. iteratively reduce the range  
		int left = 0;
		int right = array.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid]  == target) {
				return mid;
			} else if (array[mid] < target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		
		return Math.abs(array[left] - target) <=
			   Math.abs(array[right] - target) ?
			   left : right;
	}
	//Time Complexity: O(logn)
	//Space Complexity: O(1)
}
