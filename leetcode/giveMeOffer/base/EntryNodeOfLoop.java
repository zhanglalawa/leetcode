package base;

import base.KthToTail.Solution.ListNode;

public class EntryNodeOfLoop {
	
	public class Solution {
		public class ListNode {
			int val;
			ListNode next = null;

			ListNode(int val) {
				this.val = val;
			}
		}
	    private ListNode hasCircle(ListNode head){
	        ListNode p1 = head;
	        ListNode p2 = head;
	        
	        do{
	            p1=p1.next;
	            p2=p2.next.next;
	        }while(p1 != p2);
	        return p1;
	    }
	    public ListNode EntryNodeOfLoop(ListNode pHead){
	        if(pHead == null || pHead.next==null){
	            return null;
	        }
	        ListNode node = hasCircle(pHead);
	        int numInCircle = 1;
	        if(node != null){
	            ListNode initNode = node;
	            node = node.next;
	            while(node != initNode){
	                node = node.next;
	                numInCircle++;
	            }
	        }else{
	            return null;
	        }
	        
	        node = pHead;
	        ListNode node1 = pHead;
	        for(int i = 0; i < numInCircle; i++){
	            node1 = node1.next;
	        }
	        
	        while(node != node1){
	            node = node.next;
	            node1 = node1.next;
	        }
	        
	        return node;
	    }
	}
}
