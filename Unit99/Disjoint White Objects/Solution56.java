
public class Solution56 {

	public static void main(String[] args) {
		int[][] input = {{0,0,0,1},{1,0,1,1},{1,1,0,0},{0,1,0,0,}};
		System.out.println(whiteObjects(input));
	}
	
	public static int whiteObjects(int[][] matrix) {
		int rows = matrix.length;
		if (rows == 0) {
			return 0;
		}
		int cols = matrix[0].length;
		if (cols == 0) {
			return 0;
		}
		
		boolean[][] visited = new boolean[rows][cols];
		for(int i = 0 ; i < rows ; i++) {
			for (int j = 0 ; j < cols ; j++) {
				if (matrix[i][j]== 0) {
					
				}
			}
		}
		return 0;
	}
	
	public static int whiteObjects(int[][] matrix, int i, int j, boolean[][] visited) {
		if (visited[i][j] == true) {
			return 0;
		}
		return 1;
	}
}
