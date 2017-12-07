import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Dexin Wang
 * @Date Dec 5, 2017
 */
public class Solution3 {

	public static void main(String[] args) {
		List<Integer> input1  = new ArrayList<Integer>();
		input1.add(3);
		input1.add(4);
		input1.add(5);
		input1.add(5);
		List<Integer> input2  = new ArrayList<Integer>();
		input2.add(1);
		input2.add(2);
		input2.add(3);
		input2.add(5);
		System.out.println(common1(input1,input2));
	}
	//what: find the same number and put them into the result array.
	public static List<Integer> common(List<Integer> A, List<Integer> B) {
		List<Integer> res = new ArrayList<Integer>();
		//how: 1. corner case
		if (A.size() == 0 || B.size() == 0) {
			return res;
		}
		//2. make a while loop to check the same number
		int i = 0; 
		int j = 0;
		while (i < A.size() && j < B.size()) {
			if (A.get(i) == B.get(j)) {
				res.add(A.get(i));
				i++;
				j++;
			} else if (A.get(i) < B.get(j)) {
				i++;
			} else {
				j++;
			}
		}
		//3. return res;
		return res;
	}
	//Time Complexity: O(m + n)
	//Space Complexity: O(max(m,n))
	
	//what: iterate every node in B and check that is in A. 
	public static List<Integer> common1(List<Integer> A, List<Integer> B) {
		List<Integer> res = new ArrayList<Integer>();
		//how: 1. corner case
		if (A.size() == 0 || B.size() == 0) {
			return res;
		}
		// 2. save all numbers from B into HashMap
		Map<Integer, Integer> map = new HashMap<>();
		for (Integer i: B) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		// 3. iterate all numbers in A
		for (Integer i: A) {
			if(map.containsKey(i) && map.get(i) > 0) {
				map.put(i, map.get(i) - 1);
				res.add(i);
			}
		}
		return res;
	}
	//Time Complexity: O(m + n)
	//Space Complexity: O(m + n)

}
