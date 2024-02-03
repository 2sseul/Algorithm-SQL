import java.util.*;
import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		String map[][] = new String[N][M];
		boolean check[][][] = new boolean[N][M][2];
		
		for(int i=0; i<N; i++) {
			String tmp = br.readLine();
			map[i] = tmp.split("");
		}
		
		int cntX = 0;
		int cntY = 0;
		
		//가로체크 
		for(int i=0; i<N; i++) {
			for(int j=0; j<M; j++) {
				if(map[i][j].equals("X")) {
					cntX++;
					break;
				}
			}
		}
		
		for(int i=0; i<M; i++) {
			for(int j=0; j<N; j++) {
				if(map[j][i].equals("X")) {
					cntY++;
					break;
				}
			}
		}
		
		//System.out.println(Arrays.deepToString(check));
		System.out.println(Math.max(N-cntX, M-cntY));
	}
}
