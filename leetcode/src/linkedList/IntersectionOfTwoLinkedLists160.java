package linkedList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class IntersectionOfTwoLinkedLists160 {
	 public class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) {
		          val = x;
		          next = null;
		      }
	 }
	public class Solution {
	    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        ListNode a = headA;
	        ListNode b = headB;
	        
	        while(a != null && b != null) {
	        	a = a.next;
	        	b = b.next;
	        }
	        
	        if (a == null) {
				a = headB;
			}
	        
	        if (b == null) {
				b = headA;
			}
	        
	        while(a != null && b != null) {
	        	a = a.next;
	        	b = b.next;
	        }
	        
	        if (a == null) {
				a = headB;
			}
	        
	        if (b == null) {
				b = headA;
			}
	        
	        while(a != null && b != null) {
	        	if (a == b) {
					return a;
				}
	        	a = a.next;
	        	b = b.next;
	        }
	        
	        return null;
	    }
	}
}

