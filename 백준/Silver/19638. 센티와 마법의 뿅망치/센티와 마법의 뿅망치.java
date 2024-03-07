import java.io.*;
import java.util.*;

public class Main {
	static int N, H, T, cnt;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<>() {
			public int compare(Integer o1, Integer o2) {
				return o2 - o1;
			}
		});
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		H = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		cnt = 0;
		
		for(int i=0; i<N; i++) {
			int giant = Integer.parseInt(br.readLine());
			if(giant >= H) {
				pq.offer(giant);
			}
		}
		
		while(!pq.isEmpty()) {
			int tall = pq.poll();
			cnt++;
			int change = tall/2;
			if(H==1 && change == 1 || tall == 1) {
				pq.offer(1);
			}else if(change >= H ) {
				pq.offer(tall/2);
			}
			
			if(cnt == T) {
				break;
			}
		}
		
		if(!pq.isEmpty()) {
			sb.append("NO").append('\n');
			sb.append(pq.poll());
		}else {
			sb.append("YES").append('\n');
			sb.append(cnt);
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
