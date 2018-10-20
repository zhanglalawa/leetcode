package base;

public class KthToTail {
	public class Solution {
		public class ListNode {
			int val;
			ListNode next = null;

			ListNode(int val) {
				this.val = val;
			}
		}
		public ListNode FindKthToTail(ListNode head, int k) {
			if (head == null || k == 0) {
				return null;
			}
			ListNode dummyHead = new ListNode(-1);
			dummyHead.next = head;
			ListNode fast = dummyHead;
			for(int i = 0; i < k; i++) {//这块就可能报空指针异常,因为可能链表总结点数不够k个
				if (fast.next != null) {
					fast = fast.next;
				}else {
					return null;
				}
			}
			
			ListNode slow = dummyHead;
			while(fast != null) {
				fast = fast.next;
				slow = slow.next;
			}
			
			return slow;
		}
	}
}
