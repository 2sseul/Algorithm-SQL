import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int goX[] = {0, 1};
	static int goY[] = {1, 0};
	static int map[][];
	static int visited[][];
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
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visited = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Go();
		
		if(visited[N-1][N-1] == 0) {
			sb.append("Hing");
		}else {
			sb.append("HaruHaru");
		}
		
		bw.write(sb.toString());
		bw.close();
		
	}
	public static void Go() {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(0, 0));
		visited[0][0] = 1;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			for(int i=0; i<2; i++) {
				int newX = n.x + goX[i]*map[n.x][n.y];
				int newY = n.y + goY[i]*map[n.x][n.y];
				
				if(newX < 0 || newX >= N || newY < 0 || newY >= N || visited[newX][newY]!=0) {
					continue;
				}
				
				queue.offer(new Node(newX, newY));
				visited[newX][newY] = visited[n.x][n.y] + 1;
				
				if(newX == N-1 && newY == N-1) {
					return;
				}
			}
		}
	}
}
