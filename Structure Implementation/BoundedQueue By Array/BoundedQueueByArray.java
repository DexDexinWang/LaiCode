
public class BoundedQueueByArray {
	Integer[] array;
	int size;
	int head;
	int tail;
	public BoundedQueueByArray () {
		array = new Integer[40];
		size = 0;
		head = 0;
		tail = 0;
	}

	public void offer(Integer ele) {
		if (size < array.length) {
			array[tail] = ele;
			tail = (tail + 1) % array.length;
			size++;
		}  else {
			throw new IllegalArgumentException("Queue is full!");
		}
	}

	public Integer peek() {
		if (size == 0) {
			return null;
		}
		return array[head];
	}
	
	public Integer poll() {
		if (size == 0) {
			return null;
		}
		Integer temp = array[head];
		head = (head + 1) % array.length;
		size--;
		return temp;
	}
	
	public void print() {
		System.out.print("[");
		int currentSize = 0;
		while (currentSize < size) {
			int position = (head + currentSize) % array.length;
			if (currentSize + 1 == size) {
				System.out.print(array[position]);
			} else {
				System.out.print(array[position] + ", ");
			}
			currentSize++;
		}
		System.out.println("]");
	}
	
}

