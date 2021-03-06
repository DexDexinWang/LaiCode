
public class Solution6 {

	public static void main(String[] args) {
		System.out.println(numDecodeWay("12"));
	}

	public static int numDecodeWay(String s) {
		int[] res = new int[1];
		if (s == null || s.length() == 0) {
			return res[0];
		}
		numDecodeWay(s, 0, res);
		return res[0];
	}
		  
	private static void numDecodeWay(String s, int index, int[] res) {
		if (index == s.length()) {
			res[0]++;
		    return;
		}
	    if (s.charAt(index) == '0') {
	    	return;  
		}
	    numDecodeWay(s, index + 1, res);  
	    StringBuilder sb = new StringBuilder();
	    if (index == s.length() -1) {
	    	return;
	    }
	    sb.append(s.charAt(index)).append(s.charAt(index + 1));
	    if (Integer.parseInt(sb.toString()) <= 26) {
	    	numDecodeWay(s, index + 2, res);  
		}
	}
}
