import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws IOException {
		Scanner sc = new Scanner(System.in);
		
		long k = sc.nextLong();
		long a = sc.nextLong();
		long b = sc.nextLong();
		long c = sc.nextLong();
		long d = sc.nextLong();
		
		long ans = a*k+b;
		long ans1 = c*k+d;
		
		if(ans == ans1) {
			System.out.println("Yes "+ans);
		}else {
			System.out.println("No");
		}
        //ㅋㅋ 아 재밌었다..
	}
}