import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class IteratorListTest {

	public static void main(String[] args) {
		List<Integer> list = new LinkedList<>();
		for (int i = 0 ; i < 10 ; i++) {
			list.add(i);
		}
		
		for (ListIterator<Integer> it = list.listIterator(); it.hasNext();) {
			System.out.println("one step forward: " + it.next());
			if (it.hasNext()) {
				System.out.println("Another step forward: " + it.next());
				System.out.println("One step backward:" + it.previous());
			}
		}
	}

}
