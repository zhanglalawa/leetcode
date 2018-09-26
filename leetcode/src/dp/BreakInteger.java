package dp;

/*
 * ��������һ����n
 * ���԰����ֳ�1*n-1\2*n-2\....n-1*1
 * �Ƕ�ÿһ���ɷ��ֿ���ȥ�ݹ����� ȥ��
 * �����ӽṹ�����Ծ���n-i
 * ���Կ���ֱ��д�������һ���汾��Solution
 * ��Ҫע����� ���ǵݹ����Ĺ��̶�Ӧ���ǰ�n-i������
 * ���ǲ��ݹ����ֱ�ӳ˷�i*(n-i),��������ǵݹ����ʱ��û�а�����
 * ������max�Ƚϵ�ʱ�����������ٱȣ���Ҫ����i*(n-i)������4 ���2*2�����ģ��������2*��4-2��ȥ�ݹ�4-2�Ǿͻ���ɴ����
 * ����һ��Ҫ������ȫ
 * 
 * ����Ȼ�����뵽 �����̫��ε��ص������⣬���Լ��仯����Solution2
 */
public class BreakInteger {
	class Solution1 {
		public int integerBreak(int n) {
			if (n == 1) {
				return 1;
			}

			int res = 0;
			for (int i = 1; i < n; i++) {
				res = Math.max(Math.max(res, i * (n - i)), i * integerBreak(n - i));
			}

			return res;
		}
	}

	class Solution2 {
		int[] m;

		public int integerBreak1(int n) {
			if (n == 1) {
				return 1;
			}

			if (m[n] != 0) {
				return m[n];
			}
			int res = 0;
			for (int i = 1; i < n; i++) {
				res = Math.max(Math.max(res, i * (n - i)), i * integerBreak1(n - i));
			}

			m[n] = res;
			return res;
		}

		public int integerBreak(int num) {
			m = new int[num + 1];
			return integerBreak1(num);
		}
	}

	class Solutin3 {
		public int integerBreak(int n) {
			int[] m = new int[n + 1];
			m[1] = 1;

			for (int i = 2; i <= n; i++) {
				int res = 0;
				for (int j = i - 1; j >= 1; j--) {
					res = Math.max(res, Math.max(j * (i - j), j * m[i - j]));
				}
				m[i] = res;
			}
			return m[n];
		}
	}
}
