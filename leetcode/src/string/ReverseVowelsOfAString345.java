package string;

public class ReverseVowelsOfAString345 {
	class Solution {
		
		private boolean isVowel(char c) {
			switch (c) {
			case 'a':
			case 'e':
			case 'i':	
			case 'o':
			case 'u':
			case 'A':
			case 'E':
			case 'I':
			case 'O':	
			case 'U':	
				return true;
			default:
				return false;
			}
		}
		
		private void swap(char[] charArray, int i, int j) {
			char c = charArray[i];
			charArray[i] = charArray[j];
			charArray[j] = c;
		}
		
	    public String reverseVowels(String s) {
	        char[] charArray = s.toCharArray();
	        int l = 0,r = charArray.length-1;
	        
	        while(l<r) {
	        	while(!isVowel(charArray[l])&& l < r) {
	        		l ++;
	        	}
	        	
	        	while(!isVowel(charArray[r])&& l < r) {
	        		r --;
	        	}
	        	
	        	if (l >= r) {
					break;
				}
	        	
	        	swap(charArray, l, r);
	        	l++;
	        	r--;
	        }
	        
	        return new String(charArray);
	    }
	}
}
