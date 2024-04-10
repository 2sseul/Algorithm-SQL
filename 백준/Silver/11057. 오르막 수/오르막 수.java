import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int dp[] = new int[1001];
		dp[1] = 10;
		dp[2] = 55;
		
		int cnt[] = {1, 3, 6, 10, 15, 21, 28, 36, 45, 55};
		
		int idx = 2;
		
		if(N == 1 || N == 2) {
			sb.append(dp[N]);
		}else {
			while(true) {
				for(int i=2; i<=10; i++) {
					cnt[i-1] = cnt[i-1]%10007+cnt[i-2]%10007;
					cnt[i-1] = cnt[i-1]%10007;
				}
				
				idx++;
				
				dp[idx] = cnt[9];
				
				if(idx == N) {
					break;
				}
			}
			sb.append(dp[N]);
		}
		
		bw.write(sb.toString());
		bw.close();
	}
}
