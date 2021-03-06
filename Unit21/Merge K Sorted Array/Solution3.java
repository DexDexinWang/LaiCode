import java.util.PriorityQueue;

public class Solution3 {

	public static void main(String[] args) {
		int[][] input = {{},{1,5,7},{4},{2,3,5,11},{2,4,4,6,8}};
		System.out.println(merge(input));
	}
	  //approach: use priority queue to solve this problem;
	  public static int[] merge(int[][] arrayOfArrays) {
		    int rows = arrayOfArrays.length;
		    int total = 0;
		    PriorityQueue<Unit> minHeap = new PriorityQueue<Unit>(rows);
		    for (int i = 0; i < rows; i++) {
		      total += arrayOfArrays[i].length;
		      if (arrayOfArrays[i].length == 0) {
		        continue;
		      }
		    }
		    
		    int[] res = new int[total];
		    for (int i = 0; i < total; i++) {
		      Unit cur = minHeap.poll();
		      res[i] = cur.val;
		      if (cur.col < arrayOfArrays[cur.row].length - 1) {
		        minHeap.offer(new Unit(cur.row, cur.col + 1, 
		                              arrayOfArrays[cur.row][cur.col + 1]));
		      } 
		    }
		    return res;
		  }
		   
		static class Unit implements Comparable<Unit> {
		    int row;
		    int col;
		    int val;
		    public Unit(int row, int col, int val) {
		      this.row = row;
		      this.col = col;
		      this.val = val;
		    }
		    @Override
		    public int compareTo(Unit other) {
		      if (this.val == other.val) {
		        return 0;
		      }
		      return this.val < other.val ? -1 : 1;
		    }
		  }
		//Time complexity: O(n*logK); where k is the number of rows; n is all nodes of the sorted array.
		//Space complexity: O(k);
}
