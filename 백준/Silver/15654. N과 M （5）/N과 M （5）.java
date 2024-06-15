import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int tmp[];
	static int arr[];
	static boolean visited[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N];
		arr = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		tmp = new int[M];
		
		Arrays.sort(arr);
		
		Col(0);
		
		bw.write(sb.toString());
		bw.close();
	}
	public static void Col( int cnt) {
		if(cnt == M) {
			for(int i=0; i<tmp.length; i++) {
				sb.append(tmp[i]).append(" ");
			}
			sb.append('\n');
			return;
		}
		for(int i=0; i<N; i++) {
			if(!visited[i]) {
				tmp[cnt] = arr[i];
				visited[i] = true;
				Col(cnt+1);
				visited[i] = false;
			}
		}
	}
}
