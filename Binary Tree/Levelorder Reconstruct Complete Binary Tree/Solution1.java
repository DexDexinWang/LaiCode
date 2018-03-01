import java.util.LinkedList;
import java.util.Queue;
import generator.TreeNode;

public class Solution1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	  public TreeNode construct(int[] level) {
		    if (level.length == 0) {
		      return null;
		    }
		    Queue<TreeNode> que = new LinkedList<>();
		    TreeNode root = new TreeNode(level[0]);
		    que.offer(root);
		    int index =1;
		    while(index < level.length) {
		      TreeNode cur = que.poll();
		      cur.left = new TreeNode(level[index++]);
		      que.offer(cur.left);
		      if (index < level.length) {
		        cur.right = new TreeNode(level[index++]);
		        que.offer(cur.right);
		      }
		    }
		    return root;
		  }
}
