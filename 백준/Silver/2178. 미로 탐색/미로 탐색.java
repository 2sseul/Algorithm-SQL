import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int map[][];
	static boolean visited[][];
	static int goX[] = {0, 0, -1, 1};
	static int goY[] = {-1, 1, 0, 0};
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
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			String tmp = br.readLine();
			for(int j=0; j<M; j++) {
				map[i][j] = tmp.charAt(j)-'0';
			}
		}
		
		BFS(0,0);
		
		System.out.println(map[N-1][M-1]);
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
				
				if(newX < 0 || newX >= N || newY < 0 || newY >= M || map[newX][newY] == 0 || visited[newX][newY]) {
					continue;
				}
				
				map[newX][newY] = map[node.x][node.y] +1;
				visited[newX][newY] = true;
				queue.add(new Node(newX, newY));
			}
		}
	}
}
