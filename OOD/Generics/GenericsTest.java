import java.util.ArrayList;
import java.util.List;

public class GenericsTest {

	public static void main(String[] args) {

		
	}
	
	public static void test1() {
		List<Apple> list = new ArrayList<>();
		Apple apple = list.get(0);
		//1. cannot add other type
		//list.add(new Orange());
		//2. cannot add super class
		//list.add(new Fruit());
		
		
		Fruit fruit = new Fruit();
		//3. need cast
		//apple = fruit;
		Orange b = new Orange();
		fruit = b;
		apple = (Apple) fruit; // ok at compile time, but may have ClassCastException at running time.
		//such as adding an orange as fruit.
		
	}
	
	public static void test2() {
		//generics cannot cast to superclass;
		List<Apple> apples = new ArrayList<>();
		//List<Fruit> fruits = apples; 	
	}
	
	public static void test3() {
		//generics cannot cast to subclass;
		List<Fruit> fruits = new ArrayList<>();
		//List<Apple> apples = fruits;
	}
	
	public static void test4() {
		Apple[] apples = new Apple[3];
		Fruit[] fruits = apples;
		fruits[0] = new Apple();
		//Should ArrayStoreException, Generics check the type during the compile-time. 
		//In contrast, Array does not. 
		fruits[1] = new Fruit();
		fruits[2] = new Orange();
	}
	
	//<? extends Fruit> it is for reading sub-classes.
	public static void test5() {
		List<Apple> apples = new ArrayList<>();
		List<? extends Fruit> fruits = apples;
		Fruit fruit = fruits.get(0); // read time is fine.
		Apple apple = (Apple) fruits.get(0);
		//compile error, actually you cannot add anything to fruits. 
//		fruits.add(new Apple());	
//		fruits.add(new Fruit());
	}
	
	//List<? super Apple> it is for writing classes.
	public static void test6() {
		List<Fruit> fruits = new ArrayList<>();
		List<? super Apple> apples = fruits;
		apples.add(new Apple());
		apples.add(new GreenApple());
		//apples.add(new Fruit());//compile time error
		apples.add((Apple)(new Fruit())); //compile time ok, run time error.
		//apples.add(new Oregon()); //compile time error.
	}
	
}
