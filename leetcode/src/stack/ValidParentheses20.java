package stack;

import java.util.Stack;

//leetcode20 Valid Parentheses
public class ValidParentheses20 {
	public boolean isValid(String s) {
        if(s.length() % 2 != 0)
            return false;
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i ++) {
        	char c = s.charAt(i);
        	if(c == '{' || c == '(' || c == '[') {
        		stack.push(c);
        	}
        	else {
        		if(stack.isEmpty()) {
        			return false;
        		}
        		else {
        			char top = stack.pop();
        			switch (top) {
					case '(':
						if (c != ')') {
							return false;
						}
						break;
					case '{':
						if (c != '}') {
							return false;
						}
						break;
					case '[':
						if (c != ']') {
							return false;
						}
						break;
					}
        		}
        	}
        }
        return stack.isEmpty();
    }
}
