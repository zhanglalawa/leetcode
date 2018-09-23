package linkedList;
/*
 * ����ָ�뷨
 * ��ı�����Ҫ����n��
 * Ȼ���ڿ�ĵ������һ����ʱ��slow�պõ�Ҫremove�ĵ��prev��
 * Ȼ����prev����·ȥremove����
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
