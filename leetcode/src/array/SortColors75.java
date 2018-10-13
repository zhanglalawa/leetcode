package array;

import java.util.Arrays;

public class SortColors75 {
	/*
	 * �����Ÿ���
	 * �����õ������ռ���
	 * ������Ԫ�ظ����ǳ����޵�
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
	 * ��·���ŵ�˼����ԭ�ؾͿ������
	 */
	class Solution2 {
		public void swap(int[] nums, int i, int j) {
			int tmp = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp;
		}
	    public void sortColors(int[] nums) {
	        int lt = -1;//[0....lt]��0
	        int gt = nums.length;//[gt������nums.length-1]��2
	        int i = 0;//[lt+1,....i)��1
	        
	        //��i��=gtʱ��ѭ������
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
