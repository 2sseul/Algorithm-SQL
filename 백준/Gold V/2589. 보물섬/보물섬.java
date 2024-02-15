import java.io.*;
import java.util.*;

public class Main {
	static int N, M, count;
	static String map[][];
	static boolean visited[][];
	static int goX[] = {-1, 1, 0, 0};
	static int goY[] = {0, 0, -1, 1};
	static class Treasure{
		int x;
		int y;
		int cnt;
		Treasure(int x, int y, int cnt){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new String[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String tmp = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = tmp.charAt(j)+"";
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visited = new boolean[N][M];
				if(map[i][j].equals("L") && !visited[i][j]) {
					BFS(i, j, 0);
				}
			}
		}
		
		System.out.println(count);
	}
	static void BFS(int x, int y, int cnt) {
		Queue<Treasure> queue = new LinkedList<>();
		queue.offer(new Treasure(x, y, cnt));
		
		while(!queue.isEmpty()) {
			Treasure t = queue.poll();
			visited[t.x][t.y] = true;
			
			for(int i=0; i<4; i++) {
				int newX = t.x + goX[i];
				int newY = t.y + goY[i];
				
				if(newX <0 || newX >= N || newY <0 || newY >= M || map[newX][newY].equals("W") || visited[newX][newY]) {
					continue;
				}
				
				count = Math.max(count, t.cnt+1);
				queue.offer(new Treasure(newX, newY, t.cnt+1));
				visited[newX][newY] = true;
			}
		}
	}
}
