import generator.TreeNode;

public class BinarySearchTreeOperations {

	public static void main(String[] args) {
		TreeNode input = new TreeNode(5);
		input.left = new TreeNode(3);
		input.left.left = new TreeNode(2);
		input.left.right = new TreeNode(4);
		input.right = new TreeNode(9);
		input.right.left = new TreeNode(6);
		input.right.right = new TreeNode(10);		
		input.print();
		System.out.println();
		System.out.println(recursiveSearch(input, 3));
		System.out.println(iterativeSearch(input, 3));
		recursiveSearchNode(input, 3).print();
		System.out.println();
		iterativeSearchNode(input, 3).print();	
		System.out.println();
		iterativeDeleteNode(input, 3).print();	
		System.out.println();
	}

	//4 search methods
	private static boolean recursiveSearch(TreeNode root, int target) {
		if (root == null) {
			return false;
		} else if (root.key == target) {
			return true;
		} else if (root.key > target) {
			return recursiveSearch(root.left, target);
		} else {
			return recursiveSearch(root.right, target);
		}
	}
	
	private static TreeNode recursiveSearchNode(TreeNode root, int target) {
		if (root == null) {
			return null;
		} else if (root.key == target) {
			return root;
		} else if (root.key > target) {
			return recursiveSearchNode(root.left, target);
		} else {
			return recursiveSearchNode(root.right, target);
		}
	}
	
	private static boolean iterativeSearch(TreeNode root, int target) {
		while (root != null) {
			 if (root.key == target) {
				return true;
			} else if (root.key > target) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return false;
	}
	
	private static TreeNode iterativeSearchNode(TreeNode root, int target) {
		while (root != null) {
			 if (root.key == target) {
				return root;
			} else if (root.key > target) {
				root = root.left;
			} else {
				root = root.right;
			}
		}
		return null;
	}
	
	//Insert
	private static TreeNode recursiveInsertNode(TreeNode root, int target) {
		if (root == null) {
			TreeNode newNode = new TreeNode(target);
			return newNode;
		}
		if (root.key > target) {
			root.left = recursiveInsertNode(root.left, target);
		} else {
			root.right = recursiveInsertNode(root.right,target);
		}
		return root;
	}
	
	
	private static TreeNode iterativeInsertNode(TreeNode root, int target) {
		TreeNode newNode = new TreeNode(target);
		if (root == null) {
			return newNode;
		}
		TreeNode cur = root;
		while (cur.key != target) {
			if (cur.key > target) {
				if (cur.left == null) {
					cur.left = newNode;
					break;
				} else {
					cur = cur.left;
				}
			} else {
				if (cur.right == null) {
					cur.right = newNode;
					break;
				} else {
					cur = cur.right;
				}
			}
		}
		return root;
	}
	
	//Delete
	//what: the method will find a node where node`s value is equal to targets. Then, move a descendant to replace this node to keep binary search tree rules
	//how: 
	//	1. base case. 
	//	2. find the node;
	//  3. replace node with descendant
	//		3.1 the node has no children. 
	//		3.2 the node has only one children.
	//		3.3 the node has two children
	//			3.3.1	if the right-subtree has no left child, just use the root to replace the deleted node.
	//			3.3.2	if the right-subtree has left child, go to find the most left child to replace the deleted node.
	
	private static TreeNode recursiveDeleteNode(TreeNode root, int target) {
		if (root == null) {
			return null;
		}
		if (root.key > target) {
			root.left = recursiveDeleteNode(root.left, target);
			return root;
		} else if (root.key < target) {
			root.right = recursiveDeleteNode(root.right, target);
			return root;
		}
		
		if (root.left == null) {
			return root.right;
		} else if (root.right == null) {
			return root.left;
		}
		
		if (root.right.left == null) {
			root.right.left = root.left;
			return root.right;
		}
		TreeNode smallest = deleteSmallest(root.right);
		smallest.left = root.left;
		smallest.right = root.right;
		return smallest;
		
	}
	
	private static TreeNode deleteSmallest(TreeNode cur) {
		TreeNode prev = cur;
		cur = cur.left;
		while(cur.left != null) {
			prev = cur;
			cur = cur.left;
		}
		prev.left = prev.left.right;
		return cur;
	}
	
	
	private static TreeNode iterativeDeleteNode(TreeNode root, int target) {
		if (root == null) {
			return null;
		}
		TreeNode cur = root;
		TreeNode previous = new TreeNode(-1);
		previous.left = root;
		boolean isLeft = true;
		while(cur != null) {
		  if (cur.key < target) {
		    if (cur.right != null) {
		      previous = cur;
		      isLeft = false;
		      cur = cur.right;
		      continue;
		    } else {
		      break;
		    }
		  } else if (cur.key > target) {
		    if (cur.left != null) {
		      previous = cur;
		      cur = cur.left;
		      isLeft = true;
		      continue;
		    } else {
		      break;
		    }
		  }
		  
		  if (cur.left == null) {
		    if (isLeft){
		      previous.left = cur.right;
		    } else {
		      previous.right = cur.right;
		    }
		    break;
		  } else if (cur.right == null) {
		    if (isLeft){
		      previous.left = cur.left;
		    } else {
		      previous.right = cur.left;
		    }
		    break;
		  }
		  
		  if (cur.right.left == null) {
		    cur.right.left = cur.left;
		    if (isLeft) {
		      previous.left = cur.right;
		    } else {
		      previous.right = cur.right;
		    }
		    break;
		  }
		  
		  TreeNode smallest = deleteSmallest(cur.right);
		  smallest.left = cur.left;
		  smallest.right = cur.right;
		  if (previous.left != null && previous.left == root) {
		    return smallest;
		  }
		  if(isLeft) {
		    previous.left = smallest;
		  } else {
		    previous.right = smallest;
		  }
		  break;
		}
		if (previous.key == -1) {
			return previous.left;
		}
		return root;
	}

}
