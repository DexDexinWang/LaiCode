
public class Solution30 {

	public static void main(String[] args) {
		int[] input = {1,2,3,4};
		System.out.println(missing(input));
	}

	public static int missing(int[] array) {
		int res = 0;
		int len = array.length;
		for(int i = 1; i <= len + 1; i++) {
			res ^= i;
		}
		for(int i = 0; i < len ; i++) {
			res ^=array[i]; 
		}
		return res;
	}
}
