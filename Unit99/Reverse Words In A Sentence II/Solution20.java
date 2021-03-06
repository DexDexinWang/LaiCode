
public class Solution20 {

	public static void main(String[] args) {
		System.out.println(reverseWords(" an apple "));
	}
	
	//what: reverse the words in a sentence and ignore the heading/trailing/duplicate space. 
	public static String reverseWords(String input) {
		if (input == null || input.length() == 0) {
			return input;
		}
		char[] array = input.toCharArray();
		int slow = 0;
		int fast = 0;
		//delete all unuseful space;
		while(fast < array.length) {
			if (array[fast] ==' ' && (fast == 0 || array[fast - 1] == ' ')) {
				fast++;
				continue;
			}
			array[slow++] = array[fast++];
		}
		int len = slow;
		if (slow > 0 && array[slow - 1] == ' ') {
			len--;
		}
		//reaverse all character;
		reverse(array,0, len - 1);
		slow = 0;
		fast = 1;
		//reverse all words. again.
		while (fast < len) {
			if (array[fast]!= ' ' && array[fast - 1] == ' ') {
				slow = fast;
			}
			if (array[fast]!= ' ' && (fast + 1 == len || array[fast + 1] == ' ')) {
				reverse(array, slow, fast);
			}
			fast++;
		}
		return new String(array, 0, fast);
	}

	private static void reverse(char[] array, int i, int j) {
		while (i < j) {
			swap(array, i, j);
			i++;
			j--;
		}
	}
	
	private static void swap(char[] array, int i, int j) {
		char temp = array[i];
		array[i] = array[j];
		array[j] = temp;
	}
	//Time complexity: O(n)
	//Space complexity: O(n)
}
