import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static int line;
	static int tmp[][];
	static int map[][];
	static boolean visited[][];
	static int goX[] = {-1, 1, 0, 0};
	static int goY[] = {0, 0, -1, 1};
	static class AVI{
		int x;
		int y;
		AVI(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		tmp = new int[N][M*3];
		map = new int[N][M];
		visited = new boolean[N][M*3];
		
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0; j<M*3; j++) {
				tmp[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		line = Integer.parseInt(br.readLine());
		
		Change();
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j] == 255 && !visited[i][j]) {
					BFS(i, j);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
	}
	static void BFS(int x, int y) {
		Queue<AVI> queue = new LinkedList<>();
		queue.offer(new AVI(x, y));
		
		while(!queue.isEmpty()) {
			AVI a = queue.poll();
			visited[a.x][a.y] = true;
			
			for(int i=0; i<4; i++) {
				int newX = a.x + goX[i];
				int newY = a.y + goY[i];
				
				if(newX < 0 || newX >= N || newY <0 || newY >=M || map[newX][newY] == 0 || visited[newX][newY]) {
					continue;
				}
				
				queue.offer(new AVI(newX, newY));
				visited[newX][newY] = true;
			}
			
		}
	}
	static void Change() {
		for(int i=0; i<N; i++) {
			for(int j=0; j<M*3; j+=3) {
				int sum = 0;
				for(int k=0; k<3; k++) {
					sum += tmp[i][j+k];
				}
				if(sum/3>=line) {
					map[i][j/3] = 255;
				}else {
					map[i][j/3] = 0;
				}
			}
		}
	}
}
