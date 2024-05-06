import java.io.*;
import java.util.*;

public class Main{
	static int N, M;
	static int arr[][];
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = 0;
		
		int K = Integer.parseInt(br.readLine());
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int startX = Integer.parseInt(st.nextToken())-1;
			int endX = Integer.parseInt(st.nextToken())-1;
			int startY = Integer.parseInt(st.nextToken())-1;
			int endY = Integer.parseInt(st.nextToken())-1;
			
			Count(startX, endX, startY, endY);
			
			sb.append(ans).append('\n');
		}
		bw.write(sb.toString());
		bw.close();
	}
	static void Count(int x1, int x2, int y1, int y2) {
		ans = 0;
		
		for(int i=x1; i<=y1; i++) {
			for(int j=x2; j<=y2; j++) {
				ans+= arr[i][j];
			}
		}
		
	}
}
