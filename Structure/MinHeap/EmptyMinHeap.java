import java.util.NoSuchElementException;

public class EmptyMinHeap {
	private int[] array;
	private int size;
	
	public EmptyMinHeap(int[] array) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException("input array cannot be null or empty");
		}
		this.array = array;
		size =array.length;
		heapify();
	}
	
	private void heapify() {
		for (int i = size/2 - 1; i >= 0 ; i--) {
			percolateDown(i);
		}
	}
	
	public EmptyMinHeap(int cap) {
		if (cap <= 0) {
			throw new IllegalArgumentException("input array cannot be null or empty");
		}
		array = new int[cap];
		size = 0;
	}
	
	public int size() {
		return size;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public boolean isFull() {
		return size == array.length;
	}
	
	private void percolateUp(int index) {
		while(index >= 0) {
			int parent = (index - 1 ) / 2;
			if (array[parent] > array[index]) {
				swap(array, parent, index);
			} else {
				break;
			}
			index = parent;
		}
	}
	
	private void percolateDown(int index) {
		while (index > ((size - 2) / 2)) {
			int left = index * 2 + 1;
			int right = index * 2 + 2;
			int swapIdx = left;
			if (right < size && array[right] < array[left]) {
				swapIdx = right;
			}
			if (array[index] > array[swapIdx]) {
				swap(array, index, swapIdx);
			} else {
				break;
			}
			index = swapIdx;
		}
	}
	public int peek() {
		if (size == 0) {
			throw new NoSuchElementException("heap is empty");
		}
		return array[0];
	}
	
	public int poll() {
		if (size == 0) {
			throw new NoSuchElementException("heap is empty");
		}
		int min = array[0];
		array[0] = array[size - 1];
		array[size - 1] = 0;
		size--;
		percolateDown(0);
		return min;
	}
	
	public void offer(int ele) {
		if (size == array.length) {
			int[] newArray = new int[(int)(array.length * 1.5)];
			copy(array, newArray);
			array = newArray;
		}
		array[size] = ele;
		size++;
		percolateUp(size - 1);
	}
	
	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	private void copy(int[] array1, int[] array2) {
		for(int i = 0; i < array1.length; i++) {
			array2[i] = array1[i];
		}
	}
}
