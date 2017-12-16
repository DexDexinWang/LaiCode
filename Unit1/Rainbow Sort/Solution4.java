import java.util.Arrays;

public class Solution4 {

	public static void main(String[] args) {
		int[] input = {0,1,1,1,-1,-1,1,0};
		System.out.println(Arrays.toString(rainbowSort(input)));
	}

	//what:  find -1s put in left side, find 1s and put them in right side. others in mid. 
	//approach: 
	// 1. define tree pointers(x,y,z), two left sides and one right side. 
	// 2. iteratively check each number. 
	// 2.1. when -1, swap x and -1, then move x forward.
	// 2.2. when 0, swap y and 0, then move y forward.
	// 2.3. when 1, swap z and 1, then move z backward.
	// 3.3. terminate it when y and z cross over.

	public static int[] rainbowSort(int[] array) {
		//how: 1. corner case
		if (array == null || array.length <= 1) {
			return array;
		}
		//2. traverse all numbers 
		int neg = 0;
		int zero = 0;
		int pos = array.length - 1; 
		while (zero <= pos) {
			if (array[zero] == -1) {
				swap(array, neg++, zero++);
			} else if (array[zero] == 0) {
				zero++;
			} else if (array[zero] == 1) {
				//zero without ++ because I do not know what zero in pos.
				swap(array, pos--, zero);
			}
		}
		return array;
	}

	private static void swap(int[] array, int i, int j)
	{
		int temp = array[i];
		array[i] = array[j];
	  	array[j] = temp;
	}
	//Time Complexity: O(n)
	//Space Complexity: O(1)
}
