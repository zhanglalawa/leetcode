package base;

import java.util.ArrayList;
import java.util.Stack;

import base.EntryNodeOfLoop.Solution.ListNode;

public class PrintLinkedListReversely {
	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}
	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ListNode cur = listNode;
        Stack<Integer> stack = new Stack<>();
        while(cur != null){
            stack.push(cur.val);
            cur = cur.next;
        }
        ArrayList<Integer> ret = new ArrayList<>();
        while(!stack.isEmpty()){
            ret.add(stack.pop());
        }
        return ret;
    }
}
