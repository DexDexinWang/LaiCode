import java.util.PriorityQueue;

public class Solution27 {

	public static void main(String[] args) {
		int[] input1 = {1,2,3,4,5};
		int[] input2 = {2,3,4,5,6};
		System.out.println(kthSum(input1,input2,4));
	}
	//what: find the Kth smallest sum(A[i], B[j]) from left to right with a min PriorityQueue.  
	public static int kthSum(int[] A, int[] B, int k) {
		//how: 1. define PriorityQueue.
	    PriorityQueue<Unit> minHeap = new PriorityQueue<Unit>(k);
	    minHeap.offer(new Unit(0, 0, A[0] + B[0]));
	    //2. define a visited array to skip visited numbers.
	    int lenA = A.length;
		int lenB = B.length;
	    boolean[][] visited = new boolean[lenA][lenB];
	    visited[0][0] = true;
	    //3. make a loop to traverse each smallest sum
	    for(int i = 1 ; i < k ; i++) {
	    	Unit cur = minHeap.poll();
		    if(cur.i + 1 < lenA && !visited[cur.i + 1][cur.j]) {
		    	minHeap.offer(new Unit(cur.i+1, cur.j, A[cur.i+1] + B[cur.j]));
		    	visited[cur.i + 1][cur.j] =true;
		    }
		    if(cur.j + 1 < lenB && !visited[cur.i][cur.j + 1]) {
		        minHeap.offer(new Unit(cur.i, cur.j + 1, A[cur.i] + B[cur.j + 1]));
		        visited[cur.i][cur.j + 1] = true;
		    }
		}
	    //4. return the head which would be the kth smallest sum.
		return minHeap.peek().val;
	}
	
	static class Unit implements Comparable<Unit>{
		int i;
	    int j;
	    int val;
	    public Unit(int i, int j, int val) {
	    	this.i = i;
		    this.j = j;
		    this.val = val;
		}
		@Override 
		public int compareTo(Unit other) {
			if (this.val == other.val) {
		        return 0;
		    }
				return this.val < other.val ? -1 : 1;
		}
	}
	
	//Time complexity: O((n+m) * logK);
	//Space complexity: O(k);
}
