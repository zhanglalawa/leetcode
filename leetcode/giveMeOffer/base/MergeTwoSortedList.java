package base;

import base.KthToTail.Solution.ListNode;

public class MergeTwoSortedList {
	public class Solution {
		public class ListNode {
			int val;
			ListNode next = null;

			ListNode(int val) {
				this.val = val;
			}
		}
	    public ListNode Merge(ListNode list1,ListNode list2) {
	        ListNode mergeHead = new ListNode(-1);
	        ListNode p = mergeHead;
	        while(list1 != null && list2 != null){
	            if(list1.val < list2.val){
	                p.next = list1;
	                list1 = list1.next;
	                p = p.next;
	            }else{
	                p.next = list2;
	                list2 = list2.next;
	                p = p.next;
	            }
	        }
	        
	        if(list1 != null){
	            p.next = list1;
	        }else{
	            p.next = list2;
	        }
	        
	        return mergeHead.next;
	    }
	}
}
