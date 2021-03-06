import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import generator.TreeNode;

public class Solution6 {
	public static void main(String[] args) {
		int[] input1  = new int[]{1};
		int[] input2 = new int[]{1};
		Solution6 s = new Solution6();
		s.reconstruct(input1, input2);
	}
	
	  public TreeNode reconstruct(int[] in, int[] level) {
		    if (in.length == 0) {
		      return null;
		    }
		    Map<Integer, Integer> map = new HashMap<Integer,Integer>();
		    for(int i = 0; i < in.length; i++) {
		      map.put(in[i], i);
		    }
		    List<Integer> list = new ArrayList<Integer>(); 
		    for(int num: level) {
		      list.add(num);
		    }
		    return reconstruct(map,list);
		  }
		  
		  public TreeNode reconstruct(Map<Integer, Integer> map,List<Integer> list) {
		    if (list.size() == 0) {
		      return null;
		    }
		    TreeNode root = new TreeNode(list.remove(0));
		    List<Integer> left = new ArrayList<Integer>();
		    List<Integer> right = new ArrayList<Integer>();
		    for(int num : list) {
		      if (map.get(num) < map.get(root.key)) {
		        left.add(num);
		      } else {
		        right.add(num);
		      }
		    }
		    root.left = reconstruct(map, left);
		    root.right = reconstruct(map, right);
		    return root;
		  }
		  //Time complexity: O(n ^ 2)
		  //Space complexity: O(n ^ 2)
}
