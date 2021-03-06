import java.util.Arrays;

public class Solution7 {

	public static void main(String[] args) {
		int[] input = {1,1,3,3,3,3,3,4,5};
		System.out.println(Arrays.toString(kClosest(input, 2, 6)));
	}

	//what: find the K closest number in a sorted array with binary search
	public static int[] kClosest(int[] array, int target, int k) {
		//how: 1. corner case
		if (array == null || array.length == 0) {
			return new int[0];
		}
		//2. find the cloest position;
		int left = closest(array,target);
		int right = left + 1;
		//3. extend the range
		int[] res = new int[k];
		for (int i =0 ; i < k ; i++) {
			if (right >= array.length || left >=0 && (target-array[left]) < (array[right] - target)) {
				res[i] = array[left--];
			} else {
				res[i] = array[right++];
			}
		}
		return res;
	}
	
	//2. find the closest posision
	public static int closest(int[] array, int target) {
		int left = 0;
		int right = array.length - 1; 
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] == target) {
				return mid;
			} else if (array[mid] < target) {
				left = mid;
			} else {
				right = mid;
			}
		}
		return Math.abs(array[left] - target) <
				Math.abs(array[right] - target) ?
						left : right;
	}
	//Time Complexity: O(logn)
	//Space Complexity: O(k)
	
}
