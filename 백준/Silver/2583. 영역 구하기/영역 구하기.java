import java.io.*;
import java.util.*;

public class Main {
	static int M, N, K, cnt, cntNum;
	static int map[][];
	static boolean visited[][];
	static int goX[] = {-1, 1, 0, 0};
	static int goY[] = {0, 0, -1, 1};
	static StringBuilder sb = new StringBuilder();
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[M][N];
		visited = new boolean[M][N];
		
		for(int i=0; i<K; i++) {
			st = new StringTokenizer(br.readLine());
			int X1 = Integer.parseInt(st.nextToken());
			int X2 = Integer.parseInt(st.nextToken());
			int Y1 = Integer.parseInt(st.nextToken());
			int Y2 = Integer.parseInt(st.nextToken());
			for(int j=X2; j<Y2; j++) {
				for(int k=X1; k<Y1; k++) {
					map[j][k] = 1;
				}
			}
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j] != 1 && !visited[i][j]) {
					cnt++;
					DFS(i, j);
				}
			}
		}
		
		sb.append(cnt).append('\n');
		Count(cnt+1);
		
		System.out.println(sb.toString());
	}
	
	static void DFS(int x, int y) {
		visited[x][y] = true;
		
		map[x][y] = cnt+1;
		
		for(int i=0; i<4; i++) {
			int newX = x + goX[i];
			int newY = y + goY[i];
			
			if(newX < 0 || newX >= M || newY < 0 || newY >=N || map[newX][newY] != 0 || visited[newX][newY]) {
				continue;
			}
			
			DFS(newX, newY);
		}
	}
	
	static void Count(int end) {
		for(int num = 2; num <= end; num++) {
			int count = 0;
			for(int i=0; i<M; i++) {
				for(int j=0; j<N; j++) {
					if(map[i][j]==num) {
						count++;
					}
				}
			}
			list.add(count);
		}
		
		Collections.sort(list);
		
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)+" ");
		}
	}
}
