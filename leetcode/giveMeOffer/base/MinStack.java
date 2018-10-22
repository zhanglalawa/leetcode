package base;

import java.util.EmptyStackException;
import java.util.Stack;
/*
 * ��ֱ�׵��뷨������һ����������СԪ�ش�����
 * �������������СԪ�س�ջ�ˣ�����ô�죬������Ȼ��С���δ�С���Ǳ��������ġ�
 * Ϊ�ˣ�����һ������ջ
 * ��Ҫ������������ ʲôʱ����ջѹ��Ԫ��
 * �Զ��׼����и�С��Ԫ��ʱ��һ����Ҫѹ��assistStack
 * ������и����Ԫ����ô����
 * ��һ��˼·�Ƕ�assist�����κδ�����ô��popʱ�򣬾���Ҫ���stack��assitStack��ջ��Ԫ���Ƿ���ȣ�Ȼ������Ƿ��assistStack��pop
 * �������µ������ǣ�����кü���Ԫ�ض��ǵ�����СԪ��������popʱ��Ͳ�֪��Ҫ��Ҫpop��assistStackջ���Ǹ�Ԫ�أ�һ��ֱ�ӵĽ��˼·������pushʱ�����������СԪ�أ��Ǿͼ���push��ȥ
 * ����Ӧ��û��ʲô������
 * ��������Ҳ������Pushʱ���������push��Ԫ�ش��ڵ�����СԪ�أ��Ͱ���СԪ�����븨��ջһ�Σ������Ͳ���ÿ��popʱ��������ջ��Ԫ���Ƿ���� �ˡ�
 */
public class MinStack {
	public class Solution {

	    Stack<Integer> stack = new Stack<>();
	    Stack<Integer> assistStack = new Stack<>();
	    public void push(int node) {
	        
	        if(!assistStack.isEmpty() && node >= assistStack.peek()) {//ջ��Ϊ�գ�����
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
