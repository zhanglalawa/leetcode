package array;

public class MonotonicArray896 {
	class Solution {
		public boolean isMonotonic(int[] A) {
			if (A.length == 1) {
				return true;
			}
			int i = 0;
			//把第一个不相等的下标找出来
			while (i + 1 < A.length && A[i] == A[i + 1]) {
				i++;
			}
			if (i + 1 < A.length) {
				if (A[i] < A[i + 1]) {
					while (i < A.length - 1) {
						if (A[i] > A[i + 1]) {
							return false;
						}
						i++;
					}
				} else if (A[i] > A[i + 1]) {
					while (i < A.length - 1) {
						if (A[i] < A[i + 1]) {
							return false;
						}
						i++;
					}
				}
			}
			return true;
		}
	}
}
