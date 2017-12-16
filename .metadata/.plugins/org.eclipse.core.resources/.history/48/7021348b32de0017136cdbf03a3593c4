import java.util.LinkedList;
import java.util.List;

/**
 * @author Dexin Wang
 * @Date Dec 6, 2017
 */
public class Solution2 {
	public static void main(String[] args) {
		String input = "abc";
		System.out.println(permutations(input));
	}
	//what: find each possible permutations 
	public static List<String> permutations(String set) {
		List<String> res = new LinkedList<String>();
		//how: 1.corner case
		if (set == null) {
			return res;
		}
		//2. create char array for swapping each character
		char[] array = set.toCharArray();
		helper(array, 0, res);
		return res;
	}
	//3. recursively check each permutation
	private static void helper(char[] array, int index, List<String> res) {
		//3.1 base case
		if (index == array.length) {
			res.add(array.toString());
			return;
		}
		for (int i = index; i < array.length ; i++) {
			//3.2 swap the character to be a new permutation
			swap(array, index, i);
			helper(array, index + 1, res);
			//3.3 back-tracking 
			swap(array, index, i);
		}
	}
	
	private static void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	//Time Complexity: O(n!);
	//Time Complexity: O(1) in-place;
}
