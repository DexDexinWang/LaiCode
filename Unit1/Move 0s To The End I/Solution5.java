import java.util.Arrays;

public class Solution5 {

	public static void main(String[] args) {
		int[] input = {0,1,24,5,0,5};
		System.out.println(Arrays.toString(moveZero(input)));
	}
	
	//what: find the non-zeros and put them in the left side and find the zeros put it in the right side.
	//approach: 
	//1. to define two pointers on both side. when find the non-zeros put swap it with the left side pointer to keep data integrity.Then move the pointer. Also do the similar process with zeros.
	//2. when two pointers cross over, termin 
	public static int[] moveZero(int[] array) {
		//how: 1. corner case
		if (array == null || array.length <= 1) {
			return array;
		}
		int left = 0;
		int right = array.length - 1;
		//2. traverse all numbers in array;
		while (left < right) {
			if (array[left] != 0) {
				left++;
			}  else if (array[right] == 0) {
				right--;
			} else {
				swap(array, left++, right--);
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
	//Time complexity: O(n)
	//Space complexity: O(1)
}
