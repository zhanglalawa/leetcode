package dp;

public class ClimbStairs70 {
	
	//��һ�־��뵽�˼��仯����
	//��n��̨�׿��Դ�n-1����n-2������������ô��n�������֣�������n-1����n-2�������ĺ�
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
	
	//�ܼ��仯��������ȻҲ���Զ�̬�滮
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
