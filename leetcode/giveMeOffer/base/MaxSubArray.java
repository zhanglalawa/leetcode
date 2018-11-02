package base;
/*
 * sum从头开始加，加到array[i]位置前的时候，如果sum<0，那么意味着i之前对这个最大和没有什么贡献
 * 只会让结果更小
 * 就把sum舍弃掉 sum = array[i]
 * 如果sum是个正数，那意味着前面的数还是做了贡献的，就加上
 * 
 * 那么再用一个变量存储最大值，如果sum比max更大，就更新max的值即可。
 */
public class MaxSubArray {
	public class Solution {
	    public int FindGreatestSumOfSubArray(int[] array) {
	        int sum = Integer.MIN_VALUE;
	        int max = Integer.MIN_VALUE;
	        for(int i = 0; i < array.length; i++){
	            if(sum >= 0){
	                sum += array[i];
	            }else{
	                sum = array[i];
	            }
	            if(sum > max){
	                max = sum;
	            }
	        }
	         
	        return max;
	    }
	}
}
