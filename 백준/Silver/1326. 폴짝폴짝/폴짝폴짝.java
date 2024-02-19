import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int map[];
	static int visited[];
	static int start, end, cnt;
	static class Jump{
		int x;
		int cnt;
		Jump(int x, int cnt){
			this.x = x;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N+1];
		visited = new int[N+1];
		cnt = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=1; i<N+1; i++) {
			map[i] = Integer.parseInt(st.nextToken());
		}
		
		st = new StringTokenizer(br.readLine());
		start = Integer.parseInt(st.nextToken());
		end = Integer.parseInt(st.nextToken());
		
		BFS();
		
		if(visited[end] == 0) {
			sb.append("-1");
		}else {
			sb.append(visited[end]);
		}
		
		System.out.println(sb.toString());
	}
	static void BFS() {
		Queue<Jump> queue = new LinkedList<>();
		queue.offer(new Jump(start, 0));
		
		while(!queue.isEmpty()) {
			Jump jump = queue.poll();
			int now = jump.x;
			cnt = jump.cnt;
			
			if(now == end) {
				return;
			}
			
			for(int j=1; now+(j*map[now])<=N; j++) {
				int newX = now + (map[now]*j);
				
				if(visited[newX] == 0){
					visited[newX] = cnt+1;
					queue.offer(new Jump(newX, cnt + 1));
				}
			}
			
			for(int j=1; now-(j*map[now])>=1; j++) {
				int newX = now - (map[now]*j);
				
				if(visited[newX] == 0){
					visited[newX] = cnt+1;
					queue.offer(new Jump(newX, cnt + 1));
				}
			}
		}
	}
}
