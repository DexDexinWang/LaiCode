import java.util.ArrayList;
import java.util.List;

/**
 * @author Dexin Wang
 * @Date Dec 6, 2017
 */
public class Solution4 {

	public static void main(String[] args) {
		int input1 = 99;
		int[] input2 = {25, 10, 5, 1};
		System.out.println(combinations(input1,input2));
	}

	//what: find each combination from 25 cent to 1 cent
	public static List<List<Integer>> combinations(int target, int[] coins) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		//how: 1. create temp space to store the combination for target
		List<Integer> temp = new ArrayList<Integer>();
		helper(target, temp, coins, 0, res);
		return res;
	}
	
	//2. recursively find numbers of each coin in possible combination 
	private static void helper(int remaining, List<Integer> temp, int[] coins, int index, List<List<Integer>> res) {
		//2.1 base case with the special combination that will not equal to the target.
		if (index == coins.length -1) {
			if (remaining % coins[index] == 0) {
				temp.add(remaining / coins[index]);
				res.add(new ArrayList<Integer>(temp));
				temp.remove(temp.size()-1);
			}
			return;
		}
		//2.2 for numbers of the current coin, then to get possible number of the next coins.  
		int max = remaining/coins[index];
		for (int i = 0; i <= max; i++) {
			temp.add(i);
			helper(remaining - i * coins[index], temp, coins, index + 1, res);
			temp.remove(temp.size()-1);
		}
	}
	
	//Time Complexity: O(number of coins ^ (target / min(coins))) = O(4^99);
	//Space Complexity: O(99);

}
