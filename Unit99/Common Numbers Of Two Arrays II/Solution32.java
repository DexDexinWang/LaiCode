import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution32 {

	public static void main(String[] args) {
		List<Integer> input1 = new ArrayList<Integer>();
		input1.add(1);
		input1.add(2);
		input1.add(3);
		List<Integer> input2 = new ArrayList<Integer>();
		input2.add(3);
		input2.add(1);
		input2.add(4);
		System.out.println(common(input1,input2));
	}
	//What: find all numbers that appear in both of two unsorted arrays and show them sorted way.
	//Both of the two arrays are not null.
	//In any of the two arrays, there could be duplicate numbers.
	public static List<Integer> common(List<Integer> A, List<Integer> B) {
		//How: 1. corner case;
		List<Integer> res = new ArrayList<Integer>();
		if (A.size() == 0 || B.size() == 0) {
			return res;
		}
		//2. sort two arrays;
		Collections.sort(A);
		Collections.sort(B);
		//3. compare number step by step and add them into result.
		int i = 0;
		int j = 0;
		while (i < A.size() && j < B.size()) {
			if (A.get(i) < B.get(j)) {
				i++;
			} else if (A.get(i) > B.get(j)) {
				j++;
			} else {
				res.add(A.get(i));
				i++;
				j++;
			}
		}
		return res;
	}
	//Time complexity: O(mlogm + Onlogn + min(m,n)) = O(min(mlogm,nlogn));
	//Space complexity: O(min(m,n));
}
