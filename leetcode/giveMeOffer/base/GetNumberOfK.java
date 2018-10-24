package base;

public class GetNumberOfK {
	/*
	 * 这个题呢，当然可以O(n)暴力去解
	 * 但是我们昨天不是整理了lowerbound upperbound吗
	 * 这里就派上用场了，不过还可以更加精妙的实现 见Solution2
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
