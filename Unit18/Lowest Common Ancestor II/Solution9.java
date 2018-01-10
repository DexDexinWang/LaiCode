
public class Solution9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	  public class TreeNodeP {
		    public int key;
		    public TreeNodeP left;
		    public TreeNodeP right;
		    public TreeNodeP parent;
		    public TreeNodeP(int key, TreeNodeP parent) {
		      this.key = key;
		      this.parent = parent;
		    }
	  }
	  
	  //approach: try to put one and two in the same level, get the first common ancestors as a result.
	  public TreeNodeP lowestCommonAncestor(TreeNodeP one, TreeNodeP two) {
	    //corner case
	    if(one == null || two == null) {
	      return null;
	    }
	    //get the length from one to root;
	    int len1 = 0;
	    TreeNodeP tempOne = one;
	    while (tempOne.parent != null) {
	      tempOne = tempOne.parent;
	      len1++;
	    }
	    //get the lenth from two to root;
	    int len2 = 0;
	    TreeNodeP tempTwo = two;
	    while (tempTwo.parent != null) {
	      tempTwo = tempTwo.parent;
	      len2++;
	    }
	    //set them in the same level.
	    if (len1 < len2) {
	      for(int i = 0; i < len2 - len1; i++) {
	        two = two.parent;
	      }
	    } else if (len1 > len2) {
	      for(int i = 0; i < len1 - len2; i++) {
	        one = one.parent;
	      }   
	    }
	    //find the fisrt common parent;
	    while(one != two) {
	      one = one.parent;
	      two = two.parent;
	    }
	    return one;
	  }
	  //Time complexity: O(height);
	  //Space complexity: O(1);
}
