package base;

import java.util.Random;

/*
 * 最直白的做法是O(nlogn)排序之后，找中间位置的元素
 * 然后O(n)遍历检查次数是否超过一半
 * 这样复杂度是O(n+nlogn) = O(nlogn)
 * 不过我们可以有下面两种方法优化到O(n)
 */
public class MoreThanHalfNum {
	/*
	 * 基于快排partition去找length/2处的元素
	 * 找到后再遍历一遍检查是否是次数超过一半
	 * 时间复杂度是O(n)
	 */
	public class Solution {
	    int target;
	    public int MoreThanHalfNum_Solution(int [] array) {
	        target = array.length / 2;
	        
	        return MoreThanHalfNum_Solution(array, 0, array.length - 1);
	    }
	    public int MoreThanHalfNum_Solution(int[] array, int l, int r){
	        int k = partition(array,l,r);
	        if(k == target){
	            int res = 0;
	            for(int i = 0; i < array.length; i++){
	                if(array[i] == array[target]){
	                    res++;
	                }
	            }
	            if(res > array.length/2){
	                return array[k]; 
	            }
	            
	            return 0;
	        }else if ( k > target){
	            return MoreThanHalfNum_Solution(array,l,k-1);
	        }else{
	            return MoreThanHalfNum_Solution(array,k+1,r);
	        }
	    }
	    private int partition(int[] array, int l, int r){
	        Random random = new Random();
	        int m = random.nextInt(r - l + 1) + l;
	        swap(array, l, m);
	        
	        int pivot = array[l];
	        
	        int i = l + 1;
	        int j = r;
	        while(true){
	            
	            while(i <= r && array[i] < pivot) i++;
	            while(j > l && array[j] > pivot) j--;
	            if(i > j){
	                break;
	            }
	            swap(array,i,j);
	            i++;
	            j--;
	        }
	        swap(array,l,j);
	        return j;
	        
	    }
	    private void swap(int[] array, int i, int j){
	        int tmp = array[i];
	        array[i] = array[j];
	        array[j] = tmp;
	    }
	}
	
	/*
	 * 另一个比较巧妙的解法是利用数组的特点
	 * 这个数组如果有某个元素出现次数超过长度一半，换句话讲，它的出现次数比其它元素出现次数的总和还要多
	 * 我们考虑在遍历数组时候存储两个值
	 * 一个值是数组中的一个数组，另一个是次数
	 * 从第一个元素开始遍历，次数记为1，往后每遍历一个元素，如果和记录的值相等，次数加一
	 * 如果和记录的值不相等，那就让次数减一
	 * 每次遍历时候还需要检查次数，如果次数为零了，那么我们就把保存的数值更新为当前值
	 * 这样一来，要找的数字肯定是最后一次把次数设置为1对应的数字
	 * 我们最后只需要再遍历检查是否超过一半的次数就可以了
	 */
	public class Solution2 {
	    int target;
	    public int MoreThanHalfNum_Solution(int [] array) {
	        int result = array[0];
	        int times = 1;
	        for(int i = 1; i < array.length; i++){
	            if(times == 0){
	                result = array[i];
	                times++;
	            }else if(result == array[i]){
	                times ++;
	            }else{
	                times --;
	            }
	        }
	        
	        if(times >= 1){
	            int res = 0;
	            for(int i = 0; i < array.length; i++){
	                if(result == array[i]){
	                    res++;
	                }
	            }
	            if(res > array.length/2){
	                return result;
	            }
	        }
	        return 0;
	    }
	}
}
