package base;

import java.util.Arrays;

public class Fibonacci {
	public class Solution {
		public int Fibonacci(int n) {
			if (n == 0) {
				return 0;
			}
			if (n == 1) {
				return 1;
			}

			return Fibonacci(n - 1) + Fibonacci(n - 2);
		}
	}

	public class Solution1 {
		int[] assit;

		public int Fibonacci(int n) {
			assit = new int[n + 1];
			Arrays.fill(assit, -1);

			return fib(n);
		}

		public int fib(int n) {
			if (n == 0) {
				return 0;
			}
			if (n == 1) {
				return 1;
			}
			if (assit[n] != -1) {
				return assit[n];
			}

			return fib(n - 1) + fib(n - 2);
		}
	}

	public class Solution2 {
		
		int[] fib;

		public int Fibonacci(int n) {
			if(n <= 1){
                return n;
            }
			fib = new int[n + 1];
			fib[0] = 0;
			fib[1] = 1;
			for (int i = 2; i < n + 1; i++) {
				fib[i] = fib[i - 1] + fib[i - 2];
			}
			return fib[n];
		}
	}
}
