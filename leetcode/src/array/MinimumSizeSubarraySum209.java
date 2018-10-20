package array;

public class MinimumSizeSubarraySum209 {
	class Solution {
	    public int minSubArrayLen(int s, int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }
	        int res = Integer.MAX_VALUE;
	        for(int i = 0; i < nums.length; i++) {
	        	int tmp = 0;
	        	int newSize = res;
	        	int j;
	        	for(j = i; j < nums.length; j++) {
	        		tmp += nums[j];
	        		if (tmp>=s) {
						break;
					}
	        	}
	        	
                if(tmp>=s){
	        	    newSize = j - i + 1;
                }
	        	res = Math.min(res, newSize);
	        }
	        if(res == Integer.MAX_VALUE){
                return 0;
            }
	        return res;
	    }
	}
	
	/*
	 * ��������Ż�һ��
	 * ����ǰn���
	 * ��Sn-Sk ���num[k....n-1]�ĺ�
	 * O��n^2)
	 */
	class Solution2 {
	    public int minSubArrayLen(int s, int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }
	        int[] sum = new int[nums.length+1];//sum[i]��nums[0...i-1]�ĺͣ���ǰi���
	        sum[0] = 0;
	        for(int i = 1; i < sum.length; i++) {
	        	sum[i] = nums[i-1] + sum[i-1];
	        }
	        int ans = nums.length+1;
	        for(int n = 1; n < sum.length; n++) {
	        	int result = Integer.MAX_VALUE;
	        	for (int k = 0; k < n; k++) {
	        		result = sum[n] - sum[k];
	        		if (result >= s && n-k<ans) {
						ans = n-k;
					}
				}
	        }
	        if (ans == nums.length + 1) {
				return 0;
			}
	        return ans;
	    }
	}
	
	/*
	 * ��������
	 */
	class Solution3 {
		public int minSubArrayLen(int s, int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }
	        int l=0,r=0;
	        int sum = 0;
	        int ans = nums.length + 1;
	        while(l<nums.length) {
                //sum��[l...r)�ĺ�
	        	if (r< nums.length && sum < s) {
					sum += nums[r++];
				}else {//r��ͷ�� ���� sum>=s ������߽�
                    sum -= nums[l++];
                }
                
                if(sum >= s){
                    ans = Math.min(ans,r-l);
                }
                

	        }
	        
	        if (ans == nums.length + 1) {
				return 0;
			}
	        return ans;
	    }
		
	}
}
