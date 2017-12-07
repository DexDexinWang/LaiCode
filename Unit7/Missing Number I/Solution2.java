import java.util.HashSet;
import java.util.Set;

/**
 * @author Dexin Wang
 * @Date Dec 5, 2017
 */
public class Solution2 {
	public static void main(String[] args) {
		int[] input = {2,3,4,5};
		System.out.println(missing2(input));
	}
	
	//What: get the difference between the sum of 1 to n and sum of all numbers in the array
	public static int missing(int[] array) {
		//How: 1. corner case
		if (array.length == 0) {
			return 1;
		}
		//2. get sum of 1 to n
		int n = array.length + 1;  
		int total = n * (n + 1) / 2; 
		//3. get sum of all numbers in the array
		int sum = 0;
		for (int i = 0; i < array.length; i++) {
			sum += array[i];
		}
		//4. return difference
		return total - sum;
	}
	//Time Complexity: O(n)
	//Space Complexity: O(1)
	//disadvantage: sum overflow;
	
	
	//what: traverse numbers from 1 to n and check whether they are in the array.
	public static int missing1(int[] array) {
		//How: 1. corner case
		if (array.length == 0) {
			return 1;
		}
		//2. put all values into HashSet for O(1) time complexity
		Set<Integer> set = new HashSet<>(); 
		for (int i: array) {
			set.add(i);
		}
		//3. check numbers from 1 to n
		for ( int i = 1; i <= array.length + 1; i++) {
			if(!set.contains(i)) {
				return i;
			}
		}
		return -1;
	}
	//Time Complexity: O(n)
	//Space Complexity: O(n)
	
	//what: use bit operation to find unknown value
	public static int missing2(int[] array) {
		//How: 1. corner case
		if (array.length == 0) {
			return 1;
		}
		//2. do XOR for all numbers in array
		int sum = 0;
		for (int i: array) {
			sum = sum ^ i;
		}
		//3. do XOR for numbers from 1 to n
		for (int i = 1; i <= array.length + 1; i++) {
			sum = sum ^ i;
		}
		return sum;
	}
	//Time Complexity: O(n);
	//Space Complexity: O(1);
	
	//what: swap each number in array and find the missing value
	public static int missing3(int[] array) {
		//How: 1. corner case
		if (array.length == 0) {
			return 1;
		}
		//2. swap each number to fine the correct position
		for (int i = 0 ; i < array.length ; i++) {
			while (array[i] != i + 1 && array[i] != array.length + 1) {
				swap(array, array[i] - 1, i);
			}
		}
		//3. check the array find the position 
		for ( int i = 0 ; i < array.length; i++) {
			if (array[i] != i + 1) {
				return i+1;
			}
		}
		//4. return result
		return array.length + 1;
	}
	//Time Complexity: O(n);
	//Space Complexity: O(1); In-Place;
	
	private static void swap(int[] array, int i,int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
}
