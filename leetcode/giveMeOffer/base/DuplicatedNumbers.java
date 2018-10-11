package base;

import java.util.Arrays;

// Parameters:
//    numbers:     an array of integers
//    length:      the length of array numbers
//    duplication: (Output) the duplicated number in the array number,length of duplication array is 1,so using duplication[0] = ? in implementation;
//                  Here duplication like pointor in C/C++, duplication[0] equal *duplication in C/C++
//    ����Ҫ�ر�ע��~���������ظ���һ������ֵduplication[0]
// Return value:       true if the input is valid, and there are some duplications in the array number
//                     otherwise false
public class DuplicatedNumbers {
	// ��ϣ �����ռ�O(n)��ʱ��O(n)
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

	// ���� ʱ��O��nlogn)
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

	// ʱ��O(n) ԭ�أ�û�и���
	// ���������0~n-1��Χ����һ����
	// ���û���ظ�Ԫ�أ���ô�������������е����ֽ�����Լ����±���һһ��Ӧ��
	// ��������ظ���Ԫ�أ���Щλ�þ��п����ж�����֣���Щλ�þͿ���û������
	// ��ͷ��βɨ�裬��i��λ�õ�����m�Ƿ����i���������i����ô�ͼ���ɨ��
	// ���������i,��ôȥ�ҵ�m���±����֣���������ô���ظ��ˣ��������Ⱦͽ�����һ����m�ص����Լ���λ�ã��ٶԽ������λ�ý���ͬ�����Ų�
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
