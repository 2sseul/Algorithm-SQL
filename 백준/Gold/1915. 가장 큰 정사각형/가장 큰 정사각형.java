import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static char map[][];
	static int dp[][];
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new char[M][N];
		dp = new int[M][N];
		ans = 0;
		
		for(int i=0; i<M; i++) {
			String tmp = br.readLine();
			map[i] = tmp.toCharArray();
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]=='1') {
					dp[i][j] = 1;
					ans = 1;
				}
			}
		}
		
		for(int i=1; i<M; i++) {
			for(int j=1; j<N; j++) {
				if(map[i-1][j-1] == '1' && map[i][j-1] == '1' && map[i-1][j]=='1' && map[i][j]=='1') {
					dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i][j-1], dp[i-1][j]))+1;
					ans = Math.max(dp[i][j], ans);
				}
			}
		}
		
		sb.append(ans*ans);
		bw.write(sb.toString());
		bw.close();
	}
}
