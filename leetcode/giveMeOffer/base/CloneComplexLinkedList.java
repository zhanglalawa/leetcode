package base;

import java.util.HashMap;
import java.util.Map;

/*
 * 可以用暴力去解
 * 先按Next遍历一遍，把整个链表的主干复制出来
 * 然后对每个节点再去检查原链表中random的位置，再在复制的链表中找到random的位置，更新random指针
 * 这样是O(n^2)
 * 下面有两种方法可以优化到O(n)
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
	 * 第一种方法是借助map，有O(n)的辅助空间
	 * 在第一次遍历复制链表主干时候，让每个旧的节点N映射到复制的节点N'
	 * 这样一来可以通过旧的节点在O(1)时间找到对应的新的节点。
	 * 那么在更新random指针时候，就不需要再去遍历了。
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
