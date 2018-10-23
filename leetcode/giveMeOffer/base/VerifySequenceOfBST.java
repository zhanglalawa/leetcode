package base;

public class VerifySequenceOfBST {
	public class Solution {
	     
	    public boolean VerifySequenceOfBST(int [] sequence, int start, int r){
	        //��������sequence[start,r]������
	        //���ڵ���sequence[r]
	        int root = sequence[r];
	        int l = start;
	        //ȷ���������Ŀ�ʼ���±�,��������״̬�£�������Ϊ[start,l-1],������Ϊ[l,r-1],��������ļ��鼴��
	        for(; l < r; l++){
	            if(sequence[l]>root){
	                break;
	            }
	        }
	        //�������������û��С��root�ģ�����У����̷���false
	        for(int i = l; i < r; i++){
	            if(sequence[i] < root){
	                return false;
	            }
	        }
	        //��������������ݹ����������ǲ���BST
	        boolean left = true;
	        if(l > start){
	            left = VerifySequenceOfBST(sequence,start,l-1);
	        }
	        //��������������ݹ����������ǲ���BST
	        boolean right = true;
	        if(l < r){
	            right = VerifySequenceOfBST(sequence,l,r-1);
	        }
	         
	        return left&&right;
	    }
	    public boolean VerifySquenceOfBST(int [] sequence) {
	        if(sequence == null || sequence.length == 0){
	            return false;
	        }
	         
	        return VerifySequenceOfBST(sequence,0,sequence.length-1);
	    }
	}
}
