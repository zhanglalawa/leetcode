package array;

public class MonotonicArray896 {
	class Solution {
		public boolean isMonotonic(int[] A) {
			if (A.length == 1) {
				return true;
			}
			int i = 0;
			//�ѵ�һ������ȵ��±��ҳ���
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
