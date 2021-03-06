import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution1 {

	public static void main(String[] args) {
		String input = "aba";
		System.out.println(permutations(input));
	}
	  //DFS
	  //N levels, it should consider to choose one character to be added for final result
	  //N` branches, it means the remining characters.
	public static List<String> permutations(String set) {
		List<String> res = new ArrayList<String>();
		//how: 1. corner case
		if (set == null) {
			return res;
		}
		//2. define the char array and HashSet for helper function.
		char[] array = set.toCharArray();
		helper(array, 0, res);
		return res;
	}
	//3. recursively try each position for each unique character.
	private static void helper(char[] array, int index, List<String> res) {
		//3.1. base case
		if (index == array.length) {
			res.add(new String(array));
			return;
		}
		Set<Character> unique = new HashSet<Character>();
		//3.2 check each character after the current character
		for (int i = index; i < array.length ; i++) {
			if (unique.add(array[i])) {
			swap(array, i, index);
			helper(array, index + 1, res);
			//3.3 back tracking
			swap(array, i, index);
			}
		}
	}
	
	private static void swap (char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j]; 
		array[j] = temp;
	}
	//Time complexity: O(n!)
	//Space complexity: O(n) call stack
}
