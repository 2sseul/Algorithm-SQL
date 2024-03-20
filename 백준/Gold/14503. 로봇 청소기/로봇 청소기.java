import java.io.*;
import java.util.*;

public class Main {
	static int N, M, ans;
	static int rX, rY, rR;
	static int map[][];
	static int goX[] = {-1, 0, 1, 0};
	static int goY[] = {0, 1, 0, -1};
	static class Robot{
		int x;
		int y;
		int r;
		Robot(int x, int y, int r){
			this.x = x;
			this.y = y;
			this.r = r;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		st = new StringTokenizer(br.readLine());
		rX = Integer.parseInt(st.nextToken());
		rY = Integer.parseInt(st.nextToken());
		rR = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		BFS(rX, rY, rR);
		
		ans = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 2) {
					ans++;
				}
			}
		}
		
		sb.append(ans);
		
		bw.write(sb.toString());bw.flush();bw.close();
		
	}
	static void BFS(int x, int y, int r) {
		Queue<Robot> q = new LinkedList<>();
		q.offer(new Robot(x, y, r));
		map[x][y] = 2;
		
		while(!q.isEmpty()) {
			int clean = 0;
			Robot ro = q.poll();
			int nowX = ro.x;
			int nowY = ro.y;
			int nowR = ro.r;
			int newX, newY, newR;
			for(int i=0; i<4; i++) {
				//nowR을 덮어씌워야 다음 탐색에 적용이 된다.
				nowR = (nowR+3)%4; //반시계방향으로 돌아간다고 했으니까.
				newX = ro.x + goX[nowR];
				newY = ro.y + goY[nowR];
				
				if(newX >=0 || newX < N || newY >=0 || newY < M) {
					if(map[newX][newY] == 0) {
						q.offer(new Robot(newX, newY, nowR));
						map[newX][newY] = 2;
						break;
					}else {
						clean++;
					}
				}
				
			}
			
			if(clean == 4) {
				newR = (ro.r+2)%4;
				newX = ro.x + goX[newR];
				newY = ro.y + goY[newR];
				
				if(map[newX][newY]!=1) {
					q.offer(new Robot(newX, newY, nowR));
					map[newX][newY] = 2;
				}
			}
		}
	}
}
