package base;

import base.KthToTail.Solution.ListNode;

public class ReverseLinkedList {
	public class Solution {
		public class ListNode {
			int val;
			ListNode next = null;

			ListNode(int val) {
				this.val = val;
			}
		}
		
		/*
		 * ����ͷ��㷨
		 */
	    public ListNode ReverseList(ListNode head) {
	        if(head == null){
	            return null;
	        }
	        ListNode dummyHead = new ListNode(-1);

	        ListNode curr = head;
	        
	        while(curr != null){
	            ListNode node = curr;
	            curr = curr.next;
	            node.next = dummyHead.next;
	            dummyHead.next = node;
	        }
	        
	        return dummyHead.next;
	    }
	    
	    /*
	     * ����ָ�뷴ת��
	     */
	    
	    public ListNode ReverseList1(ListNode head) {
	        if(head == null){
	            return null;
	        }
	        ListNode prev = null;
	        ListNode curr = head;
	        
	        while(curr != null){
	            ListNode pNext = curr.next;
	            curr.next = prev;
	            prev = curr;
	            curr = pNext;
	        }
	        
	        return prev;
	    }
	}
}
