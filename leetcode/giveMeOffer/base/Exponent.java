package base;

import java.util.Objects;

public class Exponent {
	public class Solution {
	    public double Power(double base, int exponent) {
	        if(Objects.equals(base,0.0)&& exponent < 0){
	            return 0.0;
	        }
	        
	        boolean flag = exponent < 0;
	        
	        int absExponent = Math.abs(exponent);
	        double ret = PowerWithUnsignedExponent(base, absExponent);
	        
	        if(flag){
	            ret = 1/ret;
	        }
	        return ret;
	    }
	    
	    private double PowerWithUnsignedExponent(double base, int exponent){
	        double result = 1;
	        for(int i = 0; i < exponent; i++){
	            result *= base;
	        }
	        
	        return result;
	    }
	}
}
