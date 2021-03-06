import java.util.Arrays;

public class Solution1 {

	public static void main(String[] args) {
		int[] input = {1,2,3,4,5,6,7,8,9,0};
		shuffle(input);
		System.out.println(Arrays.toString(input));
		
	}
	
	//what: randomly choose one element from the rest set. define a bar to separate randomly chosen element and rest element until there is no rest element. 
	public static void shuffle(int[] array) {
		//how: 1. corner case 
		if (array == null || array.length <= 1) {
			return;
		}
		//2. iterative choose elements with uniformly distribution.
		for (int bar = array.length; bar > 0 ; bar--) {
			int index = (int) (Math.random() * bar);  // bar: [0, array.length) == [0, array.length -1];
			swap(array,bar - 1,index); //bar - 1 is the max length of the array;
		}
	}

	private static void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
