package set_and_map;

import java.util.HashMap;
import java.util.Map;

/*
 * ���⡣����ž��Ǹ�O(n^2)��
 * ʵ���Ͻ���Ǹ���ѧ�������
 */
public class NumberOfBoomerangs {
	class Solution {
		public int numberOfBoomerangs(int[][] points) {
			int n = points.length;
			int res = 0;
			for (int i = 0; i < n; i++) {
				Map<Integer, Integer> map = new HashMap<>();
				for (int j = 0; j < n; i++) {
					int distance = (int) (Math.pow(points[i][0] - points[j][0], 2)
							+ Math.pow(points[i][1] - points[j][1], 2));
					map.put(distance, map.getOrDefault(distance, 0) + 1);
				}

				for (Integer values : map.values()) {
					res += values * (values - 1);
				}
			}

			return res;
		}
	}
}
