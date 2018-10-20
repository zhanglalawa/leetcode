package string;

public class ValidPalindrome125 {
	
	class Solution {
		
	    public boolean isPalindrome(String s) {
	        
	    	if(s == null || s.length() == 0){
	            return true;
	        }
	        String fuck = s.toLowerCase().trim();
	        int l = 0, r = fuck.length()-1;
	        
	        while(l<r) {
	        	if (!Character.isLetterOrDigit(fuck.charAt(l))) {
					l++;
					continue;
				}
	        	
	        	if (!Character.isLetterOrDigit(fuck.charAt(r))) {
					r--;
					continue;
				}
	        	if (fuck.charAt(l)!=fuck.charAt(r)) {
					return false;
				}
	        	l++;
	        	r--;
	        }
	        return true;
	    }
	}
}
