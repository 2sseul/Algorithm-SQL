import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int map[][];
	static boolean visited[][];
	static int cnt = 0;
	static int goX[] = { -1, -1, -1, 0, 0, 1, 1, 1};
	static int goY[] = {-1, 0, 1, -1, 1, -1, 0, 1};
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
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
				if(map[i][j]==1 && !visited[i][j]) {
					cnt++;
					BFS(i, j);
				}
			}
		}
		
		sb.append(cnt);
		System.out.println(cnt);
	}
	static void BFS(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, y));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			visited[node.x][node.y] = true;
			
			for(int i=0; i<8; i++) {
				int newX = node.x + goX[i];
				int newY = node.y + goY[i];
				
				if(newX <0 || newX >= N || newY <0 || newY >=M || visited[newX][newY] || map[newX][newY] == 0) {
					continue;
				}
				
				queue.add(new Node(newX, newY));
				visited[newX][newY] = true;
			}
		}
	}
}
