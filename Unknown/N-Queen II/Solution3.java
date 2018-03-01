import java.util.ArrayList;
import java.util.List;

public class Solution3 {

	public static void main(String[] args) {
		Solution3 s = new Solution3();
	
	}
	  public int totalNQueens(int n) {
		    if (n == 0) {
		      return 0;
		    }
		    int[] counter = new int[]{0};
		    List<Integer> temp = new ArrayList<Integer>();
		    helper(n, 0, counter,temp);
		    return counter[0];
		  }
		  
		  private void helper(int n, int index, int[] counter, List<Integer> temp) {
		    if (temp.size() == n) {
		      counter[0]++;
		      return;
		    }
		    for(int i = 0; i < n; i++) {
		      if (valid(temp, i)) {
		        temp.add(i);
		        helper(n, index + 1, counter, temp);
		        temp.remove(temp.size() - 1);
		      }
		    }
		  }
		  private boolean valid(List<Integer> temp, int col) {
		    int rows = temp.size();
		    for(int i = 0; i < rows; i++) {
		      if (temp.get(i) == col || Math.abs(col - temp.get(i)) == rows - i) {
		        return false;
		      }
		    }
		    return true;
		  }
		  
}
