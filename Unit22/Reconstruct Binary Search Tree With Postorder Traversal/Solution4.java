import generator.TreeNode;

public class Solution4 {
	  	  //approach: find left subtree, and right subtree.
	  	  public TreeNode reconstruct(int[] post) {
		    if (post.length == 0) {
		      return null;
		    }
		    return reconstruct(post, 0, post.length -1);
		  }
		  
		  private TreeNode reconstruct(int[] array, int left, int right) {
		    //base case;
		    if (right < left) {
		      return null;
		    }
		    //find root; 
		    TreeNode root = new TreeNode(array[right]);
		    int i = right - 1;
		    //find mid to seperate left and right;
		    while (i >= left  && array[i] > array[right]) {
		      i--;
		    }
		    root.left = reconstruct(array, left, i);
		    root.right = reconstruct(array, i + 1, right -1);
		    return root;
		  }
		  //time complexity: O(n);
		  //Space complexity: O(n);
}
