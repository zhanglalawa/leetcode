package base;


/*
 * �����ı��ʻ��Ƕ������ı���
 * ����������������Ϊ����
 * ��������������΢����һ�������������������Ļ�
 * ��ô����ǶԳƵ����������������о���һ����
 * �������˼��
 * ȥ�ݹ�ͬʱ������������ͷ������������
 */
public class SemmetricalTree {
	public class Solution {
		public class TreeNode {
		    int val = 0;
		    TreeNode left = null;
		    TreeNode right = null;

		    public TreeNode(int val) {
		        this.val = val;

		    }

		}
	    boolean isSymmetrical(TreeNode pRoot){
	        return isSymmetrical(pRoot,pRoot);
	    }
	    
	    boolean isSymmetrical(TreeNode root1, TreeNode root2){
	        //������ݹ鵽�ף�ͬʱΪ�գ�����true
	        if(root1 == null && root2 == null){
	            return true;
	        }
	        
	        //�����һ��Ϊ��һ����Ϊ�գ�����false
	        if(root1 == null || root2 == null){
	            return false;
	        }
	        
	        //������ڿ���Ľڵ��ֵ����ȣ�����false
	        if(root1.val != root2.val){
	            return false;
	        }
	        
	        //����roo1����������root2�������� root1����������root2��������
	        return isSymmetrical(root1.left,root2.right) &&isSymmetrical(root1.right, root2.left);
	    }
	}
}
