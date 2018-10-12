package base;
/*
 * 就是个斐波那契数列了
 */
public class BounceUpStep {
	public class Solution {
	    public int JumpFloor(int target) {
	        int a=0;
	        int b=1,c=0;
	        for(int i = 0; i < target; i++){
	            a = b + c;
	            c = b;
	            b = a;
	        }
	        return a;
	    }
	}
}
