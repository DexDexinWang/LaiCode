
public class Solution1 {
	  //approach: compare A[k/2] and B[k/2] recursively to filter unuseful elements.
	  //Base case: 
	  //k = 1		return min(A[left + k], B[left + k]);
	  //A[left] <= a.length return B[left + k];
	  //B[left] <= b.length return A[left + k];
	  //Recursion Rule: F(A,aLeft,B,bLeft,k) = F(A,aLeft + k/2, B, bLeft, k) or F(A,aLeft, B, bLeft  + k/2, k)

	public int kth(int[] a, int[] b, int k) {
		return kthHelper(a, 0, b, 0, k);
	}
	
	private int kthHelper(int[] a, int aLeft, int[] b, int bLeft, int k) {
		if (aLeft >= a.length) {
			return b[bLeft + k - 1];
		}
		if (bLeft >= b.length) {
			return a[aLeft + k - 1];
		}
		if (k == 1) {
			return Math.min(a[aLeft], b[bLeft]);
		}
		int aHalfK = aLeft + k / 2 - 1 < a.length ? a[aLeft + k/2 - 1] : Integer.MAX_VALUE;
		int bHalfK = bLeft + k / 2 - 1 < b.length ? b[bLeft + k/2 - 1] : Integer.MAX_VALUE;
		
		if (aHalfK < bHalfK) {
			return kthHelper(a, aLeft + k / 2, b, bLeft, k - k / 2);
		} else {
			return kthHelper(a, aLeft, b, bLeft + k / 2, k - k / 2);
		}
	}
	//Time complexity: O(logk);
	//Space complexity: O(1);
	  
}
