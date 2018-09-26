package dp;

public class ClimbStairs70 {
	
	//第一种就想到了记忆化搜索
	//第n级台阶可以从n-1级和n-2级爬上来，那么求n级多少种，就是求n-1级和n-2级种数的和
	class Solution {
		int[] memory;
	    private int climbStairs1(int n){
	        if(n == 1){
	            return 1;
	        }
	        
	        if(n == 2){
	            
	            return 2;
	        }
	        
	        if(memory[n] == 0){
	            memory[n] = climbStairs(n-1) + climbStairs(n-2);
	        }
	        return memory[n];
	    }
	    public int climbStairs(int n) {
	        memory = new int[n+1];
	        return climbStairs(n);
	    }
	}
	
	//能记忆化搜索，自然也可以动态规划
	class Solution2 {

	    public int climbStairs(int n) {
	        int[] memory = new int[n+1];
	        memory[0] = 1;
	        memory[1] = 1;
	        for(int i = 2; i <= n; i++){
	            memory[i] = memory[i-1] + memory[i-2];
	        }
	        return memory[n];
	    }
	}
}
