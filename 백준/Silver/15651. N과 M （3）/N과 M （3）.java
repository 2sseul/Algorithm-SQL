import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static StringBuilder sb = new StringBuilder();
	static int arr[];
	static int tmp[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = i+1;
		}
		
		tmp = new int[M];
		Cal(0, 0);
		
		bw.write(sb.toString());
		bw.close();
	}
	static void Cal(int start, int cnt) {
		if(cnt == M) {
			for(int i=0; i<cnt; i++) {
				sb.append(tmp[i]).append(" ");
			}
			sb.append('\n');
			return;
		}
		for(int i=start; i<N; i++) {
			tmp[cnt] = arr[i];
			Cal(start, cnt+1);
		}
	}
}
