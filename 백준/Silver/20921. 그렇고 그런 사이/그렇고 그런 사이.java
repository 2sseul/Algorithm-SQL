import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int arr[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for(int i=1; i<=N; i++) {
			arr[i-1] = i;
		}
		
		Swap(0, N-1, N-1);
		
		for(int i=0; i<N; i++) {
			sb.append(arr[i]).append(" ");
		}
		
		bw.write(sb.toString()); bw.close();
	}
	static void Swap(int cnt, int start, int dot) {
		while(true) {
			if(cnt == K) {
				return;
			}
			if(start >= 1 && arr[start] > arr[start-1]) {
				int now = arr[start];
				arr[start] = arr[start-1];
				arr[start-1] = now;
				start--;
				cnt++;
				if(cnt == K) {
					return;
				}
			}else {
				start = dot;
				continue;
			}
		}
	}
}
