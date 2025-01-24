import java.io.*;
import java.util.*;

public class Main {
	static class Tomato{
		int x;
		int y;
		int h;
		int cnt;
		Tomato(int x, int y, int h, int cnt){
			this.x = x;
			this.y = y;
			this.h = h;
			this.cnt = cnt;
		}
	}
	static int M, N, H, min;
	static int moveX[] = {-1, 1, 0, 0, 0, 0};
	static int moveY[] = {0, 0, -1, 1, 0, 0};
	static int moveH[] = {0, 0, 0, 0, -1, 1};
	static int map[][][];
	static Queue<Tomato> q = new LinkedList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		
		map = new int[H][N][M];
		
		for (int i = 0; i < H; i++) { 
		    for (int j = 0; j < N; j++) { 
		        st = new StringTokenizer(br.readLine());
		        for (int k = 0; k < M; k++) { 
		            map[i][j][k] = Integer.parseInt(st.nextToken());
		            if(map[i][j][k] == 1) {
		            	q.offer(new Tomato(j, k, i, 0));
		            }
		        }
		    }
		}
		
		BFS();
		
		int count = Count();
		
		int answer = 0;
		if(count > 0) {
			answer = -1;
		}else {
			answer = min;
		}
		
		System.out.println(answer);
		
	}
	static int Count() {
		int c = 0;
		for(int i = 0; i < H; i++) {
			for(int j = 0; j < N; j++) {
				for(int k = 0; k < M; k++) {
					if(map[i][j][k] == 0) {
						c++;
					}
				}
			}
		}
		return c;
	}
	static void BFS() {
		while(!q.isEmpty()) {
			Tomato t = q.poll();
			
			for(int i=0; i<6; i++) {
				int newX = moveX[i] + t.x;
				int newY = moveY[i] + t.y;
				int newH = moveH[i] + t.h;
				
				if(newX < 0 || newX >= N || newY < 0 || newY >= M || newH < 0 || newH >= H || map[newH][newX][newY] == -1 || map[newH][newX][newY] == 1) {
					continue;
				}
				
				map[newH][newX][newY] = 1;
				
				q.offer(new Tomato(newX, newY, newH, t.cnt + 1));
			}
			
			min = Math.max(min, t.cnt);
		}
	}
}
