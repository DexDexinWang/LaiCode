import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class Solution5 {

	public static void main(String[] args) {
		Solution5 s = new Solution5();
		System.out.println(s.combine(1, 1));

	}
	  //n levels, each level choose a number to be added into the final result;
	  //n` braches, n` is the reamining number
	  public ArrayList<ArrayList<Integer>> combine(int n, int k) {
	    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
	    ArrayList<Integer> temp = new ArrayList<>();
	    Set<Integer> set = new HashSet<>();
	    helper(n,k, 1, set,temp,res);
	 		return res;
	  }
	  private void helper(int n, int k, int index, Set<Integer> set, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> res) {
	    if (temp.size() == k){
	      res.add(new ArrayList<Integer>(temp));
	 			return;
	    }
	    for(int i = index; i <= n; i++) {
	      boolean succ = set.add(i);
	      if (succ) {
	        temp.add(i);
	        helper(n, k, i, set, temp,res);
	        temp.remove(temp.size() - 1);
	        set.remove(i);
	      }
	    }
	  }
	  //Time complexity: O(n!) 
	  //Space complexity: O(n)
}
