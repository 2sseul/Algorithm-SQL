import java.io.*;
import java.util.*;

public class Main {
	static int N, L;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		int idx = 0;
		long sum = 0;
		boolean flag = false;
		for(int i=L; i<=100; i++) {
			idx = (N/i) - (i-1)/2;
			if(idx < 0) {
				continue;
			}
			for(int j=idx; j<idx+i; j++) {
				sb.append(j).append(" ");
				sum += j;
			}
			if(sum == N) { 
				flag = true;
				break;
			}else {
				sum = 0;
				sb.setLength(0);
				continue;
			}
		}
		
		
		
		if(!flag) {
			sb.append(-1);
		}
		
		bw.write(sb.toString());
		bw.close();
	}
}
