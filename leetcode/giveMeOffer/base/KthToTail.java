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
			for(int i = 0; i < k; i++) {//���Ϳ��ܱ���ָ���쳣,��Ϊ���������ܽ��������k��
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
