import java.util.Arrays;

public class Solution2 {

	public static void main(String[] args) {
		int[] input = {2,3,4,3,5,6,3};
		System.out.println(Arrays.toString(mergeSort(input)));
	}
	//what: to sort all numbers with merge sort: divide + merge
	public static int[] mergeSort(int[] array) {
		if (array == null || array.length <= 1) {
			return array;
		}
		//divide separate set into two subset until each subset has only one element.
		divide(array, 0, array.length - 1);
		return array;
	}
	//divide all numbers into sub-groups recursively until the each sub-group only has one number from high level to lower level.
	public static void divide(int[] array, int left, int right){
		if (left >= right) {
			return;
		}
		int mid = left + (right - left)/ 2;
		divide(array, left, mid);
		divide(array, mid + 1, right);
		merge(array, left, mid, right);
	}
	//2. merge all subsets from low level to high level.
	public static void merge(int[] array, int left, int mid, int right) {
		//2.1 define sub arrays 
		int len1 = mid - left + 1;
		int len2 = right - mid; 
		int[] l = new int[len1];
		int[] r = new int[len2];
		for (int i = 0 ; i < len1 ; i++) {
			l[i] = array[left + i];
		}
		for (int j = 0 ; j < len2 ; j++) {
			r[j] =array[mid + j + 1];
		}
		//2.2. find the each minimum number to sort all numbers
		int i = 0;
		int j = 0;
		int index = left;
		while (i < len1 && j < len2) {
			if (l[i] < r[j]) {
				array[index++] = l[i++];
			} else {
				array[index++] = r[j++];
			}
		}
		while (i < len1) {
			array[index++] = l[i++];
		}
		while (j < len2) {
			array[index++] = r[j++];
		}
	}
	//Time Complexity: 
	//divide = O(1) + O(2) + O(4) + ... + O(n) = O(n)
	//merge  = O(n) + O(n) + .... + O(n) = O(nlog(n))
	//Space Complexity: O(n)
	
	
	
}
