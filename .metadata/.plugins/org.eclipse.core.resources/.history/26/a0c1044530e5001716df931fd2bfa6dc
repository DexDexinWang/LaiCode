import java.util.Arrays;

public class Solution1 {

	public static void main(String[] args) {
		int[] input = {2,3,4,3,5,6};
		System.out.println(Arrays.toString(solve(input)));
	}
	//what: to find the correct position for each number from 0 to n iteratively;
	public static int[] solve(int[] array) {
		//how: 1. corner case
		if (array == null || array.length == 0) {
			return array;
		}
		//2. iterative check each number from 0 to n;
		for (int i = 0 ; i < array.length - 1 ; i++) {
			int min = i; 
			//2.1. compare i and other numbers, j. to find the min positon
			for(int j = i + 1 ; j < array.length; j++) {
				if (array[j] < array[min]) {
					min = j;
				}
			}
			//2.2 put the min number in the front side. 
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
	//Time Space: O(1);
}
