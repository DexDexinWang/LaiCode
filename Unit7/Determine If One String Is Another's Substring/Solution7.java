
/**
 * @author Dexin Wang
 * @Date Dec 5, 2017
 */
public class Solution7 {
	public static void main(String[] args) {
		String input1 = "abcbaaccz";	
		String input2 = "baa";
		System.out.println(strstr1(input1,input2));
	}
	
	//brute force
	//what: 1. Find each character to compare the first character of small.
	//2. Compare the remaining characters to compare the remaining characters fo smalls
	public static int strstr(String large, String small) {
		//how: 1. corner case
		if (large.length() <= small.length()) {
			return -1;
		}
		if (small.length() == 0) {
			return 0;
		}
		//2.1 check each character of large
		for(int i = 0; i + small.length() < large.length(); i++) {
			//2.2 check each character of small
			if (equals(large,i,small)) {
				return i;
			}
		}
		return -1;
	}
	//Time Complexity: O(m*n)
	//Space Complexity: O(1)
	
	//what: find the correct substring with the same hash code with small
	public static int strstr1(String large, String small) {
		//how: 1. corner case
		if (large.length() < small.length()) {
			return -1;
		}
		if (small.length() == 0) {
			return 0;
		}
		//we need a large prime as module end;
		int largePrime = 101;
		
		int prime = 31;
		int seed = 1;
		// hash = (s0 * smallP^k +s0 * smallP^(k-1) +...+ sk * smallP^0)%largeP 
		int targetHash = small.charAt(0)%largePrime;
		
		for (int i = 1 ; i < small.length(); i++) {
			seed = moduleHash(seed, 0, prime, largePrime);
			targetHash = moduleHash(targetHash, small.charAt(i), prime, largePrime);
		}
		int hash = 0;
		for (int i = 0; i < small.length(); i++) {
			hash = moduleHash(hash, large.charAt(i), prime, largePrime);
		}
		
		if (hash == targetHash && equals(large, 0, small)) {
			return 0;
		}
		
		for(int i = 1; i <= large.length() - small.length(); i++) {
			hash = nonNegative(hash - seed * large.charAt(i - 1) % largePrime, largePrime);
			hash = moduleHash (hash, large.charAt(i + small.length() - 1), prime, largePrime);
			if (hash == targetHash && equals(large, i, small)) {
				return i;
			}
		}
		return -1;
	}
	
	public static int moduleHash(int hash, int addition, int prime, int largePrime) {
		return (hash * prime % largePrime + addition) % largePrime;
	}
	
	public static int nonNegative(int hash, int largePrime) {
		if(hash < 0) {
			hash += largePrime;
		}
		return hash;
	}
	
	private static boolean equals(String large, int index, String small) {
		for (int i = 0; i < small.length(); i++) {
			if(large.charAt(i+index) !=small.charAt(i)) {
				return false;
			}
		}
		return true;
	}

}
