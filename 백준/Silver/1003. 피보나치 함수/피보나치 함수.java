import java.io.*;
import java.util.*;

public class Main {
	static int N, zeroCnt, oneCnt;
	static int zero[] = new int[41];
	static int one[] = new int[41];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		zero[0] = 1;
		zero[2] = 1;
		one[1] = 1;
		one[2] = 1;
		
		N = Integer.parseInt(br.readLine());
		fibo();
		for(int i=0; i<N; i++) {
			int tmp = Integer.parseInt(br.readLine());
			sb.append(zero[tmp]).append(" ").append(one[tmp]).append('\n');
		}
		bw.write(sb.toString());
		bw.close();
	}
	static void fibo() {
		int zeroNow = zero[1]+zero[2];
		int oneNow = one[1]+one[2];
		int N = 3;
		while(true) {
			if(N == 41) {
				return;
			}
			zero[N] = zeroNow;
			one[N] = oneNow;
			zeroNow = zeroNow - zero[N-2] + zero[N];
			oneNow = oneNow - one[N-2] + one[N];
			N++;
		}

	}
}
