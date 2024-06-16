import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int arr[];
	static boolean visited[];
	static int tmp[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		visited = new boolean[N];
		tmp = new int[M];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		Col(0, 0);
		
		bw.write(sb.toString());
		bw.close();
	}
	public static void Col(int start, int cnt) {
		if(cnt == M) {
			for(int i=0; i<cnt; i++) {
				sb.append(tmp[i]).append(" ");
			}
			sb.append('\n');
			return;
		}
		for(int i=start; i<N; i++) {
			if(!visited[i]) {
				tmp[cnt] = arr[i];
				visited[i] = true;
				Col(i, cnt+1);
				visited[i] = false;
			}
		}
	}
}
