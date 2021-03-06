import java.util.HashSet;
import java.util.Set;

public class Solution2 {

	public static void main(String[] args) {
		String[] input = {"aad", "abc", "ddd"};
		System.out.println(canBreak("dddaadabc",input));
	}
	/**
	 * Base Case: M[0] = director.get(M[0]);
	 * Induction Rule: 
	 * 1. M[i] represents whether the word could be composed from 0th to ith character include ith.
	 * 2. M[i] = BeTree(string{0-j}, string{j-i}) where 0 <= j <= i;
	 * @param input
	 * @param dict
	 * @return
	 */
	public static boolean canBreak(String input, String[] dict) {
		Set<String> set = new HashSet<String>();
		for(String word: dict) {
			set.add(word);
		}
		boolean[] array = new boolean[input.length() + 1];
		array[0] = true;
		for (int i = 1; i <= input.length() ; i++) { 
			for (int j = 0; j < i ; j++) {
				String rightPart = input.substring(j, i);
				if (array[j] && set.contains(rightPart)) {
					array[i] = true;
					break;
				}
			}
		}
		return array[array.length - 1];
	}
	//Time complexity: O(n^3)
	//Space complexity: O(n)
}
