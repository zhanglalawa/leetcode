package base;

public class BinarySearch {

	public static int binarySearch(int[] nums, int target) {
		return binarySearch(nums, 0, nums.length - 1, target);
	}

	private static int binarySearch(int[] nums, int l, int r, int target) {
		while (l <= r) {//[l....r]�������ѯ��l > r ʱ���γɲ��˱������ˣ�˵��û���ҵ�
			int mid = l + (r - l) / 2;
			if (nums[mid] == target) {//�ҵ�
				return mid;
			} else if (nums[mid] > target) {//˵���м�λ��̫���ˣ�����Ҫ��[l.....mid-1]�м�������
				r = mid - 1;
			} else {//˵���м�λ��̫С�ˣ�����Ҫ��[mid+1 ....r]�м�������
				l = mid + 1;
			}
		}
		return -1;//����ѭ����û���ҵ� ����-1
	}

	public static int lowerBound(int[] nums, int target) {// ��һ�����ڵ���target�������±�
		return lowerBound(nums, 0, nums.length, target);
	}

	private static int lowerBound(int[] nums, int l, int r, int target) {
		while (l < r) {//��[l....r]�в��ң�l == rʱ�򣬼г�����Ψһ��λ��
			int mid = l + (r - l) / 2;
			if (nums[mid] >= target) {//�м�λ�ô��ڵ���target������[l....mid]�м�������
				r = mid;
			} else {//�м�λ��С��target����[mid+1...r]�в���
				l = mid + 1;
			}
		}
		return l;
	}

	public static int upperBound(int[] nums, int target) {// ��һ������target����
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
