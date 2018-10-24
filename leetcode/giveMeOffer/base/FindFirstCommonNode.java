package base;

public class FindFirstCommonNode {
	/*
	 * 方法比较巧妙
	 * 使用双指针的思想
	 * 两个指针一起跑，比较理想的情况是相遇之前的节点数是相等的
	 * 那么第一次遍历过程中一定相遇，直接返回那个相遇的节点
	 * 而一般情况则是两条链表在相遇节点之前的节点数目是不相等的
	 * 那么就让两个节点ab一起走，这种情况不可能相遇，假设其中一个节点a先走到末尾null
	 * 然后呢让这个节点a去到另一个节点b所在链表的头部，继续两个一起走，之后b又必然先到null
	 * 再让b去到a一开始所在的那条链表的头部，继续两个一起走。
	 * 这样两个必然在commonNode处相遇
	 * 方法讲完就知道原理了，经过两次交换之后，相当于它们两走的是一条路，不过a先走链表一后走链表二，b先走链表二后走链表一
	 * ab会两次经过commonNode，而在第二次经过时候，它们就会相遇了
	 */
	public class Solution {	
		public class ListNode {
		    int val;
		    ListNode next = null;

		    ListNode(int val) {
		        this.val = val;
		    }
		}
	    private ListNode FindFirstCommonNode(ListNode p1, ListNode p2, ListNode pHead1, ListNode pHead2){
	            p1 = pHead2;
	            while(p1 != null && p2 != null){
	                p1=p1.next;
	                p2=p2.next;
	            }
	            
	            p2 = pHead1;
	        
	            while(p1!=p2){
	                p1=p1.next;
	                p2=p2.next;
	            }
	            
	            return p1;
	    }
	    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
	        ListNode p1 = pHead1;
	        ListNode p2 = pHead2;
	        
	        while(p1!=null && p2!=null){
	        	if(p1==p2){
	                return p1;
	            }
	            p1 = p1.next;
	            p2 = p2.next;
	        }
	        
	        if(p1==null){
	            return FindFirstCommonNode(p1,p2,pHead1,pHead2);
	        }else{
	            return FindFirstCommonNode(p2,p1,pHead2,pHead1);
	        }
	        
	        
	    }
	}
}
