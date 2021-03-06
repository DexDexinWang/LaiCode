import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class Solution3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	 public int largestProduct(String[] dict) {
		  	Map<String, Integer> map = new HashMap<>();
		    for (String str: dict) {
		      map.put(str, bitMask(str));
		    }
		    Arrays.sort(dict, new Comparator<String>() {
		      @Override
		      public int compare(String s1, String s2) {
		        if (s1.length() == s2.length()) {
		          return 0;
		        }
		        return s1.length() < s2.length() ? 1 : -1;
		      }
		    });
		    
		    int largest = 0;
		    
		    for(int i = 1; i < dict.length; i++ ) {
		      for (int j = 0; j < i; j++) {
		        int prod = dict[i].length() * dict[j].length();
		        if (prod <= largest) {
		          break;
		        }
		        int iMask = map.get(dict[i]);
		        int jMask = map.get(dict[j]);
		        if ((iMask & jMask) == 0) {
		          largest = prod;
		        }
		      }
		    }
		    return largest;
		  }
		  
		  private Integer bitMask(String str) {
		    Integer res = 0;
		    for(char ch: str.toCharArray()) {
		    	res |= 1 << (ch - 'a');
		    }
		    return res;
		  }
}
