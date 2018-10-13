package array;

import java.util.Arrays;

public class SortColors75 {
	/*
	 * 计数排个序
	 * 这里用到辅助空间了
	 * 适用于元素个数非常有限的
	 */
	class Solution {
	    public void sortColors(int[] nums) {
	        int[] number = new int[3];
	        for(int n : nums){
	            if(n == 0){
	                number[0]++;
	            }else if(n == 1){
	                number[1]++;
	            }else{
	                number[2]++;
	            }
	        }
	        int index = 0;
	        for(int j = 0; j<3; j++){
	            for(int i = 0;i < number[j];i ++){
	                nums[index++] = j;
	            }
	        }
	    }
	}
	
	/*
	 * 三路快排的思想在原地就可以完成
	 */
	class Solution2 {
		public void swap(int[] nums, int i, int j) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
		}
	    public void sortColors(int[] nums) {
	        int lt = -1;//[0....lt]是0
	        int gt = nums.length;//[gt，，，nums.length-1]是2
	        int i = 0;//[lt+1,....i)是1
	        
	        //当i》=gt时候循环结束
	        while(i < gt) {
	        	if (nums[i]==0) {
					swap(nums, i, lt+1);
					lt++;
					i++;
				}else if (nums[i] == 1) {
					i++;
				}else {
					swap(nums, i, gt-1);
					gt--;
				}
	        }
	    }
	}
}
