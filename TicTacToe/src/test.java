
public class test {

	public static void main(String[] args) throws Exception {
		TTT test = new TTT();
		test.print();
		test.putToken(0, 1, "X");
		System.out.println();
		test.print();
		
		AI ai = new AI(test);
		
		for (int i = 0; i <9; i ++) {
				ai.move();
			}
		
		System.out.println();
		test.print();	
	}

}
