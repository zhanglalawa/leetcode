package btManipulation;
/*
 * ���Ǹ�������
 * Ȼ��ȥ������ж�������1�ĸ���
 */
public class HammingDistance461 {
	class Solution {
	    public int hammingDistance(int x, int y) {
	        int res = x^y;
	        int ret=0;
	        while(res  > 0){
	            if(res%2==1){
	                ret ++;
	            }
	            res = res >> 1;
	        }
	        return ret;
	    }
	}
}
