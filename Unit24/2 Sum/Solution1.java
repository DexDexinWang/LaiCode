import java.util.Arrays;

public class Solution1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	//approach: sort eles and traverse value with two pointers. 
	  //which scource do you want me to optimize? time or space?
	  public boolean existSum(int[] array, int target) {
	    if (array == null || array.length == 0) {
	      return false;
	    }
	    Arrays.sort(array);
	    int i = 0; 
	    int j = array.length - 1;
	    while (i < j) {
	      int sum = array[i] + array[j];
	      if (sum == target) {
	        return true;
	      } else if (sum > target) {
	        j--;
	      } else {
	        i++;
	      }
	    }
	    return false;
	  }
	  //time complexity: O(nlogn)
	  //space complexity: O(1)

}
