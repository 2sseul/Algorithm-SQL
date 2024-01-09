import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		boolean[] state = new boolean[N];
		long[] water = new long[N];
		
		long initial = 0;
	
		for(int i=0; i<N; i++) {
			state[i] = true;
			water[i] = sc.nextLong();
			initial+= water[i];
		}
		
		System.out.println(initial);
		
		int touch = sc.nextInt();

		for(int i=0; i<touch; i++) {
			int num = sc.nextInt();
			int changeNum = sc.nextInt()-1;
			if(num == 1) {
				long change = sc.nextLong();
				//만약 바뀐 수도꼭지가 열려있을 경우,
				if(state[changeNum]) {
					initial -= water[changeNum];
					water[changeNum] = change;
					initial += water[changeNum];
				//만약 바뀐 수도꼭지가 닫혀있을 경우,
				}else {
					water[changeNum] = change;	
				}
			}else {
				state[changeNum] = !state[changeNum];
				if(state[changeNum]) {
					initial += water[changeNum];
				}else {
					initial -= water[changeNum];
				}
			}
			System.out.println(initial);
		}
	}
}
