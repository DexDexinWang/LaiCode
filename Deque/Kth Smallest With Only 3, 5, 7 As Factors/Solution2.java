
public class Solution2 {

	public static void main(String[] args) {
		
	}
	  //approach: solve the problem as dynamic problem with one dimensional array. 
	  //base case: 
	  //dp[0] = 105;
	  //induction rule;
	  //dp[i] represent the minimal value for the (i + 1)th element that satisfied the requirements.
	  //dp[i] = min(dp[x],dp[y],dp[z]) where dp[x] is the elemnt that times 3 in previous round. .... 
	  public long kth(int k) {
		    int[] dp = new int[k];
		    dp[0] = 105;
		    int indexOfThree = 0;
		    int indexOfFive = 0;
		    int indexOfSeven = 0;
		    int nextOfThree = 3 * dp[0];
		    int nextOfFive = 5 * dp[0];
		    int nextOfSeven = 7 * dp[0];
		    int nextNumber = 105;
		    
		    for(int i = 1; i < k; i++) {
		      nextNumber = Math.min(nextOfThree, Math.min(nextOfFive, nextOfSeven));
		      dp[i] = nextNumber;
		      if (nextNumber == nextOfThree) {
		        indexOfThree++;
		        nextOfThree = dp[indexOfThree] * 3;
		      }
		      if (nextNumber == nextOfFive) {
		        indexOfFive++;
		        nextOfFive = dp[indexOfFive] * 5;
		      }
		      if (nextNumber == nextOfSeven) {
		        indexOfSeven++;
		        nextOfSeven = dp[indexOfSeven] * 7;
		      }
		    }
		    return nextNumber;
		  }
	  //Time complexity: O(n)
	  //Space complexity: O(n)

}
