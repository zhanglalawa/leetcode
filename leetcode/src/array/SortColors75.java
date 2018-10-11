package array;

import java.util.Arrays;

public class SortColors75 {
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
	        Arrays.sort(nums);
	    }
	}
}
