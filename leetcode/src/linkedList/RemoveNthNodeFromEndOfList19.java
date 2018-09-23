package linkedList;
/*
 * 快慢指针法
 * 快的比慢的要领先n个
 * 然后在快的到达最后一个点时候，slow刚好到要remove的点的prev处
 * 然后按照prev的套路去remove即可
 */
public class RemoveNthNodeFromEndOfList19 {
	class Solution {
	    public ListNode removeNthFromEnd(ListNode head, int n) {
	        ListNode slow = head;
	        ListNode fast = slow;
	        for(int i = 0; i < n; i++){
	            fast = fast.next;
	        }
	        if(fast == null){
	            return head.next;
	        }
	        while(fast.next != null){
	            slow = slow.next;
	            fast = fast.next;
	        }
	        
	        ListNode node = slow.next;
	        slow.next = node.next;
	        node.next = null;
	        return head;
	    }
	}
}
