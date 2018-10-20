package array;
/*
 * 双指针从两头开始缩
 * 装水量是由低墙决定的
 */
public class ContainerWithMostWater11 {
	class Solution {
	    public int maxArea(int[] height) {
	        int start = 0;
	        int end = height.length - 1;
	        int size;
	        int res = Integer.MIN_VALUE;
	        while(start < end){
	            size = end - start;
	            res = Math.max(size * Math.min(height[start],height[end]),res);
	            
	            if(height[start] < height[end]){
	                start ++;
	            }else {
	                end --;
	            }
	        }
	        
	        return res;
	    }
	}
}
