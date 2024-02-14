import java.io.*;
import java.util.*;

public class Main {
	static int N, cnt;
	static int map[];
	static int visited[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		N = Integer.parseInt(br.readLine());
		map = new int[N];
		visited = new int[N];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		BFS();
		
		if(visited[map.length-1] == 0) {
			if(N == 1) {
				sb.append(visited[map.length-1]);
			}else {
				sb.append("-1");
			}
		}else {
			sb.append(visited[map.length-1]);
		}
		
		System.out.println(sb.toString());
		
	}
	static void BFS() {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(0);
		
		while(!queue.isEmpty()){
			int now = queue.poll();
			
			int go = map[now];
			
			for(int i=0; i<go; i++) {
				int newX = now + (i+1);
				
				if(newX >= N || visited[newX] != 0) {
					continue;
				}
				
				queue.add(newX);
				visited[newX] = visited[now] + 1;
			}
		}
	}
}
