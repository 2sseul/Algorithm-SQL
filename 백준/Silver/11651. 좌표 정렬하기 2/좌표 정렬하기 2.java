
import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int[][] map = new int[N][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<2; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		Arrays.sort(map, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				if(o1[1] == o2[1]) {
					return o1[0]-o2[0];
				}
				return o1[1]-o2[1];
			}
			
		});
		
		StringBuilder sb = new StringBuilder();
		for(int i=0; i<N; i++) {
			for(int j=0; j<2; j++) {
				sb.append(map[i][j]);
				if(j!=1) {
					sb.append(" ");
				}
			}
			if(i!=N-1) {
				sb.append('\n');
			}
		}
		
		System.out.println(sb);
	}
}
