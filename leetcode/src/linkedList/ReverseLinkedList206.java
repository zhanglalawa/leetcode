package linkedList;

public class ReverseLinkedList206 {
	class Solution {
	    public ListNode reverseList(ListNode head) {
	        ListNode dummyHead = new ListNode(0);
	        
	        ListNode curr = head;
	        
	        while(curr != null){
	            ListNode node = curr;
	            curr = curr.next;
	            node.next = dummyHead.next;
	            dummyHead.next = node;
	        }
	        return dummyHead.next;   
	    }
	}
}
