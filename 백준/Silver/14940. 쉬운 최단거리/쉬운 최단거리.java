import java.io.*;
import java.util.*;

public class Main {
	static int n, m, endX, endY, startX, startY;
	static int map[][];
	static int visited[][];
	static int goX[] = {-1, 1, 0, 0};
	static int goY[] = {0, 0, -1, 1};
	static class Short{
		int x;
		int y;
		Short(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		
		map = new int[n][m];
		visited = new int[n][m];
		
		for(int i=0; i<n; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<m; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j] == 2) {
					startX = i;
					startY = j;
				}
			}
		}
		
		BFS(startX, startY);
		visited[startX][startY] = 0;
		
		for(int i=0; i<n; i++) {
			for(int j=0; j<m; j++) {
				if(map[i][j] == 1 && visited[i][j] == 0) {
					visited[i][j] = -1;
				}
				sb.append(visited[i][j]).append(" ");
			}
			sb.append('\n');
		}
		
		System.out.println(sb.toString());
		
	}
	static void BFS(int x, int y) {
		Queue<Short> queue = new LinkedList<>();
		queue.offer(new Short(x, y));
		
		while(!queue.isEmpty()){
			Short s = queue.poll();
			
			for(int i=0; i<4; i++) {
				int newX = s.x + goX[i];
				int newY = s.y + goY[i];
				
				if(newX <0 || newX >=n || newY <0 || newY >= m || map[newX][newY] == 0 || visited[newX][newY]!=0) {
					continue;
				}
				
				visited[newX][newY] = visited[s.x][s.y]+1;
				queue.offer(new Short(newX, newY));
			}
		}
	}
}
