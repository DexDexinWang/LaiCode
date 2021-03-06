import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution52 {

	public static void main(String[] args) {
		int[] input = {1,2,1,2,1};
		System.out.println(majority(input,3));
	}
	public static List<Integer> majority(int[] array, int k) {
		List<Integer> res =  new ArrayList<Integer>();
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0 ; i < array.length ; i++) {
			map.put(array[i], map.getOrDefault(array[i], 0) + 1);
		}
		int nums = array.length / k;
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > nums){
				res.add(entry.getKey());
			}
		}
		return res;
	}
}
