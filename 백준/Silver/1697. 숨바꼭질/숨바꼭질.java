import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int map[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[100001];
		
		BFS(N);
		
		if(N == K) {
			sb.append("0");
		}else {
			sb.append(map[K]);
		}
		
		System.out.println(sb.toString());
	}
	static void BFS(int start) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(start);
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			int newX = 0;
			
			for(int i=0; i<3; i++) {
				if(i == 0) {
					newX = tmp + 1;
				}else if(i == 1) {
					newX = tmp - 1;
				}else {
					newX = tmp*2;
				}
				
				if(newX == K) {
					map[newX] = map[tmp] + 1; 
					return;
				}
				
				if(newX < 0 || newX >= 100001 || map[newX] != 0) {
					continue;
				}
				
				map[newX] = map[tmp] + 1;
				queue.offer(newX);
				
			}
		}
	}
}
