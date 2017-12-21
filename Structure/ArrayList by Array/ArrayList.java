
public class ArrayList {
	int[] array;
	int size;
	public ArrayList() {
		array = new int[100];
		size = 0;
	}
	
	public void add(int ele) {
		if (size == array.length) {
			int[] newArray = new int[(int)(array.length * 1.5)];
			copy(array, newArray);
			array = newArray;
		}
		array[size] = ele; 
		size++;
	}
	
	private void copy(int[] oldArray , int[] newArray) {
		for(int i = 0; i < oldArray.length; i++) {
			newArray[i] = oldArray[i];
		}
	}
	
	public void remove(int index){
		if (index == 0) {
			//...
		}
		
	}
}
