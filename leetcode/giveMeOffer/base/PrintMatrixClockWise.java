package base;

import java.util.ArrayList;

public class PrintMatrixClockWise {
	public class Solution {
	    public ArrayList<Integer> printMatrix(int [][] matrix) {
	       if(matrix == null){
	           return new ArrayList<>();
	       }
	       
	        int rows = matrix.length;
	        int columns = matrix[0].length;
	        
	        if(rows == 0 || columns == 0){
	            return new ArrayList<>();
	        }
	        
	        ArrayList<Integer> ret = new ArrayList<>();
	        
	        int start = 0;
	        //每次都是从(start,start)开始打印，而打印循环继续的条件是columns和rows都>2*start，这个可以画个图验证
	        while(columns > 2 * start && rows > 2 * start){
	            addAns(ret,matrix,start,rows,columns);
	            start++;
	        }
	        
	        return ret;
	    }
	    
	    private void addAns(ArrayList<Integer> ans, int [][] matrix, int start, int rows, int columns){
	    	////计算出边界的下标
	    	int endX = columns -1 - start;
	        int endY = rows -1 -start;
	        
	        //从左到右
	        for(int i = start; i <= endX; i++){
	            ans.add(matrix[start][i]);
	        }
	        
	        //从上到下
	        for(int i = start+1; i <= endY; i++){
	            ans.add(matrix[i][endX]);
	        }
	        //前面两个循环中自带检查范围
	        
	        //从右到左
	        //这里必须if一下，以确保不是只有一行，在第一行反复横跳，重复打印
	        if(start < endY){
	            for(int i = endX-1; i >= start;i--){
	                ans.add(matrix[endY][i]);
	            }
	        }
	        
	        //从上到下
	        //这里必须If一下，以确保不是只有一列，在第一列反复横跳，重复打印
	        if(start < endX){
	            for(int i = endY-1; i>start; i--){
	                ans.add(matrix[i][start]);
	            }
	        }
	    }
	}
}
