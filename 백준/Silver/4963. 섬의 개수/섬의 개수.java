import java.io.*;
import java.util.*;

public class Main {
	static int w, h, cnt;
	static int[][] map;
	static boolean[][] visited;
	//8방탐색 
	static int goX[] = {-1, -1, -1, 0, 0, 1, 1, 1};
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
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			w = Integer.parseInt(st.nextToken());
			h = Integer.parseInt(st.nextToken());
			
			//System.out.println(w+" "+h);
			
			map = new int[h][w];
			visited = new boolean[h][w];
			cnt = 0;
			
			if(w == 0 && h == 0) {
				break;
			}
			
			for(int i=0; i<h; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<w; j++) {
					map[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			for(int i=0; i<h; i++) {
				for(int j=0; j<w; j++) {
					if(map[i][j] == 1 && !visited[i][j]) {
						//BFS(i,j);
						DFS(i,j);
						cnt++;
					}
				}
			}
			
			sb.append(cnt).append('\n');
			
		}
		
		System.out.println(sb.toString());
		
	}
	
	static void BFS(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y));
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			
			for(int i=0; i<8; i++) {
				int newX = node.x + goX[i];
				int newY = node.y + goY[i];
				
				if(newX < 0 || newX >= h || newY < 0 || newY >= w || visited[newX][newY] || map[newX][newY] == 0) {
					continue;
				}
				
				queue.add(new Node(newX, newY));
				visited[newX][newY] = true;
				
			}
		}
	}
	
	static void DFS(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<8; i++) {
			int newX = x + goX[i];
			int newY = y + goY[i];
			
			if(newX < 0 || newX >= h || newY < 0 || newY >= w || visited[newX][newY] || map[newX][newY] == 0) {
				continue;
			}
			
			DFS(newX, newY);
		}
	}
}
