package base;

import java.util.ArrayList;
import java.util.Stack;

/*
 * ֮���ʹ�ӡ����Ҫ����ջ����æ
 * ������ɿ��Ի���ͼ�����
 * �Ϳ��Է���ÿһ����Ǻ���ȳ�
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
