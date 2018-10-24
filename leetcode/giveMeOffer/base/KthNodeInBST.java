package base;

public class KthNodeInBST {
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	/*
	 * 这个题目的关键是知道二叉树的中序遍历序列就是从小到大的排序
	 * 那么我们在每次中序遍历过程中做做手脚就可以了
	 * 需要一个计数器k
	 * 然后按照中序遍历的思想去寻找目标节点
	 * 每次访问中序遍历到的借点时候就让k--
	 * k=1时候说明正好之前经历了k-1个节点，那么正在访问的这个节点就是第k个节点
	 */
	public class Solution {
		
	    int k;
	    TreeNode KthNode(TreeNode pRoot, int k){
	        if(pRoot == null || k <= 0){
	            return null;
	        }
	        this.k = k;
	        return KthNodeCore(pRoot);
	    }
	    TreeNode KthNodeCore(TreeNode pRoot){
	        TreeNode target = null;
	        if(pRoot.left != null){
	            target = KthNodeCore(pRoot.left);
	        }
	        
	        if(target == null){
	            if(k == 1){
	                target = pRoot;
	            }
	            k --;
	        }
	        
	        if(target == null && pRoot.right != null){
	            target = KthNodeCore(pRoot.right);
	        }
	        
	        return target;
	    }
	    
	    


	}
}
