import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int map[][];
	static boolean visited[][];
	static int cnt = 0;
	static int count = 0;
	static int answer = 0;
	static int goX[] = {-1, 1, 0, 0};
	static int goY[] = {0, 0, -1, 1};
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				count = 0;
				if(map[i][j] == 1 && !visited[i][j]) {
					cnt++;
					DFS(i, j);
					answer = Math.max(answer, count);
					
				}
			}
		}
		
		sb.append(cnt).append('\n');
		sb.append(answer).append('\n');
		
		System.out.println(sb.toString());
		
	}
	static void DFS(int x, int y) {
		visited[x][y] = true;
		count++;
		
		for(int i=0; i<4; i++) {
			int newX = x + goX[i];
			int newY = y + goY[i];
			
			if(newX < 0 || newX >=  N || newY < 0 || newY >= M || map[newX][newY] == 0 || visited[newX][newY]) {
				continue;
			}
			
			DFS(newX, newY);
		}
	}
}
