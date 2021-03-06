import java.util.ArrayList;
import java.util.List;

public class Solution10 {
	  public List<Integer> common(int[] a, int[] b, int[] c) {
		    List<Integer> res = new ArrayList<Integer>();
		    int i = 0;
		    int j = 0;
		    int k = 0;
		    while(i < a.length && j < b.length && k < c.length) {
		      if (a[i] == b[j] && b[j] == c[k]) {
		        res.add(a[i]);
		        i++;
		        j++;
		        k++;
		      } else if (a[i] < b[j]) {
		        i++;
		      } else if (b[j] < c[k]) {
		        j++;
		      } else {
		        k++;
		      }
		    }
		    return res;
		  }
		  //Time complexity:O(i+j+k);
		  //Space complexity: O(1);
}
