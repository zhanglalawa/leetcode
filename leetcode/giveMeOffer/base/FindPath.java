package base;

import java.util.ArrayList;

public class FindPath {
	
	public class TreeNode {
	    int val = 0;
	    TreeNode left = null;
	    TreeNode right = null;
	 
	    public TreeNode(int val) {
	        this.val = val;
	 
	    }
	 
	}
	
	public class Solution {
	    ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
	    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
	        if(root == null || target == 0){
	            return ans;
	        }
	        ArrayList<Integer> list = new ArrayList<>();
	        FindPath(root, target, list, 0);
	        return ans;
	    }
	     
	    public void FindPath(TreeNode root, int target, ArrayList<Integer> list, int currentSum){
	        currentSum += root.val;
	        list.add(root.val);
	         
	        boolean isLeaf = root.left == null && root.right == null;
	         
	        if(currentSum == target && isLeaf){
	            ans.add(new ArrayList<>(list));
	        }
	         
	        if(root.left != null){
	            FindPath(root.left, target, list, currentSum);
	        }
	         
	        if(root.right != null){
	            FindPath(root.right, target, list, currentSum);
	        }
	         
	        list.remove(list.size()-1);
	    }
	}

}
