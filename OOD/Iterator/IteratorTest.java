import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class IteratorTest {

	public static void main(String[] args) {
		List<Character> list = new LinkedList<>();
		for (int i = 0 ; i < 10 ; i++) {
			list.add((char) ('a'+ i));
		}
		System.out.println(list);

		for(Iterator<Character> it = list.iterator(); it.hasNext();) {
			Character str= it.next();
			System.out.println(str);
			it.remove();//remove the apple that has been get from the last next();
		}
		System.out.println(list);
	}

}
