package array;
/*
 * ���˼·�Ϳ��ŵĵ�һ��partition��һģһ����
 */
public class MoveZeroes283 {
	class Solution {
		public void moveZeroes(int[] nums) {
			int index = -1;// [0...index]�Ƿ���Ԫ��
			int tmp;
			for (int i = 0; i < nums.length; i++) {
				if (nums[i] != 0) {
					if (index + 1 != i) {
						tmp = nums[i];
						nums[i] = nums[index + 1];
						nums[index+1] = tmp;
					}
					index++;
				}
			}
		}
	}
}
