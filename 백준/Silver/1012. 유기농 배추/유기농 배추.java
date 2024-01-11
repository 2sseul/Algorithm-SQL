import java.util.*;
import java.io.*;

public class Main {
	static int T, M, N, K;
	static int farmland[][];
	static boolean visited[][];
	static int goX[] = {-1, 1, 0, 0};
	static int goY[] = {0, 0, -1, 1};
	static class Node{
		int x;
		int y;
		
		Node(int x, int y) {
			this.x = x;
			this.y = y;	
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		//테스트케이스 
		T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			M = Integer.parseInt(st.nextToken());
			N = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			
			farmland = new int[M][N];
			visited = new boolean[M][N];
			
			int num = 0;
			
			for(int j=0; j<K; j++) {
				st = new StringTokenizer(br.readLine());
				
				int m = Integer.parseInt(st.nextToken());
				int n = Integer.parseInt(st.nextToken());
				farmland[m][n] = 1;
			}
			
			for(int j=0; j<M; j++) {
				for(int k=0; k<N; k++) {
					if(farmland[j][k]==1 && !visited[j][k]) {
						dfs(j, k);
						num++;
					}
				}
			}
			
			sb.append(num);
			sb.append('\n');
		}
		System.out.println(sb);
	}
	
	static void bfs(int x, int y) {
			Queue<Node> queue = new LinkedList<>();
			queue.add(new Node(x, y));
			
			while(!queue.isEmpty()) {
				Node node = queue.poll();
				visited[node.x][node.y] = true;
				
				for(int j=0; j<4; j++) {
					int newX = node.x + goX[j];
					int newY = node.y + goY[j];
					
					if(newX < 0 || newX >= M || newY < 0 || newY >= N || visited[newX][newY] || farmland[newX][newY]==0) {
						continue;
					}
					
					queue.add(new Node(newX, newY));
					visited[newX][newY] = true;
			}
				
			
		}
	}
	
	static void dfs(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int newX = x + goX[i];
			int newY = y + goY[i];
			
			if(newX < 0 || newX >= M || newY < 0 || newY >= N || visited[newX][newY] || farmland[newX][newY]==0) {
				continue;
			}
			
			dfs(newX, newY);
			
		}
	}
	
}
