
public class Solution4 {

	public static void main(String[] args) {
		int[] input = {-100, 2, 7, 9, 15};
		System.out.println(minDifference(input));
	}
	
	  //approach: use DFS to check all possible result;
	  //levels: n/2 levels.
	  //states: from (n to n/2) with incresing level.
	  //current level: add a new number and check rest; 
	  public static int minDifference(int[] array) {
	    //get sum of the array;
	    int sum = 0;
	    for(int num: array) {
	      sum += num;
	    }
	    int[] min = new int[]{Integer.MAX_VALUE};
	    minDifference(array, min, array.length / 2, 0, 0, sum);
	    return min[0];
	  }
	  
	  private static void minDifference(int[] array, int[] min, int remaining, int index, int curSum, int total) {
	    if (remaining == 0) {
	      min[0] = Math.min(min[0], Math.abs(curSum - (total - curSum)));
	    } else {
	      for (int i = index; i <= array.length - remaining; i++) {
	        if (curSum + array[i] - total/2 >= min[0]) {
		    	continue;
		    }
	    	minDifference(array, min, remaining - 1, i + 1, curSum + array[i], total);
	      }
	    }
	  }
	  //Time complexity: O(n - n/2) !  / (n/2) !
	  //Space complexity: O (n/2) call stack.
}
