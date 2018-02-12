
public class AI {
	TTT instance;
	public AI(TTT instance) {
		this.instance = instance;
	} 
	
	public boolean move() throws Exception{
		if(instance.isFull()) {
			throw new Exception("The platform is full!");
		}
		try{
			for(int i = 0; i < instance.size; i++) {
				for (int j = 0; j < instance.size; j++) {
					if (instance.platForm[i][j] == null) {
						instance.putToken(i, j, "O");
						return true;
					}
				}
			}
		} catch (Exception e) {
			
		}
		
		return true;
	}
}
