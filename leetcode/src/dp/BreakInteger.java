package dp;

/*
 * 这个题对于一个数n
 * 可以把它分成1*n-1\2*n-2\....n-1*1
 * 那对每一个成分又可以去递归的求解 去分
 * 所以子结构很明显就是n-i
 * 所以可以直接写出下面第一个版本的Solution
 * 需要注意的是 我们递归求解的过程对应的是把n-i给分了
 * 但是不递归就是直接乘法i*(n-i),这种情况是递归求解时候没有包括的
 * 所以在max比较的时候，是三个数再比！不要忽略i*(n-i)，比如4 拆成2*2是最大的，而如果按2*（4-2）去递归4-2那就会酿成大祸！
 * 所以一定要考虑周全
 * 
 * 那自然可以想到 求解了太多次的重叠子问题，所以记忆化搜索Solution2
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
