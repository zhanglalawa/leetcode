package base;

import java.util.ArrayList;
import java.util.TreeSet;

public class Permutation {
	public class Solution {
	    TreeSet<String> set = new TreeSet<>();
	    public ArrayList<String> Permutation(String str) {
	        if(str == null || str.length() == 0){
	            return new ArrayList<>();
	        }
	         
	        char[] charArray = str.toCharArray();
	        Permutation(charArray, 0);
	        return new ArrayList<>(set);
	    }
	    private void swap(char[] charArray, int i, int j){
	        if(i!=j){
	        char tmp = charArray[i];
	        charArray[i] = charArray[j];
	        charArray[j] = tmp;
	        }
	    }
	    public void Permutation(char[] charArray, int begin){
	        if(begin == charArray.length){
	            set.add(new String(charArray));
	            return;
	        }
	         
	        for(int i = begin; i < charArray.length; i++){
	            swap(charArray, begin, i);
	            Permutation(charArray, begin + 1);
	            swap(charArray, begin, i);
	        }
	    }
	    
	    
	}

}
