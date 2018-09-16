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
	        //��������Ľ��Ҫ��Ҫ�������Ӵ�С�����ͬʱ���д������ʱ��Ҫ��String�ıȽ�ȥȷ�����ȼ�
	        //����Ƚ�����Ҫע��ĵط����ǻ�Ҫ�����ڴ�����ͬʱ
	        //�������Ǹ���С�ѣ���ĿҪ������ĸ��С�����ȼ��ߣ�
	        //�����Ļ�����ϣ���Ѷ������ȼ��͵ģ�Ҳ������ĸ����
	        //��������ıȽ������ؽ����String��compareTo�ķ���ֵ���÷����෴��
	        //������������һ������
	        //ֻҪץס���ǶѶ���Ԫ���������ױ������Ԫ����һ��ͺ��ˡ�ʲô���������������������С�ѣ��Ǿ������ȼ���ͣ�
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
