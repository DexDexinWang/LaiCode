
public class Solution5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//what: to merge the elements in left side and and elements in right size within recursion 
	public int[] reorder(int[] array) {
		//1. corner: consider the length is odd or even because we the merged unit is a pair value. 
		if (array.length % 2 == 0) {
			reorder(array, 0, array.length -1);
		} else {
			reorder(array, 0, array.length - 2);
		}
		return array;
	}

	private void reorder(int[] array, int left, int right) {
		//2. get total length to divide array into 4 parts.
		int length = right - left + 1;
		if (length <= 2) {
			return ;
		}
		int mid = left + length / 2;
		int lmid = left + length / 4;
		int rmid = left + length * 3 / 4;
		//3. reverse the middle two sets like "reverse all words in a sentence".
		reverse(array, lmid, mid - 1);
		reverse(array, mid, rmid - 1);
		reverse(array, lmid, rmid - 1);
		//4. recursively solve sub-problem.
		reorder(array, left, left + (lmid - left) * 2 -1);
		reorder(array, left + (lmid -left) * 2, right);
	}
	
	private void reverse(int[] array, int left, int right) {
		while (left < right) {
			int temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left++;
			right--;
		}
	}
	//Time complexity: O(logN) levels * O(n) = O(nlogn);
	//Space complexity: O(logn)

}
