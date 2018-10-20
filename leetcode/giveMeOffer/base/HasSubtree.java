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
	        //��Tree1��Tree2����Ϊ���ʱ�򣬲Ž��бȽϡ�����ֱ�ӷ���false
	        if(root1!=null && root2 != null){
	            if(root1.val == root2.val){//����ҵ��˶�ӦTree2�ĸ��ڵ�ĵ�
	                res = reallyHasRoot2(root1,root2);
	            }
	            
	            if(!res){//����Ҳ�������ô����ȥroot������ӵ�����㣬ȥ�ж�ʱ�����Tree2
	                res = HasSubtree(root1.left,root2);
	            }
	            
	            if(!res){//������Ҳ�������ô����ȥroot���Ҷ��ӵ�����㣬ȥ�ж�ʱ�����Tree2
	                res = HasSubtree(root1.right,root2);
	            }
	        }
	        
	        return res;
	    }
	    
	    private boolean reallyHasRoot2(TreeNode root1, TreeNode root2){
	        if(root2 == null){//���Tree2�Ѿ��������˶��ܶ�Ӧ���ϣ�����true
	            return true;
	        }
	        
	        if(root1 == null){//���Tree2��û�б����꣬Tree1ȴ�������ˡ�����false
	            return false;
	        }
	        
	        if(!(root1.val == root2.val)){//���������һ����û�ж�Ӧ�ϣ�����false
	            return false;
	        }
	        
	      //������ڵ��Ӧ���ϣ���ô�ͷֱ�ȥ�ӽڵ�����ƥ��
	        return reallyHasRoot2(root1.left,root2.left) && reallyHasRoot2(root1.right,root2.right);
	        
	    }
	}
}
