import java.io.*;
import java.util.*;

public class Main {
	static int N, M, cnt;
	static int map[][];
	static int visited[][];
	static int goX[] = {-1, -1, -1, 0, 0, 1, 1, 1};
	static int goY[] = {-1, 0, 1, -1, 1, -1, 0, 1};
	static class Shark{
		int x;
		int y;
		Shark(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static Queue<Shark> queue = new LinkedList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new int[N][M];
		cnt = Integer.MIN_VALUE;
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 1) {
					visited[i][j] = 1;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				visited = new int[N][M];
				if(map[i][j] == 1) {
					queue.offer(new Shark(i, j));
				}
			}
		}
		
		BFS();

		System.out.println(cnt);
	}
	static void BFS() {
		while(!queue.isEmpty()) {
			Shark s = queue.poll();
			
			for(int i=0; i<8; i++) {
				int newX = s.x + goX[i];
				int newY = s.y + goY[i];
				
				if(newX <0 || newX >= N || newY <0 || newY >= M || visited[newX][newY] != 0 || map[newX][newY] == 1) {
					continue;
				}
				
				visited[newX][newY] = visited[s.x][s.y] + 1;
				if(visited[newX][newY] > cnt) {
					cnt = Math.max(cnt, visited[newX][newY]);
				}
				//System.out.println(Arrays.deepToString(visited));
				queue.offer(new Shark(newX, newY));
			}
		}
	}
}
