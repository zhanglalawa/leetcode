package base;
/*
 * ���������У������Ͻ�Ԫ��Ϊ��׼
 * ���target�������Ͻ�Ԫ�أ���ô�ų����һ��
 * ���targetС�����Ͻ�Ԫ�أ���ô�ų���һ��
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
