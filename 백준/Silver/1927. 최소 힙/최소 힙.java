import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		StringBuilder sb = new StringBuilder();
		
		int x = Integer.parseInt(br.readLine());
		
		for(int tc = 0; tc < x; tc++) {
			int now = Integer.parseInt(br.readLine());
			
			if(now == 0) {
				if(pq.isEmpty()) {
					sb.append(0).append('\n');
				}else {
					int tmp = pq.poll();
					sb.append(tmp).append('\n');
				}
			}else {
				pq.offer(now);
			}
		}
		
		System.out.println(sb.toString());
	}
}
