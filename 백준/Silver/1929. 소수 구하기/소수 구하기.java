import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		//false가 소수.
		boolean sosu[] = new boolean[1000001];
		sosu[0] = true;
		sosu[1] = true;
		
		for(int i=1; i*i<1000001; i++) {
			if(!sosu[i]) {
				for(int j= i*i; j < 1000001; j+=i) {
					sosu[j] = true;
				}
			}
		}
		
		for(int i=N; i<=M; i++) {
			if(!sosu[i]) {
				sb.append(i).append('\n');
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
