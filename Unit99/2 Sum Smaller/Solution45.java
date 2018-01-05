import java.util.Arrays;

public class Solution45 {

	public static void main(String[] args) {
		int[] input = {3, 4, 0, -1, 2, 0, 5};
		System.out.println(smallerPairs(input, 7));
	}
	public static int smallerPairs(int[] array, int target) {
		int res = 0;
		//how: 1. corner case
		if (array == null || array.length <= 1) {
			return res;
		}
		//2. sort the array
		Arrays.sort(array);
		//3. 
		
		return res;
	}
}
