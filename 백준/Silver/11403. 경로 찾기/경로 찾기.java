import java.io.*;
import java.util.*;

public class Main {
	static int G;
	static int node[];
	static boolean visited[];
	static int map[][];
	static int ans[][];
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		G = Integer.parseInt(br.readLine());
		
		node = new int[G];
		for(int i=0; i<G; i++) {
			node[i] = i;
		}
		
		map = new int[G][G];
		for(int i=0; i<G; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<G; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		ans = new int[G][G];
		
		for(int i=0; i<G; i++) {
			visited = new boolean[G];
			Go(i);
		}
		
		Answer();
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	static void Answer() {
		for(int i=0; i<G; i++) {
			for(int j=0; j<G; j++) {
				sb.append(ans[i][j]).append(" ");
			}
			sb.append('\n');
		}
	}
	
	static void Go(int x) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(x);
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			for(int i=0; i<G; i++) {
				if(map[now][i] == 1 && !visited[i]) {
					ans[x][i] = 1;
					visited[i] = true;
					queue.offer(i);
				}else {
					continue;
				}
			}
		}
	}
}
