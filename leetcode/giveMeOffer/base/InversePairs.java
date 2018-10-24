package base;

public class InversePairs {
	/*
	 * ����Ⱪ���ⷨ��O(n^2)
	 * ��֮ǰ�ܽ�鲢����ʱ�򣬾��ᵽ��merge�������Խ��������⸴�Ӷ���O(nlogn)
	 * ���Ǽ�����һ��������
	 * �����ϻ�����дmergeSort���Ա߽������Ƚ���Ϥ�Ϳ������ɽ����
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
