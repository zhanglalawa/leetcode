package base;

import java.util.HashMap;

public class FirstNotReapting {
	public class Solution {
	    public int FirstNotRepeatingChar(String str) {
	        char[] charArray = str.toCharArray();
	         
	        HashMap<Character,Integer> map = new HashMap<>();
	         
	        for(int i = 0; i < charArray.length; i++){
	            map.put(charArray[i], map.getOrDefault(charArray[i],0)+1);
	        }
	         
	        for(int i = 0; i < charArray.length; i++){
	            if(map.get(charArray[i]) == 1){
	                return i;
	            }
	        }
	        return -1;
	    }
	}

}
