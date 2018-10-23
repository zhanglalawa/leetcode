package base;

import java.util.HashMap;
import java.util.Map;

/*
 * �����ñ���ȥ��
 * �Ȱ�Next����һ�飬��������������ɸ��Ƴ���
 * Ȼ���ÿ���ڵ���ȥ���ԭ������random��λ�ã����ڸ��Ƶ��������ҵ�random��λ�ã�����randomָ��
 * ������O(n^2)
 * ���������ַ��������Ż���O(n)
 */
public class CloneComplexLinkedList {
	
	public class RandomListNode {
	    int label;
	    RandomListNode next = null;
	    RandomListNode random = null;

	    RandomListNode(int label) {
	        this.label = label;
	    }
	}
	/*
	 * ��һ�ַ����ǽ���map����O(n)�ĸ����ռ�
	 * �ڵ�һ�α���������������ʱ����ÿ���ɵĽڵ�Nӳ�䵽���ƵĽڵ�N'
	 * ����һ������ͨ���ɵĽڵ���O(1)ʱ���ҵ���Ӧ���µĽڵ㡣
	 * ��ô�ڸ���randomָ��ʱ�򣬾Ͳ���Ҫ��ȥ�����ˡ�
	 */
	public class Solution {
	    public RandomListNode Clone(RandomListNode pHead){
	        RandomListNode head = new RandomListNode(0);
	        
	        RandomListNode curr = head;
	        RandomListNode oldCurr = pHead;
	        
	        Map<RandomListNode,RandomListNode> map = new HashMap<>();
	        
	        while(oldCurr != null){
	            curr.next= new RandomListNode(oldCurr.label);
	            curr = curr.next;
	            map.put(oldCurr,curr);
	            oldCurr = oldCurr.next;
	        }
	        
	        curr = head.next;
	        oldCurr = pHead;
	        while(curr != null){
	            curr.random = map.get(oldCurr.random);
	            curr = curr.next;
	            oldCurr = oldCurr.next;
	        }
	        
	        return head.next;
	    }
	}
}
