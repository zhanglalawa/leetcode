package string;


public class ReverseStringI344 {
	class Solution {
		//第一种方法o(n)当然大家都可以想到
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
	    
	    //第二种是一个递归解法 是nlogn
	    //这也能递归。。递归真是美妙，对于递归的使用还没有到这种水准。惭愧
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
