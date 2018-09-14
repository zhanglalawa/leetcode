package set_and_map;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoArrays349 {
	class Solution {
		public int[] intersection(int[] nums1, int[] nums2) {
			if (nums1.length == 0 || nums2.length == 0 || nums1 == null || nums2 == null) {
				return new int[0];
			}
			Set<Integer> n1 = new HashSet<>();
			for (int i = 0; i < nums1.length; i++) {
				n1.add(nums1[i]);
			}
			ArrayList<Integer> res = new ArrayList<>();
			for (int number : nums2) {
				if (n1.contains(number)) {
					res.add(number);
					n1.remove(number);
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
