package array;
/*
 * �����ĿҪ��ԭ��remove
 * �ص�Ҫ������⣬ʵ���������ƶ�������������remove
 * ��˫ָ��
 * ��Ҫ��עʲôʱ��len++
 * �Լ��߽�������i<=j��������i < j
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
