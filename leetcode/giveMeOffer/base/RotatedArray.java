package base;

import java.util.ArrayList;
import java.util.Random;

/*
 * �������뵽�ľ���O(n)ȥ����
 * ������������û���κ�������
 * �۲�һ����ת����Ľṹ
 * ��ת�������ָ������������������
 * ����ʹ�ö��ֲ��ҵ�˼·
 * �м�Ԫ������������Ԫ��˵���м�Ԫ���ڵ�һ��������������
 * �Ǿ�����ָ���ƶ���Mid��
 * �м�Ԫ�����С�ڣ��������෴������ָ���ƶ���Mid��
 * ������left��right������1����ô��СԪ�ؾ���right��
 * ����������뻹��һ��BUG���� ���left��right�±��Ӧ���������
 * �м������Ҳ���������ʱ����군��
 * ������޷��ж����mid�������ڵ�һ���������黹�ǵڶ�����������
 * ��ʱ��Ͳ����ܼ������ֲ����ˣ���Ӧ�ðѷ�Χ��С��left��right����˳���������
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
