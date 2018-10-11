package base;

import java.util.Stack;

public class QueueMadeOfTwoStacks {
	// �����������ġ���õķ���������ÿ��pop�궼������Ԫ�ص����ص�stack1����
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

	// ��ʵ���ϣ���pop��ʱ�򣬿��Եȴ�stack2pop�⣬�ٰ�stack1ѹ�뵽stack2����
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
