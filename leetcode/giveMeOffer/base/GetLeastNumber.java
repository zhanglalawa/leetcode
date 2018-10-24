package base;

import java.util.ArrayList;
import java.util.Random;

public class GetLeastNumber {
	/*
	 * �����Ŀ���ǿ�����partition����
	 * partition��Ψһȱ����ǻ�Ķ�ԭ����
	 * �����Щ��ĿҪ���ܸĶ�ԭ���������������������
	 * �������ǿ�����һ��O(n)�ռ�������һ��Ҳû������
	 * 
	 * �ڶ�������������һ������
	 * ����k��ֵ֮��ÿ�ζ����������ȣ�����������������Ǿ�����
	 * ���С����������Ǿ͵���maxHeap
	 * �����ĸ��Ӷ���O(nlogk)����Ҫ�¶�O(k)�ĸ����ռ䣬���첹������ⷨ
	 */
	public class Solution {
	    ArrayList<Integer> ans = new ArrayList<>();
	    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
	        if(input == null || k <= 0 || k > input.length){
	            return ans;
	        }
	         
	        return GetLeastNumbers_Solution(input, 0, input.length - 1,k);
	    }
	    public  ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int l, int r, int k){
	        int index = partition(input,l,r);
	         
	        if(index + 1 == k){
	            for(int i = 0; i <= index; i++){
	                ans.add(input[i]);
	            }
	            return ans;
	        }else if(index +1 > k){
	            return GetLeastNumbers_Solution(input, l, index -1, k);
	        }else{
	            return GetLeastNumbers_Solution(input, index + 1, r , k);
	        }
	    }
	    private void swap(int[] input, int i, int j){
	        int tmp = input[i];
	        input[i] = input[j];
	        input[j] = tmp;
	    }
	    private int partition(int[] input, int l, int r){
	        Random random = new Random();
	        int m = random.nextInt(r-l+1)+l;
	        swap(input,l,m);
	        int pivot = input[l];
	         
	        int i = l +1, j = r;
	        while(true){
	            while(i <= r && input[i] < pivot) i++;
	            while(j >= l+1 && input[j] > pivot) j--;
	            if(i>=j){
	                break;
	            }
	            swap(input, i, j);
	            i++;
	            j--;
	        }
	         
	        swap(input,l,j);
	        return j;
	    }
	}
}
