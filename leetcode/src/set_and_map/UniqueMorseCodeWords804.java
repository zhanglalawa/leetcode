package set_and_map;

import java.util.Set;
import java.util.TreeSet;

public class UniqueMorseCodeWords804 {
	class Solution {
	    public int uniqueMorseRepresentations(String[] words) {
	       String[] pass = new String[] {".-","-...","-.-.","-..",".","..-.","--."
	                                      ,"....","..",".---","-.-",".-..","--","-."
	                                      ,"---",".--.","--.-",".-.","...","-"
	                                      ,"..-","...-",".--","-..-","-.--","--.."};
	        
	       Set<String> set = new TreeSet<>();
	       for(String word : words) {
	    	   StringBuilder code = new StringBuilder();
	    	   for(int i = 0; i < word.length(); i++) {
	    		   code.append(pass[word.charAt(i)-'a']);
	    	   }
	    	   set.add(code.toString());
	       }
	       return set.size();
	    }
	}
	
}
