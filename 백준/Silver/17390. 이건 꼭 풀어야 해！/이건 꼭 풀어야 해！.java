import java.io.*;
import java.util.*;

public class Main {
	static int arr[];
	static int sum[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		sum = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		sum[0] = arr[0];
		for(int i=1; i<N; i++) {
			sum[i] = sum[i-1]+arr[i];
		}
		
		for(int tc = 0; tc < Q; tc++) {
			st = new StringTokenizer(br.readLine());
			int L = Integer.parseInt(st.nextToken())-1;
			int R = Integer.parseInt(st.nextToken())-1;

			int ans = sum[R] - sum[L] + arr[L];
			
			sb.append(ans).append('\n');
		}
		
		bw.write(sb.toString());
		bw.close();
	}
}
