
public class Solution1 {

	public static void main(String[] args) {

	}

	  //approach: to check number from 1 to n whehre n is the final number
	  public int kth(int k) {
	    int counter = 0;
	    int begin = 0;
	    while (counter < k) {
	      begin++;
	      if (check(begin) == 1) {
	        counter++;
	      }
	    }
	    return begin;
	  }
	  
	  public int divide(int a, int b) {
	    while (a % b == 0) {
	      a /= b;
	    }
	    return a;
	  }
	  
	  public int check(int num) {
	    num = divide(num, 2);
	    num = divide(num, 3);
	    return num == 1? 1 : 0;
	  }
	  //Time complexity: O(2*32*num) where num is the final value; 
	  //Space compelxity: O(1)
	  
	  
	  
	  //approach: solve the problem as dynamic problem whith 1 one array;
	  //base case;
	  //dp[0] = 1;
	  //base case;
	  //dp[i] represents the minimumal value for i + 1 th number that satisfied the requirements.
	  //dp[i] = Min(dp[x],dp[y]) where dp[x] is number that times 2 in last step. dp[y] is a number that times 3 in its last step. 
	  public int kth1(int k) {
	    int[] dp = new int[k];
	    int indexTwo = 0;
	    int indexThree = 0; 
	    int numberOfTwo = 2;
	    int numberOfThree = 3;
	    int nextNumber = 1;
	    dp[0] = 1;
	    for (int i = 1 ; i < k ; i++) {
	      nextNumber = Math.min(numberOfTwo, numberOfThree);
	      dp[i] = nextNumber;
	      if (nextNumber == numberOfTwo) {
	        indexTwo += 1;
	        numberOfTwo = dp[indexTwo] * 2;
	      }
	      if (nextNumber == numberOfThree) {
	        indexThree +=1;
	        numberOfThree = dp[indexThree] * 3;
	      }
	    }
	    return nextNumber;
	  }
	  //Time complexity: O(k);
	  //Space complexity: O(k);
}
