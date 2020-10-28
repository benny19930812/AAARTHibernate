package javaMVCHomework;

import java.util.Scanner;

public class GcdLcm {

	public static int gcd(int m, int n) {

		int gcd = 1;
		if (n == 0) {
			gcd=m;
		}else {
			
			gcd=gcd(n, m % n);
		}	
		return gcd;
	}

	public static int lcm(int m, int n) {
		
		int lcm = m * n / gcd(m, n);
		
		return lcm;
	}

	public static void main(String[] args) {
	Scanner scanner = new Scanner(System.in);	
	
	System.out.println("請輸入數字A");
	int m = scanner.nextInt();
	
	System.out.println("請輸入數字=B");
	int n = scanner.nextInt();
	
	System.out.printf(m+"和"+n+"最大公因數為: = %d\n", gcd(m, n));
	System.out.printf(m+"和"+n+"最小公倍數為:= %d ", lcm(m, n));
	

	}
}