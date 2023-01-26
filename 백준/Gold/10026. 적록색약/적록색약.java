import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	static int N;
	static char map[][];
	static char mapRG[][];
	static boolean visited[][];
	static boolean visitedRG[][];
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		map = new char[N][N];
		mapRG = new char[N][N];
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			map[i] = s.toCharArray();
			mapRG[i] = s.toCharArray();
		}
		
		visited = new boolean[N][N];
		
		int cnt = 0;
		int count = 0;
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j]=='R'&&!visited[i][j]) {
					pillR(i,j);
					cnt++;
				}
				if(map[i][j]=='G'&&!visited[i][j]) {
					pillG(i,j);
					cnt++;
				}
				if(map[i][j]=='B'&&!visited[i][j]) {
					pillB(i,j);
					cnt++;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(mapRG[i][j]=='G') {
					mapRG[i][j]='R';
				}
			}
		}
		
		visitedRG = new boolean[N][N];
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(mapRG[i][j]=='R'&&!visitedRG[i][j]) {
					pillRG(i,j);
					count++;
				}
				if(mapRG[i][j]=='B'&&!visitedRG[i][j]) {
					pillRGB(i,j);
					count++;
				}
			}
		}
		
		System.out.println(cnt+" "+count);
		
		
	}

	private static void pillRG(int x, int y) {
		visitedRG[x][y] = true;
		
		int xr[] = {-1,1,0,0};
		int yc[] = {0,0,-1,1};
		
		for(int i=0;i<4;i++) {
			int newR = x + xr[i];
			int newC = y + yc[i];
			
			if(newR>=0 && newR<N && newC>=0 && newC<N) {
				if(mapRG[newR][newC]=='R'&&!visitedRG[newR][newC]) {
					pillRG(newR,newC);
				}
			}
		}
		
	}
	
	private static void pillRGB(int x, int y) {
		visitedRG[x][y] = true;
		
		int xr[] = {-1,1,0,0};
		int yc[] = {0,0,-1,1};
		
		for(int i=0;i<4;i++) {
			int newR = x + xr[i];
			int newC = y + yc[i];
			
			if(newR>=0 && newR<N && newC>=0 && newC<N) {
				if(mapRG[newR][newC]=='B'&&!visitedRG[newR][newC]) {
					pillRGB(newR,newC);
				}
			}
		}
		
	}
	
	private static void pillR(int x, int y) {
		visited[x][y] = true;
		
		int xr[] = {-1,1,0,0};
		int yc[] = {0,0,-1,1};
		
		for(int i=0;i<4;i++) {
			int newR = x + xr[i];
			int newC = y + yc[i];
			
			if(newR>=0 && newR<N && newC>=0 && newC<N) {
				if(map[newR][newC]=='R'&&!visited[newR][newC]) {
					pillR(newR,newC);
				}
			}
		}
		
	}
	
	private static void pillG(int x, int y) {
		visited[x][y] = true;
		
		int xr[] = {-1,1,0,0};
		int yc[] = {0,0,-1,1};
		
		for(int i=0;i<4;i++) {
			int newR = x + xr[i];
			int newC = y + yc[i];
			
			if(newR>=0 && newR<N && newC>=0 && newC<N) {
				if(map[newR][newC]=='G'&&!visited[newR][newC]) {
					pillG(newR, newC);
				}
			}
		}
		
	}
	private static void pillB(int x, int y) {
		visited[x][y] = true;
		
		int xr[] = {-1,1,0,0};
		int yc[] = {0,0,-1,1};
		
		for(int i=0;i<4;i++) {
			int newR = x + xr[i];
			int newC = y + yc[i];
			
			if(newR>=0 && newR<N && newC>=0 && newC<N) {
				if(map[newR][newC]=='B'&&!visited[newR][newC]) {
					pillB(newR,newC);
				}
			}
		}
		
	}
}
