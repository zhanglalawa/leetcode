package base;

import java.util.ArrayList;
import java.util.Stack;

/*
 * 之字型打印，需要两个栈来帮忙
 * 这个规律可以画个图来体会
 * 就可以发现每一层就是后进先出
 */
public class PrintSpecifically {
	public class Solution {
		public class TreeNode {
		    int val = 0;
		    TreeNode left = null;
		    TreeNode right = null;

		    public TreeNode(int val) {
		        this.val = val;

		    }

		}
	    public ArrayList<ArrayList<Integer> > Print(TreeNode pRoot) {
	        if(pRoot == null){
	            return new ArrayList<ArrayList<Integer>>();
	        }
	        
	        Stack<TreeNode> currentStack = new Stack<>();
	        Stack<TreeNode> nextStack = new Stack<>();
	        currentStack.push(pRoot);
	        
	        
	        
	        ArrayList<ArrayList<Integer>> ret = new ArrayList<>();
	        ArrayList<Integer> newLine = new ArrayList<>();
	        int line = 1;
	        
	        
	        while((!currentStack.isEmpty()) || (!nextStack.isEmpty())){
	            
	            TreeNode node = currentStack.pop();
	            newLine.add(node.val);
	            
	            if((line & 1) == 1){
	                if(node.left != null){
	                    nextStack.push(node.left);
	                }
	            
	                if(node.right != null){
	                    nextStack.push(node.right);
	                }
	            }else{
	                if(node.right != null){
	                    nextStack.push(node.right);
	                }
	            
	                if(node.left != null){
	                    nextStack.push(node.left);
	                }
	            }
	            
	            if(currentStack.isEmpty()){
	                ret.add(newLine);
	                currentStack = nextStack;
	                nextStack = new Stack<>();
	                newLine = new ArrayList<>();
	                line++;
	            }
	        }
	        return ret;
	    }

	}
}
