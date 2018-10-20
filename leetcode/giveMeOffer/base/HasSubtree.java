package base;

import base.EntryNodeOfLoop.Solution.ListNode;

public class HasSubtree {
	public class Solution {
		
		public class TreeNode {
		    int val = 0;
		    TreeNode left = null;
		    TreeNode right = null;

		    public TreeNode(int val) {
		        this.val = val;

		    }

		}
		
	    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
	        boolean res = false;
	        //当Tree1和Tree2都不为零的时候，才进行比较。否则直接返回false
	        if(root1!=null && root2 != null){
	            if(root1.val == root2.val){//如果找到了对应Tree2的根节点的点
	                res = reallyHasRoot2(root1,root2);
	            }
	            
	            if(!res){//如果找不到，那么就再去root的左儿子当作起点，去判断时候包含Tree2
	                res = HasSubtree(root1.left,root2);
	            }
	            
	            if(!res){//如果还找不到，那么就再去root的右儿子当作起点，去判断时候包含Tree2
	                res = HasSubtree(root1.right,root2);
	            }
	        }
	        
	        return res;
	    }
	    
	    private boolean reallyHasRoot2(TreeNode root1, TreeNode root2){
	        if(root2 == null){//如果Tree2已经遍历完了都能对应的上，返回true
	            return true;
	        }
	        
	        if(root1 == null){//如果Tree2还没有遍历完，Tree1却遍历完了。返回false
	            return false;
	        }
	        
	        if(!(root1.val == root2.val)){//如果其中有一个点没有对应上，返回false
	            return false;
	        }
	        
	      //如果根节点对应的上，那么就分别去子节点里面匹配
	        return reallyHasRoot2(root1.left,root2.left) && reallyHasRoot2(root1.right,root2.right);
	        
	    }
	}
}
