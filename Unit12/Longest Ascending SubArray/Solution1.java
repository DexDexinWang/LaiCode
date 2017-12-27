
public class Solution1 {

	public static void main(String[] args) {
		int[] input = {1,23,4,567,74,2,4};
		System.out.println(longest(input));
	}
	

	public static int longest(int[] array) {
		if (array.length <= 1) {
			return array.length;
		}
		int cur = 1; 
		int max = 1;
		for (int i = 1 ; i < array.length; i++) {
			if (array[i] > array[i - 1]) {
				cur++;
			} else {
				max = Math.max(max, cur);
				cur = 1;
			}
		}
		return max;
	}

}
