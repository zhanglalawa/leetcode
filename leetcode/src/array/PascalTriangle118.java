package array;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle118 {
	class Solution {
	    public List<List<Integer>> generate(int numRows) {
	        if(numRows <= 0){
	            return new ArrayList<>();
	        }
	        List<List<Integer>> triangle = new ArrayList<List<Integer>>();

	        triangle.add(new ArrayList<Integer>());
	        triangle.get(0).add(1);//line1
	        

	        for(int i = 1; i < numRows; i++){//line(i+1)
	            List<Integer> lastRow = triangle.get(i-1);
	            List<Integer> newRow = new ArrayList<>();
	            
	            newRow.add(1);
	            
	            //line(i+1) (i+1)numbers             
	            //2！！i index 1！！i-1
	            for(int j = 1; j < i; j++){
	                newRow.add(lastRow.get(j)+lastRow.get(j-1));
	            }
	            
	            newRow.add(1);
	            
	            triangle.add(newRow);
	        }
	        return triangle;
	    }
	}
}
