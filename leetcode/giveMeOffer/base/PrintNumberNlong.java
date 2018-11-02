package base;

import java.util.Arrays;

public class PrintNumberNlong{
	private static char[] number;
	public static void PrintNumber(int n) {
		number = new char[n];
		Arrays.fill(number, '0');
		while(!Increment()) {
			PrintNumber();
		}
	}
	
	public static void PrintNumber() {
		boolean begin = false;
		for(int i = 0; i < number.length; i++) {
			if (number[i] == '0' && !begin) {
				continue;
			}
			begin = true;
			System.out.print(number[i]);
		}
		System.out.println();
	}
	
	public static boolean Increment() {
		int carry = 1;
		boolean overFlow = false;
		
		for(int i = number.length - 1; i >= 0; i--) {
			
			int sum = carry + (number[i] - '0');
			
			if (sum == 10) {
				if (i == 0) {
					overFlow = true;
					break;
				}else {
					number[i] = '0';
					carry = 1;
				}
			}else {
				number[i] = (char)('0' + sum);
				break;
			}
		}
		
		return overFlow;
	}
	
	public static void main(String[] args) {
		PrintNumber(7);
	}
}
