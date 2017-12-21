
public class Solution999 {

	public static void main(String[] args) {
		MyHashMap<Integer, String> map = new MyHashMap<Integer,String>();
		for (int i = 0 ; i < 15; i ++){
			map.put(i, "test");
		}
		map.remove(4);
		System.out.println("Debug");
	}
}