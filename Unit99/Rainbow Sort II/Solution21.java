import java.util.Arrays;

public class Solution21 {

	public static void main(String[] args) {
		int[] input = {1, 3, 1, 2, 0};
		System.out.println(Arrays.toString(rainbowSortII(input)));
	}
	/*
	 * Given an array of balls, where the color of the balls can only be Red, Green, Blue or Black, 
	 * sort the balls such that all balls with same color are grouped together and from left to right 
	 * the order is Red->Green->Blue->Black. (Red is denoted by 0, Green is denoted by 1,  
	 * Blue is denoted by 2 and Black is denoted by 3).
	 */
	//what: sort an integer form smaller to bigger. 
	public static int[] rainbowSortII(int[] array) {
		//how: 1. corner case
		if (array == null || array.length <= 1) {
			return array;
		}
		//2. define 4 variables to separate each integer into different area.
		int A = 0;
		int B = 0;
		int C = array.length - 1;
		int D = array.length - 1;
		//3. make a loop to check each character. 
		while (B <= C) {
			if (array[B] == 1) {
				B++;
			} else if (array[B] == 0) {
				swap(array, A++, B++);
			} else {
				swap(array, B, C); 
				if (array[C] == 2) {
					C--;
				} else {
					swap(array,C--,D--);
				}
			}
		}
		return array;
	}
	//Time complexity: O(n);
	//space complexity: O(1);
	
	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
