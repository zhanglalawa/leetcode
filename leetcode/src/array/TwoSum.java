package array;

import java.util.HashMap;
import java.util.Map;

//用一个map存一下 key是键，value是下标
public class TwoSum {
	class Solution {
	    public int[] twoSum(int[] nums, int target) {
	    	Map<Integer, Integer> map = new HashMap<>();
	    	
	    	for(int i = 0; i < nums.length; i ++) {
	    		map.put(nums[i], i);
	    	}
	    	
	    	for(int i = 0; i < nums.length; i ++) {
	    		int complement = target - nums[i];
	    		if (map.containsKey(complement) && map.get(complement)!=i) {
					return new int[] {i,map.get(complement)};
				}
	    	}
	    	
	    	return null;
	    }    	
	}
}
