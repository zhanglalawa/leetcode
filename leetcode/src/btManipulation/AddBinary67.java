package btManipulation;

public class AddBinary67 {
	class Solution {
	    public String addBinary(String a, String b) {
	        if(a==null){
	            return b;
	        }
	    
	        if(b==null){
	            return a;
	        }
	    
	        char[] first = a.toCharArray();
	        char[] second = b.toCharArray();
	       
	        int carry = 0, sum = 0;
	        String ans = "";
	        int i = first.length - 1, j = second.length -1;
	        int x;
	        int y;
	        while (i >= 0 || j >= 0) {
	            x = (i >= 0)? first[i] - '0' : 0;
	            y = (j >= 0)? second[j] - '0' : 0;
	            sum = x ^ y ^ carry;
	            carry = (x & y) |( carry & (x | y));
	            ans = sum + ans;
	            i--;
	            j--;
	        }
	        
	        if (carry == 1) 
	            ans = 1 + ans;
	        return ans;
	    }
	}
}
