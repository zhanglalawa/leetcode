package array;

import java.util.Random;

public class KthLargestElementInAnArray215 {
	class Solution {
	    private void swap(int[] nums, int i, int j){
	        int tmp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = tmp;
	    }
	    
	    public int partition(int[] nums, int l, int r){
	        Random random = new Random();
	        int m = random.nextInt(r-l+1) + l;
	        swap(nums,l,m);        
	        int pivot = nums[l];
	        int j = l;
	        for(int i = l + 1; i <= r; i++ ){
	            if(nums[i] > pivot){
	                swap(nums,i,j+1);
	                j++;
	            }
	        }
	        
	        swap(nums,l,j);
	        return j;
	    }
	    public int findKthLargest(int[] nums, int k) {
	        return findKthLargest(nums,0,nums.length-1,k);
	    }
	    
	    public int findKthLargest(int[] nums, int l, int r, int k){
	        int ans = partition(nums,l,r);
	        if(ans+1 == k){
	            return nums[ans];
	        }else if(ans + 1 > k){
	            return findKthLargest(nums,l,ans-1,k);
	        }else{
	            return findKthLargest(nums,ans+1,r,k);
	        }
	    }
	}
}
