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
	 * �����Ŀ�Ĺؼ���֪��������������������о��Ǵ�С���������
	 * ��ô������ÿ��������������������ֽžͿ�����
	 * ��Ҫһ��������k
	 * Ȼ�������������˼��ȥѰ��Ŀ��ڵ�
	 * ÿ�η�������������Ľ��ʱ�����k--
	 * k=1ʱ��˵������֮ǰ������k-1���ڵ㣬��ô���ڷ��ʵ�����ڵ���ǵ�k���ڵ�
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
