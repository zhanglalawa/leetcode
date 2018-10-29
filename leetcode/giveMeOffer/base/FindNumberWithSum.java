package base;

import java.util.ArrayList;
/*
 * 直观的暴力解法是O（n^2） 但是并没有利用这个数组已经排序的特点
 * 下面的方法是两头两个指针头尾开始 根据和来调整i++或者j--
 * 牛客上要求如果有多组数据，输出乘积最小的一组。
 * 那么列个二次函数发现和一定，差距越小乘积越大，那么其实第一次碰到==sum的边界的两个数就是乘积最小的
 */
public class FindNumberWithSum {
	public class Solution {
	    public ArrayList<Integer> FindNumbersWithSum(int [] array,int sum) {
	        if(array == null || array.length == 0){
	            return new ArrayList<>();
	        }
	        
	        int i = 0;
	        int j = array.length - 1;
	        ArrayList<Integer> ans = new ArrayList<>();
	        while(i < j){
	            if(array[i] + array[j] == sum){
	                ans.add(array[i]);
	                ans.add(array[j]);
	                return ans;
	            }else if(array[i] + array[j] > sum){
	                j--;
	            }else{
	                i++;
	            }
	        }
	         
	        return ans;
	    }
	}
}
