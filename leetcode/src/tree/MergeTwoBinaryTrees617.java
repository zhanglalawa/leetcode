package tree;
/*
 * 递归解法 
 * 类似于先序遍历
 * 只不过是在同时先序遍历两棵树，遍历时候还返回当前的树根节点
 * 访问节点的操作变成 了加两棵树的节点的值的操作
 */
public class MergeTwoBinaryTrees617 {
	class Solution {
	    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
	        if(t1 == null){
	            return t2;
	        }
	        
	        if(t2 == null){
	            return t1;
	        }
	        
	        t1.val += t2.val;
	        t1.left = mergeTrees(t1.left,t2.left);
	        t1.right = mergeTrees(t1.right,t2.right);
	        return t1;
	    }
	}
}
