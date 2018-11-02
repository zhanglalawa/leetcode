package base;
/*
 * sum��ͷ��ʼ�ӣ��ӵ�array[i]λ��ǰ��ʱ�����sum<0����ô��ζ��i֮ǰ���������û��ʲô����
 * ֻ���ý����С
 * �Ͱ�sum������ sum = array[i]
 * ���sum�Ǹ�����������ζ��ǰ������������˹��׵ģ��ͼ���
 * 
 * ��ô����һ�������洢���ֵ�����sum��max���󣬾͸���max��ֵ���ɡ�
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
