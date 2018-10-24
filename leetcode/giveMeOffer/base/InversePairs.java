package base;

public class InversePairs {
	/*
	 * 这个题暴力解法在O(n^2)
	 * 而之前总结归并排序时候，就提到过merge函数可以解决这个问题复杂度在O(nlogn)
	 * 就是加入了一个计数器
	 * 本质上还是手写mergeSort，对边界条件比较熟悉就可以轻松解决。
	 */
	public class Solution {
	    int count = 0;
	    public int InversePairs(int [] array) {
	        if(array == null || array.length == 0){
	            return 0;
	        }
	        mergeSort(array, 0, array.length-1);
	        
	        return count;
	    }
	    
	    private void mergeSort(int[] array, int l, int r){
	        if(l >= r){
	            return ;
	        }
	        int mid = l + (r - l)/2;
	        mergeSort(array, l, mid);
	        mergeSort(array, mid+1, r);
	        merge(array,l,mid,r);
	    }
	    private void merge(int[] array, int l, int mid, int r){
	        int[] assist = new int[r - l + 1];
	        
	        for(int i = 0; i < assist.length; i++){
	            assist[i] = array[i+l];
	        }
	        
	        int i = 0;
	        int newMid = mid - l;
	        int j = newMid + 1;
	        
	        int index = 0;
	        while(i <= newMid && j <= assist.length-1){
	            if(assist[i] <= assist[j]){
	                array[l+index] = assist[i];
	                i++;
	            }else{
	                array[l+index] = assist[j];
	                count += newMid - i + 1;
	                count = count %1000000007;
	                j++;
	            }
	            index++;
	        }
	        while(i <= newMid){
	            array[l+index] = assist[i++];
	            index++;
	        }
	        
	        while(j <= assist.length-1){
	            array[l+index] = assist[j++];
	            index++;
	        }
	    }
	}
}
