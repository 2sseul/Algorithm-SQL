import java.io.*;
import java.util.*;

public class Main {
	static int L, R, C, ans;
	static char map[][][];
	static boolean visited[][][];
	static StringBuilder sb = new StringBuilder();
	//상하좌우 위층 아래층
	static int moveF[] = {0, 0, 0, 0, -1, 1};
	static int moveR[] = {-1, 1, 0, 0, 0, 0};
	static int moveC[] = {0, 0, -1, 1, 0, 0};
	static class Node{
		int f;
		int x;
		int y;
		int cnt;
		Node(int f, int x, int y, int cnt){
			this.f = f;
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			L = Integer.parseInt(st.nextToken()); //층수
			R = Integer.parseInt(st.nextToken()); //행
			C = Integer.parseInt(st.nextToken()); //열
			ans = 0;
						
			if(L == 0 && R == 0 && C == 0) {
				break;
			}
			
			map = new char[L][R][C];
			visited = new boolean[L][R][C];
			
			//map 셋팅
			int floor = 0;
			int c = 0;
			while(true) {
				String tmp = br.readLine();
				if(tmp.length() == 0) {
					if(floor == L) {
						break;
					}
					continue;
				}
				if(c == R-1) {
					map[floor][c] = tmp.toCharArray();
					floor++;
					c = 0;
					continue;
				}
				map[floor][c] = tmp.toCharArray();
				c++;
			}
			
			//시작점 찾기
			for(int i=0; i<L; i++) {
				for(int j=0; j<R; j++) {
					for(int k=0; k<C; k++) {
						if(map[i][j][k] == 'S') {
							Escape(i, j, k);
						}else {
							continue;
						}
					}
				}
			}
			
			if(ans > 0) {
				sb.append("Escaped in ").append(ans).append(" minute(s).").append('\n');
			}else {
				sb.append("Trapped!").append('\n');
			}
		}
		bw.write(sb.toString());
		bw.close();
	}
	public static void Escape(int f, int x, int y) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(f, x, y, 0));
		visited[f][x][y] = true;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			if(map[n.f][n.x][n.y] == 'E') {
				ans = n.cnt;
			}
			
			for(int i=0; i<6; i++) {
				int newF = moveF[i] + n.f;
				int newX = moveR[i] + n.x;
				int newY = moveC[i] + n.y;
				
				if(newF >= L || newF < 0 || newX >= R || newX < 0 || newY >= C || newY < 0 
						|| map[newF][newX][newY] == '#' || visited[newF][newX][newY]) {
					continue;
				}
				
				visited[newF][newX][newY] = true;
				q.offer(new Node(newF, newX, newY, n.cnt + 1));
			}
		}
	}
}
