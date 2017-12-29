import java.util.ArrayList;
import java.util.List;

public class Solution6 {

	public static void main(String[] args) {
		List<Integer> input = new ArrayList<Integer>();
		System.out.println(percentile95(input));
	}
	//what: to find the L which means that 95% urls` lengths are smaller than L.
	public static int percentile95(List<Integer> lengths) {
		int[] array =new int[4101];
		for(Integer len : lengths) {
			array[len] ++;
		}
		int total = 0;
		int len = 4100;
		while (total <= 0.05 * 4100) {
			total += array[--len];
		}
		return len;
	}

}
