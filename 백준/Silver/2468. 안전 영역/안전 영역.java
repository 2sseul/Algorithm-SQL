import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int map[][];
	static boolean visited[][];
	static int maxNum = Integer.MIN_VALUE;
	static int goX[] = {-1, 1, 0, 0};
	static int goY[] = {0, 0, -1, 1};
	static int waterfull = 0;
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
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				waterfull = Math.max(waterfull, map[i][j]);
			}
		}
		
		for(int num = 1; num <=waterfull; num++) {
			visited = new boolean[N][N];
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]>=num && !visited[i][j]) {
						DFS(i, j, num);
						//BFS(i, j, num);
						cnt++;
						maxNum = Math.max(maxNum, cnt);
					}
				}
			}
			cnt = 0;
		}
		
		
		System.out.println(maxNum);
		
	}
	
	static void DFS(int x, int y, int num) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int newX = x + goX[i];
			int newY = y + goY[i];
			
			if(newX < 0 || newX >= N || newY < 0 || newY >= N || map[newX][newY] < num || visited[newX][newY]) {
				continue;
			}
			
			DFS(newX, newY, num);
		}
	}
	
	static void BFS(int x, int y, int num) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x,y));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			visited[node.x][node.y] = true;
			
			for(int i=0; i<4; i++) {
				int newX = node.x + goX[i];
				int newY = node.y + goY[i];
				
				if(newX < 0 || newX >= N || newY < 0 || newY >= N || map[newX][newY] < num || visited[newX][newY]) {
					continue;
				}
				
				queue.add(new Node(newX, newY));
				visited[newX][newY] = true;
				
			}
		}
	}
}
