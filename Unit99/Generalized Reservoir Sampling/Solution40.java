import java.util.ArrayList;
import java.util.List;
/*
Consider an unlimited flow of data elements. How do you sample k element from this flow, such that at any point during the processing of the flow, you can return a random set of k elements from the n elements read so far. 

Assumptions

k >= 1
You will implement two methods for a sampling class:

read(int value) - read one number from the flow
sample() - return at any time the k samples as a list, return the list of all values read when the number of values read so fas <= k.
You may need to add more fields for the class.
 */
public class Solution40 {
	private final int k;
	private List<Integer> res;
	private int counter;
	public Solution40(int k) {
		this.k = k;
		res = new ArrayList<Integer>();
		counter = 0;
	}
		  
	public void read(int value) {
		counter++;
		if (counter <= k){
			res.add(value);
		} else {
			int index = (int)(Math.random()*counter);
			if (counter < k) {
				res.remove(index);
				res.add(index, value);
			}
		}
	}
		  
	public List<Integer> sample() {
		return res;
	}
}
