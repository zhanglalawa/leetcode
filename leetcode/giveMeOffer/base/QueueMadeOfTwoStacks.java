package base;

import java.util.Stack;

public class QueueMadeOfTwoStacks {
	// 这是最正经的、最泵的方法，就是每次pop完都把所有元素调整回到stack1里面
	public class Solution1 {
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();

		public void push(int node) {
			stack1.push(node);
		}

		public int pop() {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
			int ret = stack2.pop();
			while (!stack2.isEmpty()) {
				stack1.push(stack2.pop());
			}
			return ret;
		}
	}

	// 而实际上，在pop的时候，可以等待stack2pop光，再把stack1压入到stack2里面
	public class Solution2 {
		Stack<Integer> stack1 = new Stack<Integer>();
		Stack<Integer> stack2 = new Stack<Integer>();

		public void push(int node) {
			stack1.push(node);
		}

		public int pop() {
			if (stack2.isEmpty()) {

				while (!stack1.isEmpty()) {
					stack2.push(stack1.pop());
				}
			}
			
			if (stack2.isEmpty()) {
				throw new RuntimeException("empty!");
			}
			return stack2.pop();
		}
	}
}
