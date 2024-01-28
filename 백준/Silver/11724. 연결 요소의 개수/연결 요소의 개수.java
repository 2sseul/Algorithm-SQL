import java.io.*;
import java.util.*;

public class Main {
	static int computers, lines;
	static int map[][];
	static boolean visited[];
	static int cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		computers = Integer.parseInt(st.nextToken());
		lines = Integer.parseInt(st.nextToken());
		
		map = new int[computers][computers];
		visited = new boolean[computers];
		
		for(int i=0; i<lines; i++) {
			st = new StringTokenizer(br.readLine());
			int num1 = Integer.parseInt(st.nextToken());
			int num2 = Integer.parseInt(st.nextToken());
			map[num1 -1][num2 -1] = 1;
			map[num2 -1][num1 -1] = 1;
		}
		
		for(int i=0; i<computers; i++) {
			if(!visited[i]) {
				DFS(i);
				cnt++;
			}
		}
		
		System.out.println(cnt);
	}
	static void DFS(int i) {
		visited[i] = true;
		
		for(int j=0; j<computers; j++) {
			if(!visited[j] && map[i][j] == 1) {
				DFS(j);
			}
		}
	}
}
