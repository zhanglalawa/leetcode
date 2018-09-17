package string;


public class ReverseStringI344 {
	class Solution {
		//��һ�ַ���o(n)��Ȼ��Ҷ������뵽
	    public String reverseString(String s) {
	    	char[] charArray = s.toCharArray();
	    	int i = 0;
	    	int j = s.length() -1;
	    	while(i<j) {
	    		char c = charArray[i];
	    		charArray[i] = charArray[j];
	    		charArray[j] = c;
	    		i++;
	    		j--;
	    	}
	    	return new String(charArray);
	    }
	    
	    //�ڶ�����һ���ݹ�ⷨ ��nlogn
	    //��Ҳ�ܵݹ顣���ݹ�����������ڵݹ��ʹ�û�û�е�����ˮ׼������
	    public String reverseString2(String s) {
	    	if (s.length() <= 1) {
				return s;
			}
	    	
	    	String rightStr = s.substring(0, s.length()/2);
	    	String leftStr = s.substring(s.length()/2,s.length());
	    	return reverseString(rightStr) + reverseString(leftStr);
	    }
	}
}
