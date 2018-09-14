package linkedList;
/*双指针
 * 跑的快的一定会追上跑得慢的 而且一定会相遇
 */
public class LinkedListCycleI141 {
	public class Solution {
	    public boolean hasCycle(ListNode head) {
	        if(head == null || head.next == null){
	            return false;
	        }
	        ListNode slow = head;
	        ListNode fast = head.next.next;
	        
	        while(slow != fast){
	            if(fast == null || fast.next == null){
	                return false;
	            }
	            slow = slow.next;
	            fast = fast.next.next;
	        }
	        
	        return true;
	    }
	}
}
