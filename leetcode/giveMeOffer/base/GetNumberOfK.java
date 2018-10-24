package base;

public class GetNumberOfK {
	/*
	 * ������أ���Ȼ����O(n)����ȥ��
	 * �����������첻��������lowerbound upperbound��
	 * ����������ó��ˣ����������Ը��Ӿ����ʵ�� ��Solution2
	 */
	public class Solution {
	    public int GetNumberOfK(int [] array , int k) {
	       return upperBound(array,k) - lowerBound(array,k);
	    }
	     
	    private int lowerBound(int[] array, int k){
	        int i = 0;
	        int j = array.length;
	         
	        while(i < j){
	            int mid = i + (j - i)/2;
	            if(array[mid] >= k){
	                j = mid;
	            }else{
	                i = mid + 1;
	            }
	        }
	         
	        return i;
	    }
	     
	    private int upperBound(int[] array, int k){
	        int i = 0;
	        int j = array.length;
	         
	        while(i < j){
	            int mid = i + (j - i)/2;
	            if(array[mid] > k){
	                j = mid;
	            }else{
	                i = mid + 1;
	            }
	        }
	         
	        return i;
	    }
	}

}
