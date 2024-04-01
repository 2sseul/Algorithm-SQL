import java.io.*;
import java.util.*;

public class Main {
	static int arr[];
	static int ans[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<>() {
			public int compare(int o1[], int o2[]) {
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
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N];
		ans = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			int tmp[] = {arr[i], i};
			pq.offer(tmp);
		}
		
		for(int i=0; i<N; i++) {
			int tmp[] = pq.poll();
			ans[tmp[1]] = i;
		}
		
		for(int i=0; i<N; i++) {
			sb.append(ans[i]).append(" ");
		}
		
		bw.write(sb.toString());
		bw.close();
		
	}
}
