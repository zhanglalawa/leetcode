package array;
/*
 * 这个题目要求原地remove
 * 重点要理解题意，实际上是在移动而不是真正的remove
 * 用双指针
 * 需要关注什么时候len++
 * 以及边界条件是i<=j，而不是i < j
 */
public class RemoveElement27 {
	class Solution {
	    public int removeElement(int[] nums, int val) {
	        int len=0;
	        int i = 0;
	        int j = nums.length-1;
	        while(i <= j){
	            if(nums[i] == val){
	                if(nums[j] != val){
	                    int tmp = nums[i];
	                    nums[i] = nums[j];
	                    nums[j] = tmp;
	                    i++;
	                    j--;
	                    len++;
	                }else{
	                    j--;
	                }
	            }else{
	                len++;
	                i++;
	            }
	        }
	        return len;
	    }
	}
}
