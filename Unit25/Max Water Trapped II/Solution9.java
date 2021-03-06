import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution9 {

	public static void main(String[] args) {
		

	}
	  public int maxTrapped(int[][] matrix) {
		    int rows = matrix.length;
		    int cols = matrix[0].length;
		 	PriorityQueue<Unit> minHeap = new PriorityQueue<>();
		    boolean[][] visited = new boolean[rows][cols];
		    processBoundry(matrix, minHeap, visited, rows, cols);
		    int total = 0;
		    while (!minHeap.isEmpty()) {
		      Unit unit = minHeap.poll();
		      List<Unit> neis = findAllNeis(unit, matrix, visited);
		      for (Unit nei: neis) {
		        if (visited[nei.row][nei.col]) {
		          continue;
		        }
		        visited[nei.row][nei.col] = true;
		        total += Math.max(unit.val - nei.val, 0);
		        nei.val = Math.max(unit.val, nei.val);
		        minHeap.offer(nei);
		      }
		    }
		    return total;
		  }
		  
		  private List<Unit> findAllNeis(Unit unit, int[][] matrix, boolean[][] visited) {
		    List<Unit> neis = new ArrayList<>();
		    if (unit.row + 1 < matrix.length) {
		      neis.add(new Unit(unit.row + 1, unit.col, matrix[unit.row + 1][unit.col]));
		    }
		    if (unit.row - 1 >= 0) {
		      neis.add(new Unit(unit.row - 1, unit.col, matrix[unit.row - 1][unit.col]));
		    }
		    if (unit.col + 1 < matrix[0].length) {
		      neis.add(new Unit(unit.row, unit.col + 1, matrix[unit.row][unit.col + 1]));
		    }
		    if (unit.col - 1 >= 0) {
		      neis.add(new Unit(unit.row, unit.col - 1, matrix[unit.row][unit.col - 1]));
		    }
		    return neis;
		  }
		  
		  
		  private void processBoundry(int[][] matrix, PriorityQueue<Unit> minHeap, 
		                              boolean[][] visited, int rows, int cols) {
		    for(int i = 0; i < rows; i++) {
		      for (int j = 0; j < cols; j++) {
		        if (i == 0 || j == 0 || i == rows - 1 || j == cols -1) {
		          minHeap.offer(new Unit(i,j,matrix[i][j]));
		          visited[i][j] = true;
		        }
		      }
		    }
		  }
		     	  
		  
		  
		  class Unit implements Comparable<Unit> {
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
}
