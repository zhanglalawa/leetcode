package base;

import java.util.EmptyStackException;
import java.util.Stack;
/*
 * 最直白的想法就是用一个变量把最小元素存起来
 * 但是这样如果最小元素出栈了，那怎么办，所以显然次小，次次小都是保存起来的。
 * 为此，我们一个辅助栈
 * 需要解决的问题就是 什么时候辅助栈压入元素
 * 显而易见是有更小的元素时候一定需要压入assistStack
 * 而如果有更大的元素怎么处理？
 * 第一种思路是对assist不做任何处理，那么在pop时候，就需要检查stack和assitStack的栈顶元素是否相等，然后决定是否给assistStack做pop
 * 这样导致的问题是，如果有好几个元素都是等于最小元素了那在pop时候就不知道要不要pop在assistStack栈顶那个元素？一个直接的解决思路就是在push时候如果等于最小元素，那就继续push进去
 * 这样应该没有什么问题了
 * 不过我们也可以在Push时候如果发现push的元素大于等于最小元素，就把最小元素再入辅助栈一次，这样就不用每次pop时候检查两个栈顶元素是否相等 了。
 */
public class MinStack {
	public class Solution {

	    Stack<Integer> stack = new Stack<>();
	    Stack<Integer> assistStack = new Stack<>();
	    public void push(int node) {
	        
	        if(!assistStack.isEmpty() && node >= assistStack.peek()) {//栈不为空，并且
	        	assistStack.push(stack.peek());
	        }else {
	        	assistStack.push(node);
	        }
	        stack.push(node);
	    }
	    
	    public void pop() {
	    	if(stack.isEmpty()){
                throw new EmptyStackException();
            }
	        stack.pop();
	        assistStack.pop();
	    }
	    
	    public int top() {
	    	if (stack.isEmpty()) {
				throw new EmptyStackException();
			}
	        return stack.peek();
	    }
	    
	    public int min() {
	    	if (stack.isEmpty()) {
				throw new EmptyStackException();
			}
	        return assistStack.peek();
	    }
	}
}
