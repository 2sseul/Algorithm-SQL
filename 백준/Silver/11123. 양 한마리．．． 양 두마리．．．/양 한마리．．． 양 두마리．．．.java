import java.util.*;
import java.io.*;

public class Main {
	static int T, H, W;
	static char map[][];
	static boolean visited[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		T = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			H = Integer.parseInt(st.nextToken());
			W = Integer.parseInt(st.nextToken());
			
			map = new char[H][W];
			visited = new boolean[H][W];
			
			for(int i=0;i<H;i++) {
				String s = br.readLine();
				map[i] = s.toCharArray();
			}
			
			int cnt = 0;
			for(int i=0;i<H;i++) {
				for(int j=0;j<W;j++) {
					if(map[i][j]=='#'&&!visited[i][j]) {
						visited[i][j]=true;
						dfs(i,j);
						cnt++;
					}
				}
			}
			sb.append(cnt);
			sb.append('\n');
		}
		System.out.println(sb.toString());
		
	}
	private static void dfs(int x, int y) {
		//00 01 02
		//10 11 12
		//왼오위아래 
		int xR[] = {0,0,-1,1};
		int yC[] = {-1,1,0,0};
		
		for(int i=0;i<4;i++) {
			int newX = x + xR[i];
			int newY = y + yC[i];
			
			if(newX<0 || newX>=H || newY<0 || newY>=W || map[newX][newY]=='.' || visited[newX][newY]) {
				continue;
			}
			
			if(map[newX][newY]=='#'&&!visited[newX][newY]) {
				visited[newX][newY] = true;
				dfs(newX,newY);
			}
			
		}
		
	}
}
