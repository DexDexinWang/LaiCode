import java.util.Arrays;

public class Solution1 {

	public static void main(String[] args) {
		int[] input = {2,3,4,3,5,5};
		System.out.println(Arrays.toString(solve(input)));
	}
	//what: to find the correct position for each number from 0 to n with swap method iteratively;
	public static int[] solve(int[] array) {
		//corner case
		if (array == null || array.length == 0) {
			return array;
		}
		//outer loop, how many iterations.
		for (int i = 0 ; i < array.length - 1 ; i++) {
			int min = i; 
			//inner loop, to find the global min from the rest element.
			for(int j = i + 1 ; j < array.length; j++) {
				if (array[j] < array[min]) {
					//record the index of the min element.
					min = j;
				}
			}
			//swap, to put min number in the correct position.
			swap(array, i, min);
		}
		return array;
	}
	
	private static void swap(int[] array, int i , int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	//Time Complexity: O(n-1) + O(n-2) + ... O(1) = O(n(n-1)/2) = O(n^2)
	//Time Space: O(1); //in place
}
