import java.io.*;
import java.util.*;

public class Main {
	static StringBuilder sb = new StringBuilder();
	static int N, M;
	static int tmp[];
	static boolean arr[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		tmp = new int[M];
		arr = new boolean[N+1];
		
		Check(0, 1);
		
		bw.write(sb.toString());
		bw.close();
	}
	static void Check(int depth, int start) {
		if(depth == M) {
			String ans = "";
			for(int i=0; i<M; i++) {
				if(i == M-1) {
					ans += tmp[i];
					sb.append(ans).append('\n');
				}else {
					ans += tmp[i]+" ";
				}
			}
			return;
		}
		for(int i=start; i<=N; i++) {
			if(i < start) {
				continue;
			}else {
				tmp[depth] = i;
				Check(depth+1, i);
			}
		}
	}
}
