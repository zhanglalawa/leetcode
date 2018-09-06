package stack;

import java.util.Stack;

public class BackspaceStringCompare844 {
	class Solution {
		public boolean backspaceCompare(String S, String T) {
			Stack<Character> sStack = new Stack<>();
			Stack<Character> tStack = new Stack<>();

			for (int i = 0; i < S.length(); i++) {
				if (S.charAt(i) != '#') {
					sStack.push(S.charAt(i));
				} else {
					//����Ϊ�˷�ֹһ��������#,ջ�����ǿյ�
					if (!sStack.isEmpty()) {
						sStack.pop();
					}
				}
			}

			for (int i = 0; i < T.length(); i++) {
				if (T.charAt(i) != '#') {
					tStack.push(T.charAt(i));
				} else {
					if (!tStack.isEmpty()) {
						tStack.pop();
					}

				}
			}

			if (sStack.size() != tStack.size()) {
				return false;
			}

			while (!sStack.isEmpty()) {
				if (sStack.pop() != tStack.pop()) {
					return false;
				}
			}

			return true;
		}
	}
}
