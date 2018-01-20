import java.util.Arrays;

public class Solution3 {

	public static void main(String[] args) {
		System.out.println(Arrays.toString(keepDistance(3)));
	}

	public static int[] keepDistance(int k) {

        // Write your solution here.

        int[] count = new int[k];

        int[] cur = new int[2*k];

        int[] result = new int[2*k];

        int[] pos = new int[2*k];

        keepDistance(k, 0, cur, result, count, pos);

        return result;

    }



    private static void keepDistance(int k, int level, int[] cur,int[] result, int[] count, int[] pos) {

        if (level == 2*k) {

            //System.out.println("a");

        	for (int i = 0; i < cur.length; i++) {
        		result[i] = cur[i];
        	}
            return;
        }



        for (int i = 0; i < k; i++) {

            if (count[i] >= 2) continue;

            if (count[i] < 1 || (level - pos[i] == i + 1 + 1)) {

                cur[level] = i + 1;

                int old_p = pos[i];

                pos[i] = level;

                count[i]++;

                keepDistance(k, level+1, cur, result, count, pos);

                pos[i] = old_p;

                count[i]--;

            }

        }

    }
}