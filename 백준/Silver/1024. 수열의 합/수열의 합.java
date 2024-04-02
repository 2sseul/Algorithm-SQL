import java.io.*;
import java.util.*;

public class Main {
	static int N, L;
	static long sum;
	static int cnt, e, s;
	static int min = Integer.MAX_VALUE;
	static StringBuilder sb = new StringBuilder();
	static TreeMap<Integer, int[]> map = new TreeMap<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		
		sum = 0;
		cnt = 0;
		e = 0;
		s = 0;
		
		Check(0, 1);
		
		if(cnt != 0 && min <= 100 && min >= L) {
			int tmp[] = map.get(min);
			Out(tmp[1], tmp[0]);
		}else {
			sb.append(-1);
		}
		
		bw.write(sb.toString());
		bw.close();
		
	}
	static void Check(int start, int end) {
		sum = start + end;
		while(true) {
			if(start >= end) {
				return;
			}
			
			if(sum < N) {
				end++;
				sum += end;
			}else if(sum > N) {
				sum -= start;
				start++;
			}else {
				e = end;
				s = start;
				cnt = end - start + 1;
				int tmp[] = {end, start};
				if(cnt >= L) {
					map.put(cnt, tmp);
					min = Math.min(min, cnt);
				}
				sum -= start;
				start++;
			}
			
		}
	}
	static void Out(int start, int end) {
		for(int i=start; i<=end; i++) {
			sb.append(i).append(" ");
		}
	}
}
