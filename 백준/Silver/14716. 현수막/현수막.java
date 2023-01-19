import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static int N,M;
	static int map[][];
	static boolean check[][];
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][M];
		check = new boolean[N][M];
		
		for(int i=0;i<N;i++) {
			st = new StringTokenizer(br.readLine());
			for(int j=0;j<M;j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int cnt = 0;
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(map[i][j]==1 && !check[i][j]) {
					word(i,j);
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
	private static void word(int x, int y) {
		check[x][y] = true;
		 
		int xr[] = {-1,1,0,0,-1,-1,1,1};
		int yc[] = {0,0,-1,1,-1,1,-1,1};
		
		for(int i=0;i<8;i++) {
			int newX = x + xr[i];
			int newY = y + yc[i];
			
			if(newX>=0 && newX<N && newY>=0 && newY<M && map[newX][newY]==1 && !check[newX][newY]) {
				word(newX,newY);
			}
		}
	}
}
