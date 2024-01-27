import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int map[][];
	static boolean visited[][];
	static int goX[] = {-1, 1, 0, 0};
	static int goY[] = {0, 0, -1, 1};
	static String answer;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visited = new boolean[M][N];
		answer = "NO";
		
		for(int i=0; i<M; i++) {
			String tmp = br.readLine();
			for(int j=0; j<N; j++) {
				map[i][j] = tmp.charAt(j)-'0';
			}
		}
		
		for(int i=0; i<N; i++) {
			if(map[0][i] == 0 && !visited[0][i]) {
				answer = "NO";
				DFS(0, i);
			}
		}
		
		for(int i=0; i<N; i++) {
			if(visited[M-1][i]) {
				answer = "YES";
				break;
			}
		}
		
		System.out.println(answer);
	}
	
	static void DFS(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int newX = x + goX[i];
			int newY = y + goY[i];
			
			
			if(newX < 0 || newX >=M || newY <0 || newY >=N || map[newX][newY] == 1 || visited[newX][newY]) {
				continue;
			}
			
			DFS(newX, newY);
		}
		
	}
}
