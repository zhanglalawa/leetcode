package array;

import java.util.Arrays;
import java.util.Comparator;

public class SortArrayByParity905 {
	class Solution {
	    public int[] sortArrayByParity(int[] A) {
	        Integer[] _A = new Integer[A.length];
	        for (int i = 0; i < _A.length; i++) {
				_A[i] = A[i];
			}
	    	Arrays.sort(_A, new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					if (o1%2==0) {
						return 1;
					}else if(o1%2==1){
						return -1;
					}else {
						return 0;
					}
				}
			
	        });
	    	for(int i = 0; i <A.length;i++) {
	    		A[i] = _A[i];
	    	}
	    	return A;
	    }
	}
}
