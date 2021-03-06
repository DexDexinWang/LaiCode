
public class Solution26 {

	public static void main(String[] args) {
		int[] input = {1,2,2,2,3}; 
		System.out.println(totalOccurrence(input,2));
	}

	/*Given a target integer T and an integer array A sorted in ascending order, 
	 * Find the total number of occurrences of T in A.
	 */
	//What: find the most left occurrence target and count next targets 
	public static int totalOccurrence(int[] array, int target) {
		//how: 1. corner case
		if (array == null || array.length == 0) {
			return 0;
		}
		//2. reduce the range of the first target
		int left = 0;
		int right = array.length - 1;
		while (left < right - 1) {
			int mid = left + (right - left) / 2;
			if (array[mid] >= target) {
				right = mid;
			} else {
				left = mid;
			}
		}
		//3. check the final position for the target
		int start = 0;
		if (array[left] == target) {
			start = left;
		} else if (array[right] == target) {
			start = right; 
		}
		//4. count the number of targets
		int sum = 0;
		while(start < array.length && array[start] == target) {
			sum++;
			start++;
		}
		//5. return;
		return sum;
	}
	//Time complexity: O(n)
	//Space complexity: O(1)
}
