package dp;

import java.util.Arrays;

public class HouseRobber198 {
	//记忆化搜索
	class Solutino1{
		// memo[i] 表示考虑抢劫 nums[i...n] 所能获得的最大收益
		private int[] memo;
		public int tryRob(int[] nums, int index) {
			if (index >= nums.length) {
				return 0;
			}
			
			if (memo[index] != -1) {
				return memo[index];
			}
			int res = 0;
			for(int i = index; i < nums.length;i++) {
				res = Math.max(res, nums[i] + tryRob(nums, i+2));
			}
			memo[index] = res;
			return res;
		}
		public int rob(int[] nums) {
			int n = nums.length;
			memo = new int[n];
            Arrays.fill(memo,-1);
			return tryRob(nums, 0);
		}
	}
	//动态规划
	class Solution2 {
	    int[] memo;
	    public int rob(int[] nums) {
	        int n = nums.length;
	        if(n == 0){
	            return 0;
	        }
	        
	        memo = new int[n];
	        memo[n-1] = nums[n-1];
	        for(int i = n - 2 ; i >= 0; i--){
	            for(int j = i; j < n; j++){
	                memo[j] = Math.max(memo[j],nums[j]+(j+2<n?memo[j+2]:0));
	            }
	        }
	        
	        return memo[0];
	    }
	}
}
