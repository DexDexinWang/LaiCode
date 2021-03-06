import java.util.Arrays;

public class Solution4 {

	public static void main(String[] args) {
		int[] input = {0,1,1,1,-1,-1,1,0};
		System.out.println(Arrays.toString(rainbowSort(input)));
	}

	//what:  find -1s put in left side, find 1s and put them in right side. others in mid. 
	//approach: 
	// 1. define tree pointers(x,y,z), two left sides and one right side. 
	// 1.1. all elements to the left side of x are negative numbers;
	// 1.2. all elements to the right side of z are positive numbers;
	// 1.3. all elements to the left side of y and right side of x are 0; 
	// 1.4. all elements to the left side of z and right side of x are unknonwn. 
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
	    //define 3 pointers as segregation boards to separate -1,0,and 1.
		int neg = 0;
		int zero = 0;
		int pos = array.length - 1; 
		while (zero <= pos) {
			if (array[zero] == -1) {
		        //put all negs to the left side of neg pointer.
				swap(array, neg++, zero++);
			} else if (array[zero] == 0) {
		        //put all zeros to the right side of neg pointer and to the left side of zero pointer.
				zero++;
			} else if (array[zero] == 1) {
		        //put all posis to the right side of pos pointer.
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
