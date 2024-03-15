import java.io.*;
import java.util.*;

public class Main {
	static List<Integer> list = new ArrayList<>();
	static int ans;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			list.clear();
			
			int M = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i=0; i<M; i++) {
				list.add(Integer.parseInt(st.nextToken()));
			}
			
			Collections.sort(list);	
			
			int N = Integer.parseInt(br.readLine());
			st = new StringTokenizer(br.readLine());
			for(int i=0; i<N; i++) {
				ans = 0;
				int now = Integer.parseInt(st.nextToken());
				Check(now, 0, M-1);
				sb.append(ans).append('\n');
			}
		}
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	static void Check(int key, int low, int high) {
		while(true) {
			if(low<=high) {
				int mid = (low + high)/2;
				if(key == list.get(mid)) {
					ans = 1;
					return;
				}else if(key < list.get(mid)) {
					high = mid-1;
				}else {
					low = mid+1;
				}
			}else {
				ans = 0;
				return;
			}
		}
	}
}
