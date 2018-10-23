package base;

import java.util.Random;

/*
 * ��ֱ�׵�������O(nlogn)����֮�����м�λ�õ�Ԫ��
 * Ȼ��O(n)�����������Ƿ񳬹�һ��
 * �������Ӷ���O(n+nlogn) = O(nlogn)
 * �������ǿ������������ַ����Ż���O(n)
 */
public class MoreThanHalfNum {
	/*
	 * ���ڿ���partitionȥ��length/2����Ԫ��
	 * �ҵ����ٱ���һ�����Ƿ��Ǵ�������һ��
	 * ʱ�临�Ӷ���O(n)
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
	 * ��һ���Ƚ�����Ľⷨ������������ص�
	 * ������������ĳ��Ԫ�س��ִ�����������һ�룬���仰�������ĳ��ִ���������Ԫ�س��ִ������ܺͻ�Ҫ��
	 * ���ǿ����ڱ�������ʱ��洢����ֵ
	 * һ��ֵ�������е�һ�����飬��һ���Ǵ���
	 * �ӵ�һ��Ԫ�ؿ�ʼ������������Ϊ1������ÿ����һ��Ԫ�أ�����ͼ�¼��ֵ��ȣ�������һ
	 * ����ͼ�¼��ֵ����ȣ��Ǿ��ô�����һ
	 * ÿ�α���ʱ����Ҫ���������������Ϊ���ˣ���ô���ǾͰѱ������ֵ����Ϊ��ǰֵ
	 * ����һ����Ҫ�ҵ����ֿ϶������һ�ΰѴ�������Ϊ1��Ӧ������
	 * �������ֻ��Ҫ�ٱ�������Ƿ񳬹�һ��Ĵ����Ϳ�����
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
