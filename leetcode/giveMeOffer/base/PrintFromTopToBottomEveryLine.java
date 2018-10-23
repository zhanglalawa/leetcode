package base;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
/*
 * �ֲ��ӡ����һ����ȥ��¼��һ��Ҫ��ӡ���ٸ��ڵ�
 * ����һ������¼��һ���ж��ٸ��ڵ�
 */
public class PrintFromTopToBottomEveryLine {
	public class Solution {
		public class TreeNode {
		    int val = 0;
		    TreeNode left = null;
		    TreeNode right = null;

		    public TreeNode(int val) {
		        this.val = val;

		    }

		}
	    ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
	        if(pRoot == null){
	            return new ArrayList<ArrayList<Integer>>();
	        }
	        
	        ArrayList<ArrayList<Integer>>  ret = new ArrayList<>();
	        Queue<TreeNode> queue = new LinkedList<>();
	        queue.offer(pRoot);
	        int toBePrinted = 1;
	        int nextLineToBePrinted = 0;
	        ArrayList<Integer> newLine = new ArrayList<>();
	        while(!queue.isEmpty()){
	            TreeNode node = queue.poll();
	            newLine.add(node.val);
	            toBePrinted --;
	            
	            if(node.left != null){
	                queue.offer(node.left);
	                nextLineToBePrinted ++;
	            }
	            
	            if(node.right != null){
	                queue.offer(node.right);
	                nextLineToBePrinted ++;
	            }
	            
	            if(toBePrinted == 0){
	                ret.add(newLine);
	                toBePrinted = nextLineToBePrinted;
	                nextLineToBePrinted = 0;
	                newLine = new ArrayList<>();
	            }
	        }
	        
	        return ret;
	    }
	    
	}
}
