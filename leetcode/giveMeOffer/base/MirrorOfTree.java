package base;
/*
 * 这道题的本质就是二叉树的遍历，在遍历过程中去交换一下左右子树就好了
 */
public class MirrorOfTree {
	
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	
	public class Solution {
	    public void Mirror(TreeNode root) {
	        if(root == null){
	            return;
	        }
	        
	        if(root.left == null && root.right == null){
	            return;
	        }
	        
	        TreeNode tmp = root.left;
	        root.left = root.right;
	        root.right = tmp;
	        
	        Mirror(root.left);
	        Mirror(root.right);
	    }
	}
}
