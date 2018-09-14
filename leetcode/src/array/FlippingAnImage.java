package array;

public class FlippingAnImage {
	class Solution {
		//ע�Ⲣ����Ҫ�����Ľ�����ֻ��i�Ǹ��Գ�λ��������ȵ�ʱ�򣬽������Ȼ�󽻻�
		public int[][] flipAndInvertImage(int[][] A) {
	        if (A == null || A.length == 0 || A[0].length == 0) {
	            return new int[0][0]; // assume; or return A 
	        }
	        for (int[] row : A) {
	            int j = 0;
	            int k = row.length - 1;
	            while (j <= k) {
	                if (row[j] == row[k]) {
	                    row[j] ^= 1;
	                    row[k] = row[j]; // careful: cannot do row[k] ^= 1 if j == k since xor once already
	                }
	                j++;
	                k--;
	            }
	        }
	        return A;
	    }
		
		public int[][] flipAndInvertImage1(int[][] A) {
			int M = A[0].length;
			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < M; j++) {
					A[i][j] = 1 ^ A[i][j];
				}
			}

			for (int i = 0; i < A.length; i++) {
				for (int j = 0; j < M / 2; j++) {
					int t = A[i][j];
					A[i][j] = A[i][M - 1 - j];
					A[i][M - 1 - j] = t;
				}
			}
			return A;
		}
		
		
	}
}
