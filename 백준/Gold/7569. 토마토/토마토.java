import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
	static int M;
	static int N;
	static int H;
	static int box[][][];
	static int day;
	static class Node{
		int x;
		int y;
		int z;
		Node(int x, int y, int z){
			this.x = x;
			this.y = y;
			this.z = z;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		Queue<Node> queue = new LinkedList<>();
		StringBuilder sb = new StringBuilder();
		
		M = Integer.parseInt(st.nextToken());	//가로
		N = Integer.parseInt(st.nextToken());	//세로
		H = Integer.parseInt(st.nextToken());	//상자 수
		
		box = new int[H][N][M];
		
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				st = new StringTokenizer(br.readLine());
				for(int k=0;k<M;k++) {
					box[i][j][k]=Integer.parseInt(st.nextToken());
				}
			}
		}
		
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					if(box[i][j][k]==1) {
						queue.add(new Node(i,j,k));
					}
				}
			}
		}
		
		while(!queue.isEmpty()) {
			Node n = queue.poll();
			
			int height[]= {0,0,0,0,-1,1};
			int row[]= {0,0,-1,1,0,0};
			int col[]= {1,-1,0,0,0,0};
			
			for(int i=0;i<6;i++) {
				int new_height = n.x + height[i];
				int new_row = n.y + row[i];
				int new_col = n.z + col[i];
				
				if(new_height<0 || new_height>=H || new_row<0 || new_row>=N || new_col <0 || new_col>=M) {
					continue;
				}
				
				if(box[new_height][new_row][new_col]!=0) {
					continue;
				}
				
				box[new_height][new_row][new_col]=box[n.x][n.y][n.z]+1;
				
				queue.add(new Node(new_height,new_row,new_col));
			}
			
		}
		
		int result = Integer.MIN_VALUE;
		int ans = 0;
		for(int i=0;i<H;i++) {
			for(int j=0;j<N;j++) {
				for(int k=0;k<M;k++) {
					if(box[i][j][k]==0) {
						ans = -1;
					}
					result = Math.max(result, box[i][j][k]);
				}
			}
		}
		if(result == 1) {
			sb.append(0);
		}else {
			if(ans == -1) {
				sb.append(-1);
			}else {
				sb.append(result-1);
			}
		}
		
		System.out.println(sb.toString());
	}
}