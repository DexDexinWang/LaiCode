import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

import generator.TreeNode;
public class Solution {

	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(3);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.right = new TreeNode(6);
		root.right.left = new TreeNode(5);
		root.right.right = new TreeNode(0);
		root.print();
		//same level, same parent
//		TreeNode c1 = root.left.right;
//		TreeNode c2 = root.left.left;
//		System.out.println(isCousin(root,c1.key,c2.key));
		//same level, different parent;

		System.out.println(isCousin(root,9,6));


	}

	  public static boolean isCousin(TreeNode root, int a, int b) {
	      	boolean[] findall = new boolean[]{false};
			  	return isCusion(root, a, b, 0, findall) != -1 && findall[0] == true;
			  }
			  
			  private static int isCusion(TreeNode root, int a, int b, int level, boolean[] findall) {
			    if (root == null) {
			      	return -1;
			    }
			    if (root.key == a || root.key == b) {
	          if (level == 0) {
	            return -1;
	          } 
			      return level;
			    }
			    
			    int leftChild = isCusion(root.left, a, b, level + 1,findall);
			    int rightChild = isCusion(root.right, a, b, level + 1,findall);
			    if (leftChild!= -1 && rightChild!= -1) {
			      if (leftChild != rightChild) {
			        return -1;
			      } else if (leftChild - level != 1) {
			    	findall[0] = true;
			        return level;
			      } else {
			        return -1;
			      }
			    } 
			    return leftChild != -1 ? leftChild : rightChild;
			  }
	
	public static boolean findConsin (TreeNode root, TreeNode c1, TreeNode c2) {
		if (root == null) {
			return false;
		}
		Queue<TreeNode> que = new LinkedList<TreeNode>();
		Queue<TreeNode> queParent = new LinkedList<TreeNode>();
		que.offer(root); 
		queParent.offer(root);
		while (!que.isEmpty()) {
			int size = que.size();
			boolean t1 = false;
			boolean t2 = false;
			for (int i = 0; i < size ; i++) {
				TreeNode curParent = queParent.poll();
				TreeNode cur = que.poll();
				TreeNode temp1 = null;
				TreeNode temp2 = null;
				if (cur == c1) {
					t1 = true;
					temp1	= curParent; 
				}
				if (cur == c2) {
					t2 = true;
					temp2 = curParent;
				}
				if (t1 && t2) {
					if (temp1 == temp2) {
						return false;
					}
				}
				if (cur.left != null) {
					que.offer(cur.left);
					queParent.offer(cur);	
				}
				if (cur.right != null) {
					que.offer(cur.right);	
					queParent.offer(cur);
				}
			}
			
			if (t1 && t2) {
				return true;
			}
		}
		return false;
	}
	
			  
	
	
	
	
	
	public static boolean isCousins(TreeNode root,TreeNode nodeA,TreeNode nodeB){
			
			Queue<TreeNodeWapper> queue = new LinkedList<>();
			TreeNodeWapper  wapper = new TreeNodeWapper(null,root,0);
			TreeNodeWapper nodeAWapper = null;
			TreeNodeWapper nodeBWapper = null;
	            queue.offer(wapper);
	            int level = 0;
			while(queue.size()>0){
				level += 1;
				int size = queue.size();
				for(int i = 0;i< size;i++){
					TreeNodeWapper cur = queue.poll();
					if(cur.node.key == nodeA.key){
						nodeAWapper =  cur;
					}
					if(cur.node.key == nodeB.key){
						nodeBWapper =  cur;
					}
					if(nodeAWapper!=null&&nodeBWapper!=null){
						return nodeAWapper.level == nodeBWapper.level  &&nodeAWapper.parent.key!=nodeBWapper.parent.key;
					}
					if(cur.node.left!=null){
						queue.offer(new        TreeNodeWapper(cur.node,cur.node.left,level));
					}
					if(cur.node.right!=null){
		queue.offer(new           TreeNodeWapper(cur.node,cur.node.right,level));
					}
					
				}
	 		}
			return false;
	      }
		
		static class TreeNodeWapper{
			TreeNode parent;
			int level;
			TreeNode node;
			
			public TreeNodeWapper(TreeNode p, TreeNode c,int l){
				parent = p;
				node = c;
				level = l;
			}
		}
		
		public static boolean is(TreeNode root,TreeNode node1,TreeNode node2){
			if(root == null)
				return false;

			boolean aExist = false, bExist = false;
			Deque<TreeNode> queue = new LinkedList<>();
			queue.addLast(root);
			while(!queue.isEmpty()) {
				int size = queue.size();
				if(aExist && bExist)
					return true;
				else if(aExist == true || bExist == true)
					return false;
				for(int i = 0; i < size; i++) {
					TreeNode curr = queue.pollFirst();
					if(curr.left == node1 && curr.right == node2 || curr.right == node1 && curr.left == node2)
						return false;
					if(curr.left != null) {
						queue.addLast(curr.left);
						if(curr.left == node1)
							aExist = true;
						else if(curr.left == node2)
							bExist = true;
					} // end of if

					if(curr.right != null) {
						queue.addLast(curr.right);
						if(curr.right == node1)
							aExist = true;
						else if(curr.right == node2)
							bExist = true;					
					} // end of if
				} // end of inner while loop
			}// end of outer while 
			return false;
		}


}
