package dp;

import java.util.List;

public class Triangle120 {
	class Solution {
	    int[][] dp;
	    
	    public int minimumTotal(List<List<Integer>> triangle) {
	            int m = triangle.size();
	            
				int n = triangle.get(m-1).size();
				dp = new int[m][n];
				
				for(int i = 0; i < n; i++) {
					dp[m-1][i] = triangle.get(m-1).get(i);
				}
				
				for(int i = m -2 ; i >= 0; i--) {
					for(int j = 0; j <= i; j++) {
						dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i+1][j], dp[i+1][j+1]); 
					}
				}
				
				return dp[0][0];
	    }
	}
}
