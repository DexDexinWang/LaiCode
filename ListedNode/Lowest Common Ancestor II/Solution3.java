
public class Solution3 {

	public static void main(String[] args) {
		
	}
	//what:Given two nodes in a binary tree (with parent pointer available), find their lowest common ancestor.
	public static TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
		//how: 1. corner case
	    if (one == null || two == null) {
	        return null;
	      }
	      //2. fine the Length from one to root;
	      int oneLen = 0;
	      TreeNodeP temp = one;
	      while(temp.parent != null) {
	        temp = temp.parent;
	        oneLen ++;
	      }
	      //3. find the lenth from two to root;
	      temp = two;
	      int twoLen = 0;
	      while(temp.parent != null) {
	        temp = temp.parent;
	        twoLen++;
	      }
	      //4. make one and two in the same level.
	      if (oneLen > twoLen) {
	        for(int i = 0; i < oneLen - twoLen ; i++) {
	          one = one.parent;
	        }
	      } else if (twoLen > oneLen) {
	        temp = two;
	        for(int i = 0; i < twoLen - oneLen ; i++) {
	          two = two.parent;
	        }
	      }
	      //5. move both up to find the common parent;
	      while(one != two) {
	        one = one.parent;
	        two = two.parent;
	      }
	      //6. return parent;
	      return one;
	}
	//time complexity: O(log(height));
	//Space complexity: O(1);

	static class TreeNodeP {
		public int key;
		public TreeNodeP left;
		public TreeNodeP right;
		public TreeNodeP parent;
		public TreeNodeP(int key, TreeNodeP parent) {
			this.key = key;
			this.parent = parent;
		}
	}
}
