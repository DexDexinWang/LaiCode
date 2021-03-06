import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class Solultion5 {

	public static void main(String[] args) {
		int[] input1 = new int[]{1,4,6};
		int[] input2 = new int[]{2,5};
		int[] input3 = new int[]{1,3};
		Solultion5 s = new Solultion5();
		System.out.println(s.closest(input1, input2, input3, 8));
	}
	  public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
		    PriorityQueue<Unit> minHeap = new PriorityQueue<Unit>(2*k);
		    minHeap.offer(new Unit(0, 0, 0, getTotal(a, b, c, 0, 0, 0)));
		    Set<Long> set = new HashSet<>();
		    set.add(getTotal(a, b, c, 0, 0, 0));
		    for(int i = 1; i < k ; i++) {
		      Unit unit = minHeap.poll();
		      if (unit.x + 1 < a.length && !set.contains(getTotal(a, b, c, unit.x + 1, unit.y, unit.z))) {
		        minHeap.offer(new Unit (unit.x + 1, unit.y, unit.z, getTotal(a, b, c, unit.x + 1, unit.y, unit.z)));
		        set.add(getTotal(a, b, c, unit.x + 1, unit.y, unit.z));
		      }
		      if (unit.y + 1 < b.length && !set.contains(getTotal(a, b, c, unit.x, unit.y + 1, unit.z))) {
		        minHeap.offer(new Unit (unit.x, unit.y + 1, unit.z, getTotal(a, b, c, unit.x, unit.y + 1, unit.z)));
		        set.add(getTotal(a, b, c, unit.x, unit.y + 1, unit.z));
		      }
		      if (unit.z + 1 < c.length && !set.contains(getTotal(a, b, c, unit.x, unit.y, unit.z + 1))) {
		        minHeap.offer(new Unit (unit.x, unit.y, unit.z + 1, getTotal(a, b, c, unit.x, unit.y, unit.z + 1)));
		        set.add(getTotal(a, b, c, unit.x, unit.y, unit.z + 1));
		      }
		    }
		    List<Integer> res = new ArrayList<>();
		    res.add(0, a[minHeap.peek().x]);
		    res.add(1, b[minHeap.peek().y]);
		    res.add(2, c[minHeap.peek().z]);
		    return res;
		  }
		  
		  private long getTotal(int[] a, int[] b, int[] c, int x, int y, int z) {
		    return a[x]*a[x] + b[y]*b[y]+c[z]*c[z];
		  }

		  class Unit implements Comparable<Unit> {
		    int x; 
		    int y;
		    int z;
		    long value;
		    public Unit(int x, int y, int z, long value) {
		      this.x = x;
		      this.y = y;
		      this.z = z;
		      this.value = value;
		    }
		    @Override
		    public int compareTo(Unit other) {
		      if (this.value == other.value) {
		        return 0;
		      }
		      return this.value < other.value ? -1 : 1;
		    }
		  }
}
