
public class Solution8 {

	public static void main(String[] args) {
		int[] input = new int[]{5,3,2,1,4,6};
		Solution8 s = new Solution8();
		System.out.println(s.maxTrapped(input));
	}

	  public int maxTrapped(int[] array) {
		    int len = array.length;
		    int[] dpLeft = new int[len];
		    int[] dpRight = new int[len];
		    for (int i = 0; i < len; i++) {
		      if (i == 0 || dpLeft[i - 1] < array[i]) {
		        dpLeft[i] = array[i];
		      } else {
		        dpLeft[i] = dpLeft[i - 1];
		      }
		    }
		    for (int i = len - 1; i >= 0 ; i--) {
		      if (i == len - 1 || dpRight[i + 1] < array[i]) {
		        dpRight[i] = array[i];
		      } else {
		      	dpRight[i] = dpRight[i + 1];
		      }
		    }
		    int total = 0;
		    for (int i = 0; i < len; i++) {
		      total += Math.min(dpLeft[i], dpRight[i]) - array[i];
		    }
		    return total;
	  }
	  //Time complexity: O(n)
	  //Space complexity: O(n)
	  
	  public int maxTrapped1(int[] array) {
		    int left = 0;
		    int right = array.length - 1;
		    int max = 0;
		    int leftMax = 0;
		    int rightMax = 0;
		    while(left < right) {
		      leftMax = Math.max(leftMax, array[left]);
		      rightMax = Math.max(rightMax, array[right]);
		      if (leftMax < rightMax) {
		        max += Math.min(leftMax,rightMax) - array[left];
		        left++;
		      } else {
		        max += Math.min(leftMax, rightMax) - array[right];
		        right--;
		      }
		    }
		    return max;
		  }
	  //Time complexity: O(n)
	  //Space complexity: O(1)
}
