import java.io.*;
import java.util.*;

public class Main {
	static int N, M, cnt, zero;
	static int map[][];
	static int goX[] = {-1, 1, 0, 0};
	static int goY[] = {0, 0, -1, 1};
	static class Node{
		int x;
		int y;
		int day; 
		Node(int x, int y, int day){
			this.x = x;
			this.y = y;
			this.day = day;
		}
	}
	static 	Queue<Node> queue = new LinkedList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		cnt = 0;
		zero = 0;
		
		map = new int[M][N];
		
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 1) {
					queue.offer(new Node(i, j, 0));
				}
			}
		}
		
		BFS();
		Check();
		System.out.println(cnt);	
	}
	static void BFS() {
		cnt = 0;
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			cnt = node.day;
			
			for(int i=0; i<4; i++) {
				int newX = node.x + goX[i];
				int newY = node.y + goY[i];
				
				
				if(newX <0 || newX >= M || newY <0 || newY >= N || map[newX][newY] != 0) {
					continue;
				}
				
				map[newX][newY] = 1;
				queue.offer(new Node(newX, newY, node.day+1));
			}
		}
	}
	static void Check() {
		int num = 0;
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] == 0) {
					num++;
				}
			}
		}
		if(num > 0) {
			cnt = -1;
		}
	}
}
