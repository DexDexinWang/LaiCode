class MinHeap {
	int[] array;
	int size; 
	public final static int CAP = 15;	
	
	public MinHeap() {
		this(CAP);
	}
	
	public MinHeap(int cap) {
		if ( cap ==0){
			throw new IllegalArgumentException("the capacity is not valid");
		}
		array = new int[cap];
		size = 0;
	}
	
	public MinHeap(int[] array) {
		if (array == null || array.length ==0){
			throw new IllegalArgumentException("the input array is not valid");
		}
		this.array = array;
		size = array.length;
		heapify();
	}
	
	public void heapify() {
		for( int i = (size - 2) / 2; i >= 0; i--) {
			percolateDown(i);
		}
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public Integer peek() {
		if (size == 0) {
			return null;
		}
		return array[0];
	}
	
	public Integer poll() {
		if (size == 0) {
			return null;
		}
		Integer temp = array[0];
		array[0] = array[size-1];
		array[size - 1] = 0;
		size--;
		percolateDown(0);
		return temp;
	}
	
	public void offer(Integer ele) {
		if(size == array.length) {
			int[] newArray = new int[(int)(array.length * 1.5)];
			copy(array, newArray);
			array = newArray;
		}
		array[size] = ele;
		percolateUp(size);
		size++;
	}
	
	private void percolateDown(int index){
		while (index <= (size - 2) / 2) {
			int leftIndex = index * 2 + 1;
			int rightIndex = index * 2 + 2;
			int smallestIndex = leftIndex;
			if(rightIndex < size && array[rightIndex] < array[leftIndex]) {
				smallestIndex = rightIndex;
			}
			if (array[index] > array[smallestIndex]) {
				swap(array, index, smallestIndex);
			} else {
				break;
			}
			index = smallestIndex;
		}
	}
	
	private void percolateUp(int index){
		while(index > 0) {
			int parentIndex = (index - 1) / 2;
			if (array[parentIndex] > array[index]) {
				swap(array,parentIndex, index);
			} else {
				break;
			}
			index = parentIndex;
		}
	}

	private void swap(int[] array, int i, int j) {
		int temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	
	private void copy(int[] from, int[] to) {
		for(int i = 0; i < from.length; i++) {
			to[i] = from[i];
		}
	}
	
	public void print() {
		System.out.print("[");
		for(int i = 0; i < size ; i++) {
			if (i == size - 1) {
				System.out.print(array[i]);
			}
			else {
				System.out.print(array[i]+ ", ");
			}
			
		}
		System.out.println("]");
	}
}
