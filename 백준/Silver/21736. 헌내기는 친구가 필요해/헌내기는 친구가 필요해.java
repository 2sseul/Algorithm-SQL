import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static String map[][];
	static boolean visited[][];
	static int startX, startY;
	static int goX[] = {-1, 1, 0, 0};
	static int goY[] = {0, 0, -1, 1};
	static int cnt = 0;
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
		
		map = new String[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String tmp = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = String.valueOf(tmp.charAt(j));
				if(map[i][j].equals("I")) {
					startX = i;
					startY = j;
				}
			}
		}
		
		BFS(startX, startY);
		
		if(cnt == 0) {
			sb.append("TT");
		}else {
			sb.append(cnt);
		}
		
		System.out.println(sb.toString());
	
	}
	static void DFS(int x, int y) {
		visited[x][y] = true;
		
		if(map[x][y].equals("P")) {
			cnt++;
		}
		
		for(int i=0; i<4; i++) {
			int newX = x + goX[i];
			int newY = y + goY[i];
			
			if(newX < 0 || newX >= N || newY < 0 || newY >= M || visited[newX][newY] || map[newX][newY].equals("X")) {
				continue;
			}
			
			DFS(newX, newY);
		}
	}
	static void BFS(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			visited[node.x][node.y] = true;
			
			for(int i=0; i<4; i++) {
				int newX = node.x + goX[i];
				int newY = node.y + goY[i];
				
				if(newX < 0 || newX >= N || newY < 0 || newY >= M || visited[newX][newY] || map[newX][newY].equals("X")) {
					continue;
				}
				
				if(map[newX][newY].equals("P")) {
					cnt++;
				}
				
				queue.add(new Node(newX, newY));
				visited[newX][newY] = true;
			}
		}
	}
}
