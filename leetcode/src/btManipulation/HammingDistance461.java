package btManipulation;
/*
 * 就是个异或操作
 * 然后去检查结果中二进制中1的个数
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
