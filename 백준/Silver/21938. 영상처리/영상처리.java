import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static int N, M;
	static int video[][];
	static boolean visited[][];
	static int standard;
	static int moveR[] = {-1,1,0,0};
	static int moveC[] = {0,0,-1,1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken())*3;
		
		video = new int[N][M];
		visited = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				video[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		standard = Integer.parseInt(br.readLine());
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M-2;j+=3) {
				int rgb = (video[i][j]+video[i][j+1]+video[i][j+2])/3;
				if(rgb < standard) {
					video[i][j]=0;
					video[i][j+1]=0;
					video[i][j+2]=0;
				}else {
					video[i][j]=255;
					video[i][j+1]=255;
					video[i][j+2]=255;
				}
			}
		}
		
		
		int cnt =0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(video[i][j]==255 && !visited[i][j]) {
					count(i,j);
					cnt++;
				}
			}
		}
		
		System.out.println(cnt);
		
	}
	private static void count(int x, int y) {
		visited[x][y] = true;
		
		for(int i=0;i<4;i++) {
			int newX = x + moveR[i];
			int newY = y + moveC[i];
			
			if(newX<0 || newX>=N || newY<0 || newY>=M || visited[newX][newY] || video[newX][newY]==0) {
				continue;
			}
			
			if(video[newX][newY]==255 && !visited[newX][newY]) {				
				visited[newX][newY] = true;
				count(newX,newY);
			}
		}
		
	}
	
}
