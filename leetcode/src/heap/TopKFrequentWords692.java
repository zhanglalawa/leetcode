package heap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKFrequentWords692 {
	class Solution {
	    public List<String> topKFrequent(String[] words, int k) {
	    	Map<String, Integer> map = new HashMap<>();
	        for(int i = 0; i < words.length;i++) {
	        	map.put(words[i], map.getOrDefault(words[i], 0)+1);
	        }
	        //这个题最后的结果要求要按次数从大到小输出，同时还有次数相等时候要按String的比较去确定优先级
	        //这个比较器需要注意的地方就是还要处理在次数相同时
	        //由于这是个最小堆，题目要求是字母序小的优先级高，
	        //这样的话我们希望堆顶是优先级低的，也就是字母序大的
	        //所以这里的比较器返回结果和String的compareTo的返回值正好符号相反！
	        //所以我们添上一个负号
	        //只要抓住我们堆顶的元素是最容易被替代的元素这一点就好了。什么是最容易替代，由于是最小堆，那就是优先级最低！
	        PriorityQueue<String> heap = new PriorityQueue<>(new Comparator<String>() {
				@Override
				public int compare(String o1, String o2) {
					if (map.get(o1)==map.get(o2)) {
						return -o1.compareTo(o2);
					}
					return map.get(o1)-map.get(o2);
				}
	        	
			});
	        
	        for(String str : map.keySet()) {
	        	if (heap.size() < k) {
					heap.add(str);
				}else {
					if (map.get(str) > map.get(heap.peek())) {
						heap.remove();
						heap.add(str);
					}
				}
	        }
	        
	        List<String> list = new ArrayList<>();
	        while(!heap.isEmpty()) {
	        	list.add(heap.remove());
	        }
	        
	        Collections.reverse(list);
	        return list;
	    }
	}
}
