import java.io.*;
import java.util.*;

public class Main {
	static int goX[] = {-2, -2, 0, 0, 2, 2};
	static int goY[] = {-1, 1, -2, 2, -1, 1};
	static int N, ans;
	static boolean visited[][];
	static int startX, startY, endX, endY;
	static class Jump{
		int x;
		int y;
		int cnt;
		Jump(int x, int y, int cnt){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
 	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		ans = 0;
		StringTokenizer st = new StringTokenizer(br.readLine());
		startX = Integer.parseInt(st.nextToken());
		startY = Integer.parseInt(st.nextToken());
		endX = Integer.parseInt(st.nextToken());
		endY = Integer.parseInt(st.nextToken());
		
		visited = new boolean[N][N];
		BFS(startX, startY);
		
		if(ans == 0) {
			sb.append(-1);
		}else {
			sb.append(ans);
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
 	static void BFS(int x, int y) {
 		Queue<Jump> queue = new LinkedList<>();
 		queue.offer(new Jump(x, y, 0));
 		visited[x][y] = true;
 		
 		while(!queue.isEmpty()) {
 			Jump j = queue.poll();
 			
 			if(j.x == endX && j.y == endY) {
 				ans = j.cnt;
 				return;
 			}
 			
 			for(int i=0; i<6; i++) {
 				int newX = j.x + goX[i];
 				int newY = j.y + goY[i];
 				
 				if(newX < 0 || newX >= N || newY < 0 || newY >= N || visited[newX][newY]) {
 					continue;
 				}
 				
 				queue.offer(new Jump(newX, newY, j.cnt+1));
 				visited[newX][newY] = true;
 			}
 		}
 	}
}
