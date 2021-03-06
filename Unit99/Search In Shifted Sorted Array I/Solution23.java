
public class Solution23 {

	public static void main(String[] args) {
		int[] input = {3, 5, 6, 1, 2};
		System.out.println(search(input,4));
	}
	
	//what: find a number in an rotated sorted array. 
	public static int search(int[] array, int target) {
		//how: 1. corner case;
	    if (array == null || array.length == 0) {
	    	return -1;
	    }
	    //2. find the rotated position.
	    int low = 0;
	    int high = array.length - 1;
	    while (low < high) {
	    	int mid = low + (high - low) / 2;
	    	if (array[mid] > array[high]) {
	    		low = mid + 1;
	    	} else {
	    		high = mid;
	    	}
	    }
	    int rotated = low;
	    //3. find the target
	    low = 0;
	    high = array.length - 1;
	    while (low <= high) {
	    	int mid = low + (high - low) / 2;
	    	int realMid = (mid + rotated) % array.length;
	    	if (array[realMid] == target) {
	    		return realMid;
	    	} else if (array[realMid] < target) {
	    		low = mid + 1;
	    	} else {
	    		high = mid - 1;
	    	}
	    }
	    
		return -1;
	}

	//Time complexity: O(logn):
	//Space complexity: O(1)
}
