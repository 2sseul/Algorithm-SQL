import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
public class Main {
	static int N;
	static int M;
	static int map[][];
	static boolean visited[][];
	public static class Node{
		int x;
		int y;
		int cnt;
		Node(int x, int y, int cnt){
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		
		map = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] =Character.getNumericValue(s.charAt(j));
			}
		}
		
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(0,0,1));
		visited[0][0]=true;
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			if(n.x == N-1 && n.y == M-1) {
				System.out.println(n.cnt);
				return;
			}
			
			int row[] = {-1, 1, 0, 0};
			int col[] = {0, 0, -1, 1};
			
			for(int i=0;i<4;i++) {
				int new_row = n.x + row[i];
				int new_col = n.y + col[i];
				
				if(new_row<0 || new_row>=N || new_col<0 || new_col>=M) {
					continue;
				}
				
				if(map[new_row][new_col]==0 || visited[new_row][new_col]) {
					continue;
				}
				
				
				queue.add(new Node(new_row,new_col,n.cnt+1));
				visited[new_row][new_col] = true;
			}
			
		}
	}
}
