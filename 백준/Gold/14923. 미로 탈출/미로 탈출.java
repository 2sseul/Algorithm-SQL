import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int startX, startY;
	static int outX, outY;
	static int maze[][];
	static boolean visited[][][];
	static class Node{
		int x;
		int y;
		int cnt;
		int destroy;
		Node(int x, int y, int cnt, int destroy) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
			this.destroy = destroy;
		}
	}
	//상하좌우
	static int xR[] = {0,0,-1,1};
	static int yC[] = {-1,1,0,0};
	static int max = Integer.MAX_VALUE;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		startX = Integer.parseInt(st.nextToken());
		startY = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		outX = Integer.parseInt(st.nextToken());
		outY = Integer.parseInt(st.nextToken());
		
		maze = new int[N+1][M+1];
		visited = new boolean[N+1][M+1][2];
		
		for(int i=1;i<=N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=1;j<=M;j++) {
				maze[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		bfs();
		if(max == Integer.MAX_VALUE) {
			System.out.println("-1");
		}else {
			System.out.println(max);
		}
		
	}
	private static void bfs() {
		Deque<Node> queue = new ArrayDeque<>();
		queue.add(new Node(startX, startY, 0, 0));
		visited[startX][startY][0] = true;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			for(int i=0;i<4;i++) {
				int newX = n.x + xR[i];
				int newY = n.y + yC[i];
				
				if(newX<=0 || newX>N || newY<=0 || newY>M) {
					continue;
				}
				if(newX == outX && newY == outY) { 
					max = Math.min(max, n.cnt+1); // 최솟값 갱신
					continue;
				}
				// 벽이고, 아직 벽을 부순 적이 없을 때 
				if(maze[newX][newY] == 1 && n.destroy == 0) { 
					queue.add(new Node(newX, newY, n.cnt+1, 1));
					visited[newX][newY][1] = true;
				} else if(maze[newX][newY] ==0 && !visited[newX][newY][n.destroy]) { 
					queue.add(new Node(newX, newY, n.cnt+1, n.destroy));
					visited[newX][newY][n.destroy] = true;
				}
			}
		}
		
	}
}
