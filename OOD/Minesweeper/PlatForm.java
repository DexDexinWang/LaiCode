
public class PlatForm {
	private final static int DEFAULT_SIZE = 10;
	private final static int DEFAUTL_BOMBS = 10;
	private int[][] counter;
	private boolean[][] platForm;
	private boolean[][] visited;
	private int size;
	private int bombs;
	private int leftPositions;
	
	public PlatForm (int size, int bombs) {
		this.size = size;
		this.bombs = bombs;
		this.leftPositions = size * size;
		counter = new int[size][size];
		platForm = new boolean[size][size];
		visited = new boolean[size][size];
		setBooms();
	}
	
	//randomly set the bombs.
	private void setBooms() {
		for (int i = 0; i < bombs;) {
			int row = (int)Math.random() * (size);
			int col = (int)Math.random() * (size);
			if (!platForm[row][col]) {
				platForm[row][col] = true;
				i++;
			}
		}
		countBombs();
	}
	
	//count the bombs for each position.
	private void countBombs() {
		for(int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				int count = 0;
				for (int x = i - 1 ; x <= i + 1; x++) {
					for (int y = j - 1; y <= j + 1; y++) {
						if (x >= 0 && x < size && y > 0 && y < size && platForm[x][y]) {
							count++;
						}
					}
				}
				counter[i][j] = count;
			}
		}
	}
	
	public void click(int row, int col) {
		if (platForm[row][col]) {
			showLose(); 
			return;
		}
		visited[row][col] = true;
		leftPositions--;
		if (counter[row][col] == 0) {
			isNull(row,col);
		}
		if (leftPositions == bombs) {
			showWin();
			return;
		}
		
	}
	
	private void isNull(int row, int col) {
		for (int i = row - 1; i < size; i++) {
			for (int j = col - 1; j < size; j++) {
				if (row >= 0 && row < size && col >= 0 && col < size){
					if (!visited[i][j] && !platForm[i][j]) {
						click(i,j);
					}
				}
			}
		}
	}
	
	private void showLose() {
		System.out.println("Sorry, You lose the game.");
	}
	
	private void showWin() {
		System.out.println("Congradulation! You win the game");
	}
	
	public void print() {
		System.out.println("============PlatForm==========");
		for (int i = 0; i < size ; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print(counter[i][j] + " ");
			}
			System.out.println();
		}
	}
}
