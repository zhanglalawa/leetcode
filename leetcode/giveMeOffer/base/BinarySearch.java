package base;

public class BinarySearch {

	public static int binarySearch(int[] nums, int target) {
		return binarySearch(nums, 0, nums.length - 1, target);
	}

	private static int binarySearch(int[] nums, int l, int r, int target) {
		while (l <= r) {//[l....r]闭区间查询，l > r 时候形成不了闭区间了，说明没有找到
			int mid = l + (r - l) / 2;
			if (nums[mid] == target) {//找到
				return mid;
			} else if (nums[mid] > target) {//说明中间位置太大了，所以要在[l.....mid-1]中继续查找
				r = mid - 1;
			} else {//说明中间位置太小了，所以要在[mid+1 ....r]中继续查找
				l = mid + 1;
			}
		}
		return -1;//跳出循环了没有找到 返回-1
	}

	public static int lowerBound(int[] nums, int target) {// 第一个大于等于target的数的下标
		return lowerBound(nums, 0, nums.length, target);
	}

	private static int lowerBound(int[] nums, int l, int r, int target) {
		while (l < r) {//在[l....r]中查找，l == r时候，夹出来了唯一的位置
			int mid = l + (r - l) / 2;
			if (nums[mid] >= target) {//中间位置大于等于target，则在[l....mid]中继续查找
				r = mid;
			} else {//中间位置小于target，在[mid+1...r]中查找
				l = mid + 1;
			}
		}
		return l;
	}

	public static int upperBound(int[] nums, int target) {// 第一个大于target的数
		return upperBound(nums, 0, nums.length, target);
	}

	private static int upperBound(int[] num, int l, int r,int target) {
		while (l < r) {
			int mid = l + (r - l) / 2;
			if (num[mid] > target) {
				r = mid;
			} else {
				l = mid + 1;
			}
		}
		return l;
	}
	
	public static void main(String[] args) {
		int[] nums = new int[] {2,3,3,5,7,7,7,7,7,7,9,10,12};
		
		System.out.println(binarySearch(nums, 5));
		System.out.println(lowerBound(nums, 13));
		System.out.println(upperBound(nums, 3));
	}
}
