import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N];
		int dp[] = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			dp[i] = arr[i];
		}
		
		int num = dp[0];
		for(int i=0; i<N; i++) {
			for(int j=0; j<i; j++) {
				if(arr[i] > arr[j] && dp[i] < dp[j]+arr[i]) {
					dp[i] = dp[j]+arr[i];
				}
				if(num < dp[i]) {
					num = dp[i];
				}
			}
		}
		
		sb.append(num);
		bw.write(sb.toString());
		bw.close();
	}
}
