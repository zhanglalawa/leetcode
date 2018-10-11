package base;

import java.util.Arrays;

// Parameters:
//    numbers:     an array of integers
//    length:      the length of array numbers
//    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
//                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
//    这里要特别注意~返回任意重复的一个，赋值duplication[0]
// Return value:       true if the input is valid, and there are some duplications in the array number
//                     otherwise false
public class DuplicatedNumbers {
	// 哈希 辅助空间O(n)，时间O(n)
	public class Solution {
		public boolean duplicate(int numbers[], int length, int[] duplication) {
			if (numbers == null || numbers.length <= 1)
				return false;
			int[] assist = new int[length];
			for (int i : numbers) {
				if (assist[i] == 0) {
					assist[i]++;
				} else {
					duplication[0] = i;
					return true;
				}
			}
			return false;
		}
	}

	// 排序 时间O（nlogn)
	public class Solution2 {

		public boolean duplicate(int numbers[], int length, int[] duplication) {
			if (numbers == null || numbers.length <= 1)
				return false;
			Arrays.sort(numbers);
			for (int i = 0; i < length - 1; i++) {
				if (numbers[i] == numbers[i - 1]) {
					duplication[0] = numbers[i];
					return true;
				}
			}
			return false;
		}
	}

	// 时间O(n) 原地，没有辅助
	// 充分利用是0~n-1范围内这一属性
	// 如果没有重复元素，那么排序后这个数组中的数字将会和自己的下标是一一对应的
	// 而如果有重复的元素，有些位置就有可能有多个数字，有些位置就可能没有数字
	// 从头到尾扫描，第i个位置的数字m是否等于i，如果等于i，那么就继续扫描
	// 如果不等于i,那么去找第m个下标数字，如果相等那么就重复了，如果不相等就交换了一下让m回到他自己的位置，再对交换后的位置进行同样的排查
	public class Solution3 {

		public boolean duplicate(int numbers[], int length, int[] duplication) {
			if (numbers == null || numbers.length <= 1)
				return false;
			for (int i = 0; i < length; i++) {
				while (numbers[i] != i) {
					if (numbers[numbers[i]] == numbers[i]) {
						duplication[0] = numbers[i];
						return true;
					}
					int tmp = numbers[i];
					numbers[i] = numbers[tmp];
					numbers[tmp] = tmp;
				}
			}
			return false;
		}
	}
}
