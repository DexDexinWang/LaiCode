
public class Solution25 {

	public static void main(String[] args) {
		int[] input = {1,2,3,4,5};
		System.out.println(shiftPosition(input));
	}
	public static int shiftPosition(int[] array) {
		if (array == null || array.length == 0) {
			return -1;
		}
		int low = 0;
		int high = array.length - 1;
		while (low < high) {
			int mid = low + (high - low) / 2;
			if (array[mid] > array[high]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return low;
	}

}
