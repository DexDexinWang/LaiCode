import java.util.Arrays;

public class Solution3 {

	public static void main(String[] args) {
		Solution3 s = new Solution3();
		System.out.println(Arrays.toString(s.keepDistance(1)));
	}
    
    //DFS
    //2n levels, each level make a decision to choose one valid number
    //2n` branches, the remaining numbers 
    public int[] keepDistance(int k) {
      int[] res = new int[2 * k];
      int[] cur = new int[2 * k];
      int[] counter = new int[k + 1];
      int[] indexes = new int[k + 1];
      keeyDistance(k, 0, cur, counter, indexes, res);
      return res;
    }
    
    public void keeyDistance(int k, int index, int[] cur, int[] counter, int[] indexes, int[] res) {
      if (index == 2*k) {
        for(int i = 0; i < 2*k; i++) {
        	res[i] = cur[i];
        }
        return;
      }
      for(int i = 1; i <= k; i++) {
        if (counter[i] == 2) {
          continue;
        }
        if (counter[i] == 0 || counter[i] == 1 && index - indexes[i] == i + 1 ) {
          cur[index] = i;
          counter[i]++;
          if (counter[i] == 1) {
            indexes[i] = index;
          }
          keeyDistance(k, index + 1, cur, counter, indexes, res);
          if (counter[i] == 1) {
            indexes[i] = 0;
          }
          counter[i]--;
        }
      }    
    }
}
