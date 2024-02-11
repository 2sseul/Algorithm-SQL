import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int m, n;
	static int map[][];
	static boolean visited[][];
	static int cnt;
	static int goX[] = {-1, 1, 0, 0};
	static int goY[] = {0, 0, -1, 1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		m = Integer.parseInt(st.nextToken());
		n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		
		map = new int[m][n];
		visited = new boolean[m][n];
		int answer = Integer.MIN_VALUE;
		
		for(int i=0; i<k; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			map[num1-1][num2-1] = 1;
		}
		
		for(int i=0; i<m; i++) {
			for(int j=0; j<n; j++) {
				if(map[i][j] == 1 && !visited[i][j]) {
					cnt = 1;
					DFS(i, j);
					answer = Math.max(cnt, answer);
					cnt = 0;
				}
			}
		}
		
		sb.append(answer);
		System.out.println(sb.toString());
	}
	static void DFS(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0; i<4; i++) {
			int newX = x + goX[i];
			int newY = y + goY[i];
			
			if(newX<0 || newX >=m || newY<0 || newY>=n || visited[newX][newY] || map[newX][newY] == 0) {
				continue;
			}
			
			cnt++;
			DFS(newX, newY);
		}
	}
}
