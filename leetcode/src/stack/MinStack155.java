package stack;

import java.util.Stack;

public class MinStack155 {
	Stack<Integer> commonStack;
	Stack<Integer> minStack;

	/** initialize your data structure here. */
	public MinStack155() {
		commonStack = new Stack<>();
		minStack = new Stack<>();
	}

	public void push(int x) {
		if (minStack.size() == 0) {
			minStack.push(x);
		} else if (x <= minStack.peek()) {
			minStack.push(x);
		}

		commonStack.push(x);

	}

	public void pop() {
		int top = commonStack.pop();
		if (top == minStack.peek()) {
			minStack.pop();
		}
	}

	public int top() {
		return commonStack.peek();
	}

	public int getMin() {
		return minStack.peek();
	}

	public static void main(String[] args) {
		MinStack155 obj = new MinStack155();
		obj.push(2);
		obj.push(1);
		obj.push(3);
		obj.push(4);
		obj.pop();
		int param_3 = obj.top();
		int param_4 = obj.getMin();
		System.out.println(param_3);
		System.out.println(param_4);
	}
}
