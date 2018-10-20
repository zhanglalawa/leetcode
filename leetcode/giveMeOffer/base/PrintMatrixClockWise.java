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
	        //ÿ�ζ��Ǵ�(start,start)��ʼ��ӡ������ӡѭ��������������columns��rows��>2*start��������Ի���ͼ��֤
	        while(columns > 2 * start && rows > 2 * start){
	            addAns(ret,matrix,start,rows,columns);
	            start++;
	        }
	        
	        return ret;
	    }
	    
	    private void addAns(ArrayList<Integer> ans, int [][] matrix, int start, int rows, int columns){
	    	////������߽���±�
	    	int endX = columns -1 - start;
	        int endY = rows -1 -start;
	        
	        //������
	        for(int i = start; i <= endX; i++){
	            ans.add(matrix[start][i]);
	        }
	        
	        //���ϵ���
	        for(int i = start+1; i <= endY; i++){
	            ans.add(matrix[i][endX]);
	        }
	        //ǰ������ѭ�����Դ���鷶Χ
	        
	        //���ҵ���
	        //�������ifһ�£���ȷ������ֻ��һ�У��ڵ�һ�з����������ظ���ӡ
	        if(start < endY){
	            for(int i = endX-1; i >= start;i--){
	                ans.add(matrix[endY][i]);
	            }
	        }
	        
	        //���ϵ���
	        //�������Ifһ�£���ȷ������ֻ��һ�У��ڵ�һ�з����������ظ���ӡ
	        if(start < endX){
	            for(int i = endY-1; i>start; i--){
	                ans.add(matrix[i][start]);
	            }
	        }
	    }
	}
}
