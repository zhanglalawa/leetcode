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
		//����Ȼ�������ķ�����
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
	    //�мǵÿ���ָ���𡣡���һ�������ߣ�һ��һ���ߣ���ô�����ߵ���һ��������
	    //�š����������Ļ��Ͳ�����˵�ˡ���*������ѹ����
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
