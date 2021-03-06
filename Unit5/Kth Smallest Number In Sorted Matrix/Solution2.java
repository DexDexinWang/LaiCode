import java.util.PriorityQueue;

public class Solution2 {

	public static void main(String[] args) {
		int[][] input = {{1,2,3,4}, {2,3,4,5}, {3,4,5,6},{4,5,6,7}};
		System.out.println(kthSmallest(input, 3));
	}

	public static int kthSmallest(int[][] matrix, int k) {
		if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
			return -1;
		}
		int rows = matrix.length;
		int cols = matrix[0].length;
		PriorityQueue<Cell> minHeap = new PriorityQueue<Cell>(k);
		minHeap.add(new Cell(0, 0, matrix[0][0]));
		int[][] visited = new int[rows][cols];
		for (int i = 0 ; i < k - 1 ; i++) {
			Cell cur = minHeap.poll();
			if (cur.row + 1 < rows && visited[cur.row + 1][cur.col] != 1) {
				minHeap.add(new Cell(cur.row + 1, cur.col, matrix[cur.row + 1][cur.col]));
				visited[cur.row + 1][cur.col] = 1;
			}
			if (cur.col + 1 < cols && visited[cur.row][cur.col + 1] != 1) {
				minHeap.add(new Cell(cur.row, cur.col + 1, matrix[cur.row][cur.col + 1]));
				visited[cur.row][cur.col + 1] = 1;
			}
		}
		return minHeap.poll().val;
	}
 
	static class Cell implements Comparable<Cell> {
		int row;
		int col;
		int val;
		public Cell(int row, int col, int val){
			this.row = row;
			this.col = col;
			this.val = val;
		}
		@Override 
		public int compareTo(Cell another) {
			if (this.val == another.val) {
				return 0;
			}
			return this.val < another.val ? -1: 1;
		}

	}
	//Time Complexity: O(klog(k))
	//Space Complexity: O(sk)
}
