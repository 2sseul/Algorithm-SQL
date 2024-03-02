import java.io.*;
import java.util.*;


public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>() {
			
			public int compare(int[] o1, int[] o2) {
				if(o1[0] < o2[0]) {
					return -1;
				}else if(o1[0] > o2[0]) {
					return 1;
				}else {
					if(o1[1] < o2[1]) {
						return -1;
					}else if(o1[1] > o2[1]) {
						return 1;
					}else {
						return 0;
					}
				}
			}
		});
		
		int N = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<N; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			int[] tmp = {x, y};
			
			pq.offer(tmp);
		}
		
		while(!pq.isEmpty()) {
			int[] now = pq.poll();
			sb.append(now[0]+" "+now[1]).append('\n');
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
