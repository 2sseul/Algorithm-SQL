import java.io.*;
import java.util.Arrays;

public class Main {
	static int N;
	static String map[][];
	static boolean visited[][];
	static int count[];
	static int cnt, total;
	static int goX[] = {-1,1,0,0};
	static int goY[] = {0,0,-1,1};
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		map = new String[N][N];
		visited = new boolean[N][N];
		
		for(int i=0; i<N; i++) {
			String tmp = br.readLine();
			map[i] = tmp.split("");
		}
		
		total = 0;
		cnt = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j].equals("1") && !visited[i][j]) {
					total++;
					DFS(i,j);
				}
			}
		}
		
		sb.append(total).append('\n');
		
		count = new int[total];
		
		for(int i=1; i<=total; i++) {
			Count(i);
		}
		
		Arrays.sort(count);
		
		for(int i=0; i<total; i++) {
			sb.append(count[i]).append('\n');
		}
		
		System.out.println(sb.toString());
	}
	
	static void DFS(int x, int y) {
		visited[x][y] = true;
		map[x][y] = ""+total;
		
		for(int i=0; i<4; i++) {
			int newX = x + goX[i];
			int newY = y + goY[i];
			
			if(newX < 0 || newX >= N || newY < 0 || newY >= N || map[newX][newY].equals("0") || visited[newX][newY]) {
				continue;
			}
			
			DFS(newX, newY);
		}
	}
	
	static void Count(int x) {
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j].equals(""+x)) {
					count[x-1]++;
				}
			}
		}
	}
}
