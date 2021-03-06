import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution31 {

	public static void main(String[] args) {
		List<Integer> input1 = new ArrayList<Integer>();
		input1.add(1);
		input1.add(2);
		input1.add(3);
		List<Integer> input2 = new ArrayList<Integer>();
		input2.add(3);
		input2.add(1);
		input2.add(4);
		System.out.println(common(input1, input2));
	}
	/* Find all numbers that appear in both of the two unsorted arrays, 
	 * return the common numbers in increasing order.
	 */

	public static List<Integer> common(List<Integer> a, List<Integer> b) {
		List<Integer> res = new ArrayList<Integer>();
		if (a.size() == 0 || b.size() == 0) {
			return res;
		}
		Set<Integer> set = new HashSet<Integer>();
		for(Integer num : a) {
			set.add(num);
		}
		for(Integer num : b) {
			if (set.contains(num)){
				res.add(num);
			}
		}
		Collections.sort(res);
		return res;
	}

	//Time complexity O(nlogn)  n = min(a.size(), b.size());
	//Space complexity O(n):
}
