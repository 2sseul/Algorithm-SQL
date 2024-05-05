import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());

		int dp[] = new int[5001];
		dp[3] = 1; dp[4] = -1; dp[5] = 1; dp[6] = 2; dp[7] = -1; dp[8] = 2;
		dp[9] = 3; dp[10] = 2; dp[11] = 3; dp[13] = 3; dp[15] = 3;

		int num = 4;
		int cnt = 0;
		for(int i=12; i<5001; i+=2) {
			dp[i] = num;
			cnt++;
			if(cnt == 5) {
				num+=2;
				cnt = 0;
			}
		}
		
		int n = 5;
		int c = 0;
		for(int i=17; i<5001; i+=2) {
			dp[i] = n;
			c++;
			if(c == 5) {
				n+=2;
				c = 0;
			}
		}
		
		sb.append(dp[N]);
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
