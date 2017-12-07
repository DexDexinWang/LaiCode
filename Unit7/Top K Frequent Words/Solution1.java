import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @author Dexin Wang
 * @Date Dec 4, 2017
 */
public class Solution1 {
	public static void main(String[] args) {
		String[] input = {"a","a","a","a","b","b","b","b","b","b","c"};
		System.out.println(Arrays.toString(input));
		System.out.println(Arrays.toString(topKFrequent(input,2)));
	}
	
	/*
	 * What: 
	 * 1. to count the frequence for each word
	 * 2. to get the top k words based on frequence
	 */

	public static String[] topKFrequent(String[] combo, int k) {
		//How:
		//1.corner case
		if (combo.length == 0) {
			return new String[0];
		}
		//2.traverse all elements in combo
		Map<String, Integer> counter = new HashMap<>();
		for(String word: combo) {
			counter.put(word, counter.getOrDefault(word, 0) + 1);
		}
		//3.Define the priorityQueue with comparator
		PriorityQueue<Map.Entry<String, Integer>> minHeap = new PriorityQueue<Map.Entry<String, Integer>>(k,
				new Comparator<Map.Entry<String,Integer>>() {
				@Override
				public int compare(Map.Entry<String, Integer> e1,Map.Entry<String, Integer> e2) {
					return e1.getValue().compareTo(e2.getValue());
				}
			});
		
		//4.Traverse the values form hashMap to minHeap;
		for(Map.Entry<String, Integer> entry: counter.entrySet()) {
			if (minHeap.size() < k) {
				minHeap.offer(entry);
			} else if (entry.getValue() > minHeap.peek().getValue()) {
				minHeap.poll();
				minHeap.offer(entry);
			}
		}
		//5. print the first k top 
		String[] res = new String[minHeap.size()];
		for (int i = minHeap.size()-1 ; i >= 0; i--) {
			res[i] = minHeap.poll().getKey();
		}
		//return result
		return res;
	} 
	//Time Complexity: O(nlogk) where k is the size of the PriorityQueue
	//Space Complexity: O(n+k)

}
