import java.util.Arrays;

public class Solution58 {

	public static void main(String[] args) {
		int[] input = {1,2,2,3,3,3};
		System.out.println(Arrays.toString(dedup(input)));
	}
	/*
	 * Given an integer array(not guaranteed to be sorted),
	 * remove adjacent repeated elements. For each group of elements with the same 
	 * value keep at most two of them. Do this in-place, using the left side of the 
	 * original array and maintain the relative order of the elements of the array. 
	 * Return the final array.
	 */
	
	public static int[] dedup(int[] array) {
		if (array.length <= 2) {
			return array;
		}
		int slow = 0;
		int fast = 0;
		while(fast < array.length) {
			if(fast == 0 || array[fast] != array[fast - 1]) {
				array[slow++] = array[fast++];
			} else {
				while (fast + 1 < array.length && array[fast] == array[fast + 1]) {
					fast++;
				}
				array[slow++] = array[fast++];
			}
		}
		return Arrays.copyOfRange(array, 0, slow);
	}
	//Time Complexity: O(n)
	//Space Complexity: O(n);
}
