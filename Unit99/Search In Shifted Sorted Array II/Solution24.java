
public class Solution24 {

	public static void main(String[] args) {
		int[] input = {1,2,3,4,5,6};
		System.out.println(search(input,4));		
	}

	public static int search(int[] array, int target) {
		//how: 1. corner case;
	    if (array == null || array.length == 0) {
	    	return -1;
	    }
	    //2. find the rotated position.
	    int low = 0;
	    int high = array.length - 1;
	    while (low <= high) {
	    	int mid = low + (high - low) / 2;
	    	if (array[mid] == target) {
	    		return mid;
	    	} else if (array[low] < array[mid]) {
	    		//left part is sorted
	    		if (target >= array[low] && target <= array[mid]) {
	    			high = mid - 1;
	    		} else {
	    			low = mid + 1;
	    		}
	    	} else if (array[low] > array[mid]) {
	    		//right part is sorted
	    		if (target >= array[mid] && target <= array[high]) {
	    			low = mid + 1;
	    		} else {
	    			high = mid - 1;
	    		}
	    	} else {
	    		low ++ ;
	    	}
	    }
	  
		return -1;
	}
	//Time complexity: O(n)
	//Space complexity: O(1);
}
