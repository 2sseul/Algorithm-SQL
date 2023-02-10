import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int W = sc.nextInt();
		int H = sc.nextInt();
		int L = sc.nextInt();
		
		int num1 = W/L;
		int num2 = H/L;
		int num3 = num1*num2;
		
		if(num3>N) {
			System.out.println(N);
		}else {
			System.out.println(num3);
		}
	}
}
