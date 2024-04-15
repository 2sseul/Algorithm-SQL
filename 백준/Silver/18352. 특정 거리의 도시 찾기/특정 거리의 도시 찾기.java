import java.io.*;
import java.util.*;

public class Main {
	static int N, M, K, X;
	static int map[][];
	static int city[];
	static boolean visited[];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		X = Integer.parseInt(st.nextToken());
		
		city = new int[N+1];
		map = new int[M][2];
		visited = new boolean[N+1];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			map[i][0] = Integer.parseInt(st.nextToken());
			map[i][1] = Integer.parseInt(st.nextToken());
		}
		
		Search(X);
		
		city[X] = 0;
		
		Count();
		
		if(sb.length() == 0) {
			sb.append(-1);
		}
		
		bw.write(sb.toString());
		bw.close();
	}
	static void Search(int start) {
		Queue<Integer> q = new LinkedList<>();
		q.offer(start);
		
		while(!q.isEmpty()) {
			int now = q.poll();
			for(int i=0; i<M; i++) {
				if(map[i][0]==now && !visited[map[i][1]]) {
					city[map[i][1]] = city[now]+1;
					if(city[map[i][1]] > K) {
						return;
					}
					q.offer(map[i][1]);
					visited[map[i][1]] = true;
				}else {
					continue;
				}
			}
		}
	}
	static void Count() {
		for(int i=1; i<=N; i++) {
			if(city[i]==K) {
				sb.append(i).append('\n');
			}
		}
	}
}
