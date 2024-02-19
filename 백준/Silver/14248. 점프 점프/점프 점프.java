import java.io.*;
import java.util.*;

public class Main {
	static int N, start;
	static int map[];
	static boolean visited[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1];
		visited = new boolean[N+1];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		start = Integer.parseInt(br.readLine());
		
		BFS();

		int cnt = 0;
		for(int i=1; i<=N; i++) {
			if(visited[i]) {
				cnt++;
			}
		}
		System.out.println(cnt);
	}
	static void BFS() {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		visited[start] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			int newX = 0;
			
			for(int i=0; i<2; i++) {
				if(i == 0) {
					newX = now + map[now];
				}else {
					newX = now - map[now];
				}
				
				if(newX <= 0 || newX >=N+1 || visited[newX]) {
					continue;
				}
				
				queue.offer(newX);
				visited[newX] = true;
			}
		}
	}
}
