
public class TTT {
	final static int DEFAULT_SIZE = 3;
	String[][] platForm;
	public int size;
	
	public TTT() {
		this(DEFAULT_SIZE);
	}
	public TTT(int size) {
		this.size = size;
		platForm = new String[size][size];
	}
	
	public boolean putToken(int row, int col, String token) {
		if(row >= size || row >= size) {
			return false;
		}
		platForm[row][col] = token;
		return true;
	}
	
	public void print() {
		for (int i = 0; i < size; i++) {
			for(int j = 0; j < size; j++) {
				if (platForm[i][j]== null) {
					System.out.print("-");
				} else {
					System.out.print(platForm[i][j]);
				}
				
				if (j != size - 1) {
					System.out.print("|");
				}
			}
			System.out.println();
		}
	}
	
	public boolean isFull() {
		int counter = 0;
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (platForm[i][j] == null) {
					counter++;
				}
			}
		}
		return counter == 0;
	}
	
}
