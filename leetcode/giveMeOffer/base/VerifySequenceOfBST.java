package base;

public class VerifySequenceOfBST {
	public class Solution {
	     
	    public boolean VerifySequenceOfBST(int [] sequence, int start, int r){
	        //整棵树是sequence[start,r]闭区间
	        //根节点是sequence[r]
	        int root = sequence[r];
	        int l = start;
	        //确定右子树的开始的下标,最终理想状态下，左子树为[start,l-1],右子树为[l,r-1],进行下面的检验即可
	        for(; l < r; l++){
	            if(sequence[l]>root){
	                break;
	            }
	        }
	        //检查右子树中有没有小于root的，如果有，立刻返回false
	        for(int i = l; i < r; i++){
	            if(sequence[i] < root){
	                return false;
	            }
	        }
	        //如果有左子树，递归检查左子树是不是BST
	        boolean left = true;
	        if(l > start){
	            left = VerifySequenceOfBST(sequence,start,l-1);
	        }
	        //如果有右子树，递归检查右子树是不是BST
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
