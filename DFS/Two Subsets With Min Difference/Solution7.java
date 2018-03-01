
public class Solution7 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  //DFS
	  //n/2 levels:  each level make a decision to choose one number to be added. 
	  //n`/2 branches: choose the remaining numbers / 2 as branches.
	  public int minDifference(int[] array) {
	    int sum = 0;
	    for(int num: array) {
	      sum += num;
	    }
	    int[] minDiffer = new int[]{Integer.MAX_VALUE};
	    getSum(array, 0, 0, minDiffer, 0, sum);
	    return minDiffer[0];
	  }
	  
	  private void getSum(int[] array, int index, int counter, int[] minDiffer, int half, int sum) {
	    if (counter == array.length / 2) {
	      minDiffer[0] = Math.min(minDiffer[0], Math.abs(sum - 2 * half));   
	      return;
	    }
	    if (index == array.length) {
	      return;
	    }
	    getSum(array, index + 1, counter + 1, minDiffer, half + array[index], sum);
	    getSum(array, index + 1, counter, minDiffer, half, sum);
	  }
	  //Time complexity: O(n!);
	  //Space complexity: O(n/2) = O(n):
}
