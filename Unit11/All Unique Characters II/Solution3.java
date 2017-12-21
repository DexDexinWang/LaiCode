
public class Solution3 {

	public static void main(String[] args) {
		System.out.println(allUnique1("abcd"));
	}
	
	//what: use each int number to record a character that is checked or not.
	public static boolean allUnique(String word) {
		int[] array = new int[256];
		for (Character ch : word.toCharArray()){
			if(array[ch] == 1) {
				return false;
			} else {
				array[ch] = 1;
			}
		}
		return true;
	}
	//Time Complexity: O(n) = O(n) 
	//Space Complexity: O(256) = O(1);
	
	//what: use each bit to record a character that is checked or not.
	public static boolean allUnique1(String word) {
		int[] array = new int[8];
		for (Character ch : word.toCharArray()){
			if((array[ch/32] >>> (ch%32) & 1) !=0) {
				return false;
			} else {
				array[ch/32] = array[ch/32] | (1 << (ch % 32));
			}
		}
		return true;
	}
	//Time Complexity: O(n) = O(n) 
	//Space Complexity: O(4) = O(1);
	
}
