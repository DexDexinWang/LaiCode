
public class NestedClassTest {

	public static void main(String[] args) {
		//inner
		NestedClassDefinination st = new NestedClassDefinination();
		NestedClassDefinination.FirstLevel fl = st.new FirstLevel();
        fl.methodInFirstLevel(23);
        
        //nested class
        NestedClassDefinination.innerClass inner = new NestedClassDefinination.innerClass(2);
        inner.print();
	}

}
