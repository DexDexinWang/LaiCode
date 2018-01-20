
public class Solution1 {

	public static void main(String[] args) {
		String[] input = {"a","bc","c","ddb","cd","da","aad"};
		System.out.println(formRing(input));
	}
	
	  //approach: use recursion to solve problem 
	  //base case: rturn array[length - 1].charAt(array[length - 1].length() - 1) == array[0].charAt(array[0].length() - 1);
	  //recursion rule: formRing formRing(array[i])) = formRing(array[i + 1]);
	  public static boolean formRing(String[] input) {
	    return formRaing(input, 0, getLastChar(input, 0));
	  }
	  
	  private static boolean formRaing(String[] input, int index, char prev) {
	    if (index == input.length) {
	      return prev == getFirstChar(input, 0);
	    }
	    if (getFirstChar(input, index) != prev) {
	      return false;
	    } else {
	      return formRaing(input, index + 1, getLastChar(input,index));
	    }
	  }
	  
	  private static char getLastChar(String[] input, int index) {
	    return input[index].charAt(input[index].length() - 1);
	  }
	  
	  private static char getFirstChar(String[] input, int index) {
	    return input[index].charAt(0);
	  }
	  
	  //Time complexity: O(n)
	  //Space complexity: O(n) //call stack

}