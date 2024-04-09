import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int dp[] = new int[1001];
		
		dp[1] = 1;
		dp[2] = 2;
		
		for(int i=3; i<=1000; i++) {
			dp[i] = dp[i-1]%10007 + dp[i-2]%10007;
		}
		
		int ans = dp[N]%10007;
		
		sb.append(ans);
		bw.write(sb.toString());
		bw.close();
	}
}
