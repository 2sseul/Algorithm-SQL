import java.io.*;
import java.util.*;

public class Main {
	static int N, M, ans;
	static int arr[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		ans = 0;
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Check(0, 0);
		
		sb.append(ans);
		bw.write(sb.toString()); bw.flush(); bw.close();
		
	}
	static void Check(int start, int end) {
		int sum = arr[start];
		while(true) {
			if(end == N || start == N) {
				break;
			}
			if(sum < M) {
				end++;
				if(end == N) {
					break;
				}
				sum+=arr[end];
			}else if(sum > M) {
				sum-=arr[start];
				start++;
			}else {
				ans++;
				end++;
				if(end == N) {
					break;
				}
				sum+=arr[end];
			}
		}
	}
}
