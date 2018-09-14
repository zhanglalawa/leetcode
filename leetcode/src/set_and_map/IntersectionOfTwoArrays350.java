package set_and_map;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class IntersectionOfTwoArrays350 {
	class Solution {
		
		public int[] intersect(int[] nums1, int[] nums2) {
			if (nums1.length == 0 || nums2.length == 0 || nums1 == null || nums2 == null) {
				return new int[0];
			}
			Map<Integer, Integer> map = new HashMap<>();
			for (int num : nums1) {
				if (!map.containsKey(num)) {
					map.put(num, 1);
				}else{
				map.put(num, map.get(num) + 1);
                }
			}

			ArrayList<Integer> res = new ArrayList<>();
			for (int num : nums2) {
				if (map.get(num) != null) {
					map.put(num, map.get(num) - 1);
					res.add(num);
					if (map.get(num) == 0) {
						map.remove(num);
					}
				}
			}

			int[] ret = new int[res.size()];
			for (int i = 0; i < ret.length; i++) {
				ret[i] = res.get(i);
			}
			return ret;
		}
	}
}
