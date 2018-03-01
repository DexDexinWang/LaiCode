import java.util.ArrayList;
import java.util.List;

public class Solution6 {

	public static void main(String[] args) {
		Solution6 s = new Solution6();
		System.out.println(s.factors(12));
	}
	  //number of candidates levels, each levels chose # of one candidate value.
	  //branches, # of one candidate value. 
	  public List<List<Integer>> factors(int n) {
	    List<List<Integer>> res = new ArrayList<List<Integer>>();
	    List<Integer> temp = new ArrayList<Integer>();
	    List<Integer> candidates = getCandidates(n);
	    helper(n, 0, candidates, temp, res);
	    return res;
	  }
	  
	  private void helper(int remaining, int index, List<Integer> cands, List<Integer> temp, List<List<Integer>> res) {
	    if (index == cands.size()) {
	      if (remaining == 1) {
	      	res.add(new ArrayList<Integer>(temp));
	      }
	      return;
	    }
	    int divisor = cands.get(index);
	 	for (int i = 1; (Math.pow(divisor, i) <= remaining) && (remaining % Math.pow(divisor, i) == 0) ; i++) {
	 	  for(int j = 0; j < i; j++) {
	 		  temp.add(divisor);
	 	  }
	      helper(remaining /(int)Math.pow(divisor, i), index + 1, cands, temp,res);
	      for(int j = 0; j < i; j++) {
	    	  temp.remove(temp.size() - 1);
	 	  }
	    }
	    helper(remaining, index + 1, cands, temp, res);
	  }
	  
	               
	  private List<Integer> getCandidates(int n) {
	    List<Integer> cands = new ArrayList<Integer>();
	    for (int i = 2; i <= n/2; i++) {
	      if (n % i == 0) {
	        cands.add(i);
	      }
	    }
	    cands.add(n);
	    return cands;
	  }
	  //Time complexity: O(n ^ m) where n is the # of factors, 2^m <= number  and 2^(m+1) > number
	  //space complexity: O(n) call stack.
}
