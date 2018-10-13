package array;
/*
 * 这个思路和快排的第一种partition是一模一样的
 */
public class MoveZeroes283 {
	class Solution {
		public void moveZeroes(int[] nums) {
			int index = -1;// [0...index]是非零元素
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
