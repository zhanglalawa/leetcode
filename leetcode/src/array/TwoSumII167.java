package array;
/*
 * ±©¡¶»•Ω‚O£®n^2)
 * 
 */
public class TwoSumII167 {
	class Solution {
	    public int[] twoSum(int[] numbers, int target) {
	        int l = 0, r = numbers.length-1;
	        while(l<r){
	            if(numbers[l] + numbers[r] == target){
	                return new int[]{l+1,r+1};
	            }else if(numbers[l] + numbers[r] > target){
	                r--;
	            }else{
	                l++;
	            }
	        }
	        return null;
	    }
	}
}
