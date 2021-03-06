import java.util.ArrayList;

public class GenericsAdvantage3 {

	public static void main(String[] args) {
		test1();
	}
	
	public static void test1() {
		ArrayList<Integer> a1 = new ArrayList<Integer>();
		ArrayList<String> a2 = new ArrayList<String>();
		Class c1 = a1.getClass();
		Class c2 = a2.getClass();
		System.out.println(c1);	//ArrayList
		System.out.println(c2);	//ArrayList
		System.out.println(c1 == c2);
		try{
			a1.getClass().getMethod("add", Object.class)
			.invoke(a1, "a"); //成功将字符串对对象插入整数数组
			//进了院子干坏事,保安就不知道了
			System.out.println(a1.size());
			System.out.println(a1);	// [a]
			a1.add(2);				
			System.out.println(a1);	// [a,2]
		} catch(Throwable e) {
			e.printStackTrace();
		}
	}
}
