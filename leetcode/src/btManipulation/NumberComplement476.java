package btManipulation;
/*
 * 还是手动去转换二进制
 */
public class NumberComplement476 {
	public int findComplement(int num) {
        int res = 0;
        int i = 0;
        while(num > 0){
            if(num%2==0){
                res += 1 << i;
            }
            
            i++;
            num = num >> 1;
            
        }
        
        return res;
    }
}
