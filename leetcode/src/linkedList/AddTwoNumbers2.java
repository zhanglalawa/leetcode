package linkedList;

public class AddTwoNumbers2 {
	class Solution {
	    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	        ListNode a = l1;
	        ListNode b = l2;

	        ListNode newHead = new ListNode(0);
	        ListNode node = newHead;
	        int carry = 0;
	        while(a!=null&&b!=null){
	            int sum = a.val + b.val + carry;
	            node.next = new ListNode(sum%10);
	            node = node.next;
	            a = a.next;
	            b = b.next;
	            if(sum>=10){
	                carry = 1;            
	            }else{
	                carry = 0;
	            }
	        }
	        if(a== null && b == null){
	            if(carry != 0){
	                node.next = new ListNode(carry);
	            }
	            return newHead.next;
	        }
	        else if(a == null){
	            
	            while(b != null){
	                int sum = b.val +carry;
	                node.next = new ListNode(sum%10);
	                node = node.next;
	                
	                b = b.next;
	                
	                if(sum>=10){
	                    carry = 1;            
	                }else{
	                    carry = 0;
	                }
	            }
	        }else if(b == null){
	            while(a != null){
	                int sum = a.val +carry;
	                node.next = new ListNode(sum%10);
	                node = node.next;
	                a = a.next;
	                if(sum>=10){
	                    carry = 1;            
	                }else{
	                    carry = 0;
	                }
	            }
	        }
	        
	        if(carry != 0){
	            node.next = new ListNode(carry);
	        }
	        return newHead.next;
	    }
	}
}
