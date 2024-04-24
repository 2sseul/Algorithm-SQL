import java.io.*;
import java.util.*; 

public class Main {
	static int goX[] = {0, 1, 1};
	static int goY[] = {1, 0, 1};
	static int N, M;
	static char arr[][];
	static int map[][];
	static boolean visited[][];
	static int max = 0;
	static int NN = Integer.MAX_VALUE;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		NN = Math.min(N, Math.min(NN, M));
		
		arr = new char[N][M];
		map = new int[N][M];
		
		for(int i=0; i<N; i++) {
			String tmp = br.readLine();
			arr[i] = tmp.toCharArray();
			for(int j=0; j<M; j++) {
				map[i][j] = (int) arr[i][j] -'0';
			}
		}
		
		visited = new boolean[N][M];
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				Check(map[i][j], i, j);
			}
		}
		
		sb.append((max+1)*(max+1));
		bw.write(sb.toString());
		bw.close();
	}
	static void Check(int num, int x, int y) {
		for(int i=1; i<NN; i++) {
			int newX1 = x+goX[0]*i;
			int newY1 = y+goY[0]*i;
			int newX2 = x+goX[1]*i;
			int newY2 = y+goY[1]*i;
			int newX3 = x+goX[2]*i;
			int newY3 = y+goY[2]*i;
			
			if(newY1 < M && newX2 < N && newX3 < N && newY3 < M) {
				if(map[newX1][newY1] == num && map[newX2][newY2] == num && map[newX3][newY3] == num) {
					max = Math.max(max, i);
				}else {
					continue;
				}
			}else {
				continue;
			}
		}
	}
}
