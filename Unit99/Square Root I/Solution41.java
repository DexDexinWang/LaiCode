
public class Solution41 {

	public static void main(String[] args) {
		System.out.println(sqrt(10));
	}
	
	public static int sqrt(int x) {
		int i = 0;
		while (i * i <= x) {
			i++;
		}
		return i * i == x ? i : i - 1;
	}
	
	//what: find the square root with binary search tree.
	public static int sqrt1(int x) {
		//how: 1. corner case
	    if (x <= 1) {
	    	return x;
	    }
	    //2. binary search to get smallest range.
		int left = 0; 
		int right = x;
		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (mid * mid == x) {
				return mid;
			} else if (mid * mid < x) {
				left = mid;
			} else {
				right = mid;
			}
		}
		
		if (right * right <= x) {
			return (int) right;
		} else {
			return (int) left;
		}
		
	}

}
