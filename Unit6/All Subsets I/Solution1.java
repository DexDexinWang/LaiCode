import java.util.ArrayList;
import java.util.List;

/**
 * @author Dexin Wang
 * @Date Dec 6, 2017
 */
public class Solution1 {

	public static void main(String[] args) {
		String input = "abc";
		System.out.println(subSets(input));
	}
	//what: find each non-repeated subset of input string by checking each character
	public static List<String> subSets(String set) {
		List<String> res= new ArrayList<String>();
		//How: 1. corner case
		if (set == null) {
			return res;
		}
		//2. define char array and temporary StringBuilder for the result
		char[] array = set.toCharArray();
		StringBuilder sb = new StringBuilder();
		helper(array, 0, sb, res);
		return res;
	}
	
	//3. recursively check each character whether it should be in subset
	private static void helper(char[] array, int index, StringBuilder sb, List<String> res) {
		//3.1 base case index is in the end;
		if (index == array.length) {
			res.add(sb.toString());
			return;
		}
		//3.2 the current character is not contained in sb.
		helper(array, index + 1, sb, res);
		//3.3 the current character is contained in sb.
		helper(array, index + 1, sb.append(array[index]), res);
		//back tracking
		sb.deleteCharAt(sb.length()-1);
	}

	//Time Complexity: O(1) + O(2) + O(4)+ ... + O(2^n) = O(2^n)
	//Space Complexity: O(n) 
}
