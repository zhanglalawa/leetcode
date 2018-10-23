package base;

import java.util.ArrayList;
import java.util.Random;

/*
 * 最容易想到的就是O(n)去遍历
 * 但这样这个题就没有任何意义了
 * 观察一下旋转数组的结构
 * 旋转后的数组分割成了两个递增的数组
 * 可以使用二分查找的思路
 * 中间元素如果大于左边元素说明中间元素在第一个递增数组里面
 * 那就让左指针移动到Mid处
 * 中间元素如果小于，则正好相反，让右指针移动到Mid处
 * 如果最后left和right距离是1，那么最小元素就在right处
 * 不过这个代码还有一个BUG就是 如果left和right下标对应的数字相等
 * 中间的数字也和他们相等时候就完蛋了
 * 你根本无法判断这个mid数字是在第一个递增数组还是第二个递增数组
 * 这时候就不可能继续二分查找了，而应该把范围缩小在left到right进行顺序遍历查找
 */
public class RotatedArray {
	public class Solution {
		public int minNumberInRotateArray(int[] array) {
			int l = 0, r = array.length - 1;
			int mid = l;
			while (array[l] >= array[r]) {
				if (r - l == 1) {
					mid = r;
					break;
				}
				mid = l + (r-l)/2;
				if (array[mid]>=array[l]) {
					l = mid;
				}else if (array[mid] <= array[r]) {
					r = mid;
				}
			}
			return array[mid];
		}
	}
}
