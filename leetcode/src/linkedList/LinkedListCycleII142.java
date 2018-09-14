package linkedList;

public class LinkedListCycleII142 {
	public class Solution {
	    public ListNode detectCycle(ListNode head) {
	        if(head == null || head.next == null){
	            return null;
	        }
	        
	        ListNode slow = head;
	        ListNode fast = head.next;
	        while(slow != fast ){
	            if(fast == null || fast.next == null){
	                return null;
	            }    
	            
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        
	        slow = head;
	        fast = fast.next;
	        while(slow != fast){
	            slow = slow.next;
	            fast = fast.next;
	        }
	        
	        return fast;
	    }
	}
}
