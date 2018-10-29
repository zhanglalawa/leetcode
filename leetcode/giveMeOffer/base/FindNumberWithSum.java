package base;

import java.util.ArrayList;
/*
 * ֱ�۵ı����ⷨ��O��n^2�� ���ǲ�û��������������Ѿ�������ص�
 * ����ķ�������ͷ����ָ��ͷβ��ʼ ���ݺ�������i++����j--
 * ţ����Ҫ������ж������ݣ�����˻���С��һ�顣
 * ��ô�и����κ������ֺ�һ�������ԽС�˻�Խ����ô��ʵ��һ������==sum�ı߽�����������ǳ˻���С��
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
