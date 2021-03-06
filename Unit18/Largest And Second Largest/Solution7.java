import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution7 {

	public static void main(String[] args) {
		int[] input = {3,5,2,2,1,6,3,4,5};
		System.out.println(Arrays.toString(largestAndSecond(input)));
	}
	  public static int[] largestAndSecond(int[] array) {
		    //base case
		    int[] res = new int[2];
		    if (array.length == 0) {
		      return res;
		    } 
		    if (array.length == 1) {
		      res[0] = array[0];
		      res[1] = array[0];
		      return res;
		    } 
		    List<Integer> cur = new ArrayList<Integer>();
		    Queue<List<Integer>> queue = new LinkedList<>();
		    //get two element each around
		    for (int i = 0; i < array.length - 1; i += 2) {
		      cur.clear();
		      if (array[i] > array[i + 1]) {
		        cur.add(array[i]);
		        cur.add(array[i + 1]);
		      } else {
		        cur.add(array[i + 1]);
		        cur.add(array[i]);
		      }
		      queue.offer(new ArrayList<Integer>(cur));
		    }
		    //if the total number is odd.
		    if (array.length % 2 == 1) {
		      cur.clear();
		      cur.add(array[array.length - 1]);
		      cur.add(Integer.MIN_VALUE);
			  queue.offer(new ArrayList<Integer>(cur));
		    }
		    //fully loaded walk comparison. 
		    cur = queue.poll();
		    while (!queue.isEmpty()) {
		      Integer i = cur.get(0);
		      Integer j = queue.peek().get(0);
		      if (i > j) {
		        queue.poll();
		        cur.add(j);
		        queue.offer(new ArrayList<Integer>(cur));
		      } else {
		        cur = queue.poll();
		        cur.add(i);
		        queue.offer(new ArrayList<Integer>(cur));
		      }
		      cur = queue.poll();
		    }
		    //get second largest num;
		    int second = Integer.MIN_VALUE;
		    for(int i = 1; i < cur.size(); i++) {
		      second = Math.max(second, cur.get(i));
		    }
		    
		    res[0] = cur.get(0);
		    res[1] = second;
		    return res;
		  }
	  //Time complexity: O(n + logn)
	  //Space complexity: O(n)
}
