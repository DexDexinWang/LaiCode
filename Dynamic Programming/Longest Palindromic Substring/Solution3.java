
public class Solution3 {

	public static void main(String[] args) {
		String input = "bcbcd";
		System.out.println(longestPalindrome(input));
	}
	
	static int begin;
	static int max;
	public static String longestPalindrome(String s) {
		if (s == null || s.length() <= 1) {
			return s;
		}
		for(int i = 0 ; i < s.length() - 1; i++) {
			longestPalindrome(s, i, i);
			longestPalindrome(s, i, i + 1);
		} 
		return s.substring(begin, begin + max); 
	}

	public static void longestPalindrome(String s, int i, int j) {
		while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
			i--;
			j++;
		}
		if (max < j - i - 1) {
			max = j - i - 1;
			begin = i + 1;
		}
	}

	  public String longestPalindrome1(String t) {
		    if (t.length() < 2) return t;
		    char[] s = t.toCharArray();
		        int maxlen = 1,maxleft = 0,left,right;
		        for (int start = 0;start < s.length - maxlen/2;){
		            left = right = start;
		            while((right < s.length - 1) && s[right] == s[right+1])right++;
		            start = right+1;
		            while(left > 0 && right < s.length - 1 && s[left-1] == s[right+1]){
		                left--;
		                right++;
		            }
		            int nl = right - left + 1;
		            if (nl > maxlen){
		                maxlen = nl;
		                maxleft = left;
		            }
		        }
		        return t.substring(maxleft,maxleft +maxlen);
		  }

}
