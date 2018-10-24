package base;

public class TreeDepth {
	
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;

	    public TreeNode(int val) {
	        this.val = val;

	    }

	}
	/*
	 * ������Ⱦ������ֻ������������ô�����������ĸ߶�
	 * ���ֻ������������ô�����������ĸ߶�
	 * �����Ҷ��У����������и������һ��
	 * ���Եݹ�������������ȣ�Ȼ�󷵻��������߶� +1 �� �������߶�+1�ĸ���ֵ����
	 */
	public class Solution {
	    public int TreeDepth(TreeNode root) {
	        if(root == null){
	            return 0;
	        }
	        int left, right;
	        left = TreeDepth(root.left);
	        right = TreeDepth(root.right);
	        
	        return (left > right)? (left +1):(right+1);
	    }
	}
}
