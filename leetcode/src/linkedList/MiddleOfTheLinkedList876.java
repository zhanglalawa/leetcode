package linkedList;

public class MiddleOfTheLinkedList876 {
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) { val = x; }
	 * }
	 */
	class Solution {
		//这自然是最笨最暴力的方法。
	    public ListNode middleNode(ListNode head) {
	        ListNode cur= head;
	        
	        int i = 0;
	        while(cur != null){
	            i++;
	            cur = cur.next;
	        }
	        
	        cur = head;
	        for(int j = 0; j < i/2; j++){
	            cur = cur.next;
	        }
	        return cur;
	    }
	    //有记得快慢指针吗。。让一个两步走，一个一步走，那么两步走的是一步的两倍
	    //嗯。。接下来的话就不用我说了。真*智商碾压。。
	    public ListNode middleNode(ListNode head) {
	        ListNode fast = head;
	        ListNode slow = head;
	        while(fast.next!=null) {
	        	slow = slow.next;
	        	fast = fast.next.next;
	        }
	        return slow;
	    }
	}
}
