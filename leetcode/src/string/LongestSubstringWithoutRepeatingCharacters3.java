package string;

import java.util.Arrays;
import java.util.Objects;

public class LongestSubstringWithoutRepeatingCharacters3 {
	class Solution {
	    public int lengthOfLongestSubstring(String s) {
	        int[] freq = new int[256];
	        
	        Arrays.fill(freq,0);
	        int l = 0, r = 0;
	        int ans = 0;
	        while(r < s.length()){//[l....r)
	            if( freq[s.charAt(r)] == 0){
	                freq[s.charAt(r++)]++;
	            }else{
	                freq[s.charAt(l++)]--;
	            }
	            
	            ans = Math.max(ans,r-l);
	            
	        }
	        
	        return ans;
	    }
	}
	
	public static void main(String[] args) {
		System.out.println(Objects.equals(6.2, 5.2));
	}
}
