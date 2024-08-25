import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());
		
		int map[] = new int[D+1];
		for(int i=0; i<D+1; i++) {
			map[i] = i;
		}
		
		int road[][] = new int[N][3];
		for(int i=0; i<N; i++) {
			st = new StringTokenizer(br.readLine());
			road[i][0] = Integer.parseInt(st.nextToken());
			road[i][1] = Integer.parseInt(st.nextToken());
			road[i][2] = Integer.parseInt(st.nextToken());
		}
		
		for(int i=1; i<D+1; i++) {
			map[i] = Math.min(map[i], map[i-1]+1);
			for(int j=0; j<N; j++) {
				if(road[j][1] == i) {
					map[i] = Math.min(map[i], map[road[j][0]]+road[j][2]);
				}
			}
		}
		
		sb.append(map[D]);
		bw.append(sb.toString());
		bw.close();
	}
}
