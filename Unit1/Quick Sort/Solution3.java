import java.util.Arrays;

public class Solution3 {
	public static void main(String[] args) {
		int[] input = {2,3,4,3,5,6};
		System.out.println(Arrays.toString(quickSort(input)));
	}
	
	//what: quicksort is to choose a random number as pivot and to divide the array into two sub-arrays
	  public static int[] quickSort(int[] array) {
		    //corner case
		    if (array == null || array.length <= 1) {
		      return array;
		    }
		    //divide, seprate set into two subsets.
		    divide(array, 0, array.length - 1);
		    return array;
		  }
		  //divide, recursively separate element in array from left to right side included both boundaries.
		  private static void divide(int[] array, int left, int right) {
		    //base case, if there is only one ele in the subset.
		    if (left >= right) {
		      return;
		    }
		    //pivot, that will reorder all element and return a mid pointer. 
		    int mid = pivot(array, left, right);
		    divide(array, left, mid - 1);
		    divide(array, mid + 1, right);
		  }
		  //pivot will randomly pick up a element, and move all eles that is smaller and equal to mid to left side. do same things in right side.
		  private static int pivot(int[] array, int left, int right) {
		    //randomly find a pivot number
		    int pivotIndex = left + (int)(Math.random() * (right - left + 1));
		    int pivot = array[pivotIndex];
		    //move pivot number to the end, in order to do next comparations.
		    swap(array, pivotIndex, right);
		    //define pointers to compare all elements with the pivot number.
		    int leftPointer = left;
		    int rightPointer = right - 1;
		    while (leftPointer <= rightPointer) {
		      if (array[leftPointer] <= pivot) {
		        leftPointer++;
		      } else if (array[rightPointer] > pivot) {
		        rightPointer--;
		      } else {
		        swap(array,leftPointer++, rightPointer--);
		      }
		    }
		    //move the pivot number into the mid that make all elements in an order.
		    swap(array, leftPointer, right);
		    return leftPointer;
		  }
		  
		  private static void swap (int[] array, int i , int j) {
		    int temp = array[i];
		    array[i] = array[j];
		    array[j] = temp;
		  }
	// Time complexity: 
	// Divide: O(n)
	// pivot: O(n) + O(n-1) + O(n-2) + ... O(1) = O(n*(n-1)/2) = O(n^2)
	// Space Complexity: O(logn)  in-place
}
