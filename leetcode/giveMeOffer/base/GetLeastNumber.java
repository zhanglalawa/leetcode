package base;

import java.util.ArrayList;
import java.util.Random;

public class GetLeastNumber {
	/*
	 * 这个题目还是可以用partition来做
	 * partition的唯一缺点就是会改动原数组
	 * 如果有些题目要求不能改动原数组那这个方法就有问题
	 * 不过还是可以有一个O(n)空间来复制一下也没有问题
	 * 
	 * 第二个方法就是用一个最大堆
	 * 加入k个值之后，每次都和最大项相比，如果大于这个最大项那就算了
	 * 如果小于这个最大项，那就调整maxHeap
	 * 这样的复杂度是O(nlogk)，需要衣蛾O(k)的辅助空间，明天补充这个解法
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
