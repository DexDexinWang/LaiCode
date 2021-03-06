
public class GenericsAdvantage {
	//<E> is generic type
	public static <E> void printArray(E[] inputArray) {
		for (E element : inputArray) {
			System.out.printf("%s ", element);
		}
		System.out.println();
	}

	public static <E, V> void printArray(E[] inputArray, V input2) {
		for (E element : inputArray) {
			System.out.printf(input2 + "%s ", element);
		}
		System.out.println();
	}
	
	public static void main (String args[]) {
		Integer[] intArray = {1,2,3,4,5};
		Double[] doubleArray= {1.1, 2.2, 3.3, 4.4};
		Character[] charArray = {'W','O','R','L','D'};
		
		System.out.println("Array interger Array contains:");
		printArray(intArray);
		
		System.out.println("\n Array double Array contains:");
		printArray(doubleArray);
		
		System.out.println("\n Array character Array contains:");
		printArray(charArray);
		
		System.out.println("\n Array character Array contains:");
		printArray(intArray, "wocao");
	}
}
