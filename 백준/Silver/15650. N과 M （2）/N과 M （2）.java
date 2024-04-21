import java.io.*;
import java.util.*;

public class Main {
	static int N, M;
	static boolean arr[];
	static int depth;
	static String tmp = "";
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=1; i<=N; i++) {
			arr = new boolean[N+1];
			depth = 1;
			arr[i] = true;
			tmp = i+" ";
			Comb(i, depth, tmp);
		}
		
		bw.write(sb.toString());
		bw.close();
		
	}
	static void Comb(int x, int depth, String tmp) {
		if(depth == M) {
			sb.append(tmp).append('\n');
		}
		for(int i=1; i<=N; i++) {
			if(x < i && !arr[i]) {
				arr[i] = true;
				Comb(i, depth+1, tmp+i+" ");
				arr[i] = false;
			}
		}
		
	}
}
