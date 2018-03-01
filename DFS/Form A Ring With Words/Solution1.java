
public class Solution1 {

	public static void main(String[] args) {
		Solution1 s = new Solution1();
		String[] input = {"aab","dca","bad","dab"};
		System.out.println(s.formRing(input));
	}
	  
	  //DFS
	  //N levels. Each level tries one string value to be connected. 
	  //N` braches. N` means the remining 
	  boolean check= false;
	  public boolean formRing(String[] input) {
	    if (input.length == 1) {
	    	return input[0].charAt(input[0].length() - 1) == input[0].charAt(0);
	    }
	    helper(input, 0);
	    return check;
	  }
	  
	  private void helper(String[] input, int index) {
	    if (index == input.length) {
	      check = true;
	    }
	    for(int i = index; i < input.length; i++) {
	      swap(input, i , index);
	      if (valid(input, index)){
	        helper(input, index + 1);
	      }
	      swap(input, i , index);
	    }
	  }
	  
	  private void swap(String[] input, int i, int j) {
	    String temp = input[i];
	    input[i] = input[j];
	    input[j] = temp;
	  }
	  
	  private boolean valid(String[] input, int i) {
	    if (i == 0) {
	      return true;
	    } else if (i == input.length - 1) {
		  char prelast = input[i - 1].charAt(input[i - 1].length() - 1);
	      char last = input[i].charAt(input[i].length() - 1);
	      return last == input[0].charAt(0) && input[i].charAt(0) == prelast;
	    } else {
	      char last = input[i - 1].charAt(input[i - 1].length() - 1);
	      return input[i].charAt(0) == last;
	    }
	  }
	  //Time complexity: O(n!);
	  //Space complexity: O(n);
}
