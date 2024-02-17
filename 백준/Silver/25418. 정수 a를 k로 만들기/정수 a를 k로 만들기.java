import java.io.*;
import java.util.*;

public class Main {
	static int A, K;
	static int map[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new int[1000001];
		
		BFS(A);
		
		System.out.println(map[K]);
	}
	
	static void BFS(int x) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(x);
		
		while(!queue.isEmpty()) {
			int tmp = queue.poll();
			int newX = 0;
			
			for(int i=0; i<2; i++) {
				if(i==0) {
					newX = tmp + 1;
				}else {
					newX = tmp * 2;
				}
				
				if(newX >= 1000001 || map[newX] != 0) {
					continue;
				}
				
				map[newX] = map[tmp] + 1;
				queue.add(newX);
			}
		}
	}
}
