import java.util.LinkedList;
import java.util.Queue;

public class Solution4 {

	public static void main(String[] args) {
		Solution4 s = new Solution4();
		int[][] input = {{0,1,0,1},{1,0,0,1},{0,1,1,0},{0,1,0,0}};
		System.out.println(s.whiteObjects(input));
	}
	 public int whiteObjects(int[][] matrix) {
		    int rows = matrix.length;
		    if (rows == 0) {
		      return 0;
		    }
		    int cols = matrix[0].length;
		    if (cols == 0){
		      return 0;
		    }
		    boolean[][] visited = new boolean[rows][cols];
		    int res = 0;
		    for(int i = 0; i < rows; i++) {
		      for(int j = 0; j < cols; j++) {
		        if (matrix[i][j] == 0 && !visited[i][j]) {
		          res++;
		          traversal(matrix, i, j, visited, rows, cols);
		        }
		      }
		    }
		    return res;
		  }
		  
		  private void traversal(int[][] matrix, int row, int col, boolean[][] visited, int rows, int cols) {
		    Queue<Unit> que = new LinkedList<Unit>();		      
		    visited[row][col] = true;
		    que.offer(new Unit(row, col));
		    while (!que.isEmpty()) {
		      Unit cur = que.poll();
		      if (cur.x - 1 >= 0 && matrix[cur.x - 1][cur.y] == 0 && !visited[cur.x - 1][cur.y]) {
		    	  visited[cur.x - 1][cur.y] = true;
		    	  que.add(new Unit(cur.x - 1, cur.y));
		      }
		      if (cur.x + 1 < rows && matrix[cur.x + 1][cur.y] == 0 && !visited[cur.x + 1][cur.y]) {
		    	  visited[cur.x + 1][cur.y] = true;
		    	  que.add(new Unit(cur.x + 1, cur.y));
		      }
		      if (cur.y - 1 >= 0 && matrix[cur.x][cur.y - 1] == 0 && !visited[cur.x][cur.y - 1]) {
		    	  visited[cur.x][cur.y - 1] = true;
		    	  que.add(new Unit(cur.x, cur.y - 1));
		      }
		      if (cur.y + 1 < cols && matrix[cur.x][cur.y + 1] == 0 && !visited[cur.x][cur.y + 1]) {
		    	  visited[cur.x][cur.y + 1] = true;
		    	  que.add(new Unit(cur.x, cur.y + 1));
		      }
		    }
		  }
		  
		  class Unit {
		    int x;
		    int y; 
		    Unit(int x, int y) {
		      this.x = x;
		      this.y = y;
		    }
		  }
		//Time compleixty:O(n * m);
		  //Space complexity:O(n*m);
}
