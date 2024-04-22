import java.io.*;
import java.util.*;

public class Main {
	static int N, M, sum;
	static int whiteSoldier = 0;
	static int blueSoldier = 0;
	static boolean visited[][];
	static char map[][];
	static int goX[] = {-1, 1, 0, 0};
	static int goY[] = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new char[M][N];
		visited = new boolean[M][N];
		
		for(int i=0; i<M; i++) {
			String tmp = br.readLine();
			map[i] = tmp.toCharArray();
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j]=='W' && !visited[i][j]) {
					sum = 1;
					Check(i, j, 'W');
					whiteSoldier += (sum*sum);
				}
				
				if(map[i][j]=='B' && !visited[i][j]) {
					sum = 1;
					Check(i, j, 'B');
					blueSoldier += (sum*sum);
				}
			}
		}
		
		sb.append(whiteSoldier).append(" ").append(blueSoldier);
		bw.write(sb.toString());
		bw.close();
	}
	static void Check(int x, int y, char color) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int newX = x + goX[i];
			int newY = y + goY[i];
			
			if(newX < 0 || newX >=M || newY < 0 || newY >=N || visited[newX][newY] || map[newX][newY]!=color) {
				continue;
			}
			
			sum++;
			Check(newX, newY, color);
		}
	}
}
