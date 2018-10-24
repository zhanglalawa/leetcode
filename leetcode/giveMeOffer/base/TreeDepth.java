package base;

public class TreeDepth {
	
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	/*
	 * 树的深度就是如果只有左子树，那么就是左子树的高度
	 * 如果只有右子树，那么就是右子树的高度
	 * 而左右都有，则是左右中更大的那一个
	 * 可以递归求左右子树深度，然后返回左子树高度 +1 和 右子树高度+1的更大值即可
	 */
	public class Solution {
	    public int TreeDepth(TreeNode root) {
	        if(root == null){
	            return 0;
	        }
	        int left, right;
	        left = TreeDepth(root.left);
	        right = TreeDepth(root.right);
	        
	        return (left > right)? (left +1):(right+1);
	    }
	}
}
