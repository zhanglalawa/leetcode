package base;
/*
 * 搜索过程中，以右上角元素为基准
 * 如果target大于右上角元素，那么排除最后一列
 * 如果target小于右上角元素，那么排除第一行
 */
public class SearchTwoDimension {
	public class Solution {
	    public boolean Find(int target, int [][] array) {
	        if(array == null || array.length == 0){
	            return false;
	        }
	        
	        int rows = array.length;
	        int columns = array[0].length;
	        
	        int row = 0;
	        int column = columns-1;
	        
	        while(row < rows && column >= 0){
	            if(array[row][column] == target){
	                return true;
	            }else if(target < array[row][column]){
	                column --;
	            }else{
	                row ++;
	            }
	        }
	        
	        return false;
	    }
	}
}
