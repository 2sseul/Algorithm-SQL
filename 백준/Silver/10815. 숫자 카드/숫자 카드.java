import java.io.*;
import java.util.*;

public class Main {
	static int N, ans;
	static List<Integer> list = new ArrayList<>();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		ans = 0;
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			list.add(Integer.parseInt(st.nextToken()));
		}
		
		Collections.sort(list);
		
		int M = Integer.parseInt(br.readLine());
		
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int now = Integer.parseInt(st.nextToken());
			
			Search(now, 0, N-1);
			
			sb.append(ans).append(" ");
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
	static void Search(int key, int low, int high) {
		int mid = (high + low) / 2;
		
		if(low <= high) {
			if(key == list.get(mid)) {
				ans = 1;
				return;
			}else if(key < list.get(mid)) {
				Search(key, low, mid-1);
			}else {
				Search(key, mid+1, high);
			}
		}else {
			ans = 0;
			return;
		}
	}
}
