import java.util.HashMap;
import java.util.Map;

public class Solution17 {

	public static void main(String[] args) {
		System.out.println(isomorphic("asvfeh","mqiumz"));
	}
	//what: to traverse each character from both Strings and check whether they are isomorphic Strings
	public static boolean isomorphic(String s, String t) {
		//how: 1. corner case.
		if (s.length() != t.length()) {
			return false;
		}
		//2. define counters for each characters.
		int[] counterS = new int[26];
		int[] counterT = new int[26];
		//3. define each character with a unit number to identify them.
		for (int i = 0 ; i < s.length() ; i ++) {
			if (counterS[s.charAt(i)-'a'] != counterT[t.charAt(i)-'a']) {
				return false;
			}
			//all default value is 0. ==> so add 1 
			counterS[s.charAt(i)-'a'] = i + 1;
			counterT[t.charAt(i)-'a'] = i + 1;
		}
		return true;
	}
	//Time complexity: O(n);
	//Space complexity: O(26)= O(1);
}
