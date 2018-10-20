package base;


/*
 * 这道题的本质还是二叉树的遍历
 * 这里就是以先序遍历为例子
 * 如果把先序遍历稍微改造一下先右子树后左子树的话
 * 那么如果是对称的树两个遍历的序列就是一样的
 * 基于这个思想
 * 去递归同时进行先序遍历和反先序遍历即可
 */
public class SemmetricalTree {
	public class Solution {
		public class TreeNode {
		    int val = 0;
		    TreeNode left = null;
		    TreeNode right = null;

		    public TreeNode(int val) {
		        this.val = val;

		    }

		}
	    boolean isSymmetrical(TreeNode pRoot){
	        return isSymmetrical(pRoot,pRoot);
	    }
	    
	    boolean isSymmetrical(TreeNode root1, TreeNode root2){
	        //如果都递归到底，同时为空，返回true
	        if(root1 == null && root2 == null){
	            return true;
	        }
	        
	        //如果有一个为空一个不为空，返回false
	        if(root1 == null || root2 == null){
	            return false;
	        }
	        
	        //如果正在考察的节点的值不相等，返回false
	        if(root1.val != root2.val){
	            return false;
	        }
	        
	        //考察roo1的左子树和root2的右子树 root1的右子树和root2的左子树
	        return isSymmetrical(root1.left,root2.right) &&isSymmetrical(root1.right, root2.left);
	    }
	}
}
