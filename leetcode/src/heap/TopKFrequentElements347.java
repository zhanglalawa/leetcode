package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentElements347 {
	class Solution {
	    public List<Integer> topKFrequent(int[] nums, int k) {
	    	Map<Integer, Integer> map = new HashMap<>();
	        for(int i = 0; i < nums.length;i++) {
	        	map.put(nums[i], map.getOrDefault(nums[i], 0)+1);
	        }
	        
	        PriorityQueue<Integer> heap = new PriorityQueue<>(new Comparator<Integer>() {

				@Override
				public int compare(Integer o1, Integer o2) {
					return map.get(o1)-map.get(o2);
				}
	        	
			});
	        
	        for(int i : map.keySet()) {
	        	if (heap.size() < k) {
					heap.add(i);
				}else {
					if (map.get(i) > map.get(heap.peek())) {
						heap.remove();
						heap.add(i);
					}
				}
	        }
	        
	        List<Integer> list = new ArrayList<>();
	        while(!heap.isEmpty()) {
	        	list.add(heap.remove());
	        }
	        return list;
	    }
	}
}
