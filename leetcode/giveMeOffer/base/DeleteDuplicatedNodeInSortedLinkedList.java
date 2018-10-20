package base;

public class DeleteDuplicatedNodeInSortedLinkedList {

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public class Solution {
		public ListNode deleteDuplication(ListNode pHead) {
			ListNode prev = null;
			ListNode curr = pHead;

			while (curr != null) {
				ListNode nextNode = curr.next;
				if (nextNode != null && nextNode.val == curr.val) {
					int value = curr.val;
					ListNode toBeDelete = curr;
					while(toBeDelete != null && toBeDelete.val == value) {
						nextNode = toBeDelete.next;
						toBeDelete.next = null;
						toBeDelete = nextNode;
					}
					
					if (prev == null) {
						pHead = nextNode;
					}else {
						prev.next = nextNode;
					}
					
					curr = nextNode;
				}else {
					prev = curr;
					curr = nextNode;
				}
			}
			
			return pHead;
		}
	}
}
