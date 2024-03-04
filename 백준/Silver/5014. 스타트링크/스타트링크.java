import java.io.*;
import java.util.*;

public class Main {
	static int F, S, G, U, D;
	static int map[];
	static boolean visited[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		F = Integer.parseInt(st.nextToken());
		S = Integer.parseInt(st.nextToken());
		G = Integer.parseInt(st.nextToken());
		U = Integer.parseInt(st.nextToken());
		D = Integer.parseInt(st.nextToken());
		
		map = new int[F+1];
		visited = new boolean[F+1];
		
		BFS(S);
		
		if(map[G] == 0) {
			if(S == G) {
				sb.append(map[G]);
			}else {
				sb.append("use the stairs");
			}
		}else {
			sb.append(map[G]);
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	static void BFS(int x) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);
		visited[x] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			int newX = 0;

			for(int i=0; i<2; i++) {
				if(i == 0) {
					newX = now + U;
				}else {
					newX = now - D;
				}
				
				if(newX <= 0 || newX > F || visited[newX]) {
					continue;
				}
				
				map[newX] = map[now] + 1;
				queue.offer(newX);
				visited[newX] = true;
			}
		}
		
	}
}
