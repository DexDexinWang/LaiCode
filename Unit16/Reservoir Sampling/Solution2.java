public class Solution2 {
	int count;
	Integer sample;
	
	public Solution2() {
		count = 0;
		sample = null;
	}
	
	public void read(int value) {
		count++;
		int prob = (int)(Math.random()*count);
		if (prob == 0) {
			sample = value;
		}
	}
	
	public Integer smaple() {
		return sample;
	}
	
}
