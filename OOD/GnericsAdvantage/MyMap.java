import java.util.List;

public class MyMap<K,V> {
	K[] array1;
	List<K> array2;
	MyMap<K,V>[] array3;
	List<MyMap<K,V>> array4;
	
	//generic type could not be return
	public <T> T getInstance(T t) {
		//return new T;
		return t;
	}
}
