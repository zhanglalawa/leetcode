package base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
 * �������
 * �ö���
 */
public class PrintFromTopToBottom {
	public class Solution {

		public class TreeNode {
		    int val = 0;
		    TreeNode left = null;
		    TreeNode right = null;

		    public TreeNode(int val) {
		        this.val = val;

		    }

		}
		
	    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
	        if(root == null){
	            return new ArrayList<Integer>();
	        }
	        
	        ArrayList<Integer> ret = new ArrayList<>();
	        
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.offer(root);
	        
	        while(!queue.isEmpty()) {
	        	TreeNode node = queue.poll();
	        	ret.add(node.val);
	        	if (node.left != null) {
					queue.offer(node.left);
				}
	        	if (node.right != null) {
					queue.offer(node.right);
				}
	        }

	        return ret;
	    }
	}
}
