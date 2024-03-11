import java.io.*;
import java.util.*;

public class Main {
	static int N, ans;
	static HashMap<Integer, Integer> map = new HashMap<>();
	static StringBuilder sb = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(!map.containsKey(num)) {
				map.put(num, 1);
			}else {
				map.put(num, map.get(num)+1);
			}
		}
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			ans = 0;
			int now = Integer.parseInt(st.nextToken());
			if(map.containsKey(now)) {
				sb.append(map.get(now)).append(" ");
			}else {
				sb.append(0).append(" ");
			}
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
}
