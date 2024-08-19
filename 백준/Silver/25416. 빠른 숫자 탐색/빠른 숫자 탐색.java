import java.io.*;
import java.util.*;

public class Main {
	static int map[][] = new int[5][5];
	static int moveX[] = {-1, 0, 1, 0};
	static int moveY[] = {0, 1, 0, -1};
	static int nowX, nowY;
	static int answer = 0;
	static int visited[][] = new int[5][5];
	static class Node{
		int x;
		int y;
		int cnt;
		Node(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		nowX = Integer.parseInt(st.nextToken());
		nowY = Integer.parseInt(st.nextToken());
		
		Move(nowX, nowY);
		
		if(answer == 0) {
			answer = -1;
		}
		
		System.out.println(answer);
		
	}
	static void Move(int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(x, y, 0));
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(map[n.x][n.y] == 1) {
				answer = n.cnt;
				return;
			}
			for(int i=0; i<4; i++) {
				int newX = n.x + moveX[i];
				int newY = n.y + moveY[i];
				
				if(newX < 0 || newX >= 5 || newY < 0 || newY >= 5 || visited[newX][newY] != 0 || map[newX][newY] == -1) {
					continue;
				}
				
				visited[newX][newY] = n.cnt + 1;
				q.offer(new Node(newX, newY, n.cnt + 1));
			}
		}
	}
}
