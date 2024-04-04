import java.io.*;
import java.util.*;

public class Main {
	static int N;
	static int arr[];
	static boolean visited[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		
		arr = new int[1000001];
		visited = new boolean[1000001];
		
		Go(N);
		
		System.out.println(arr[1]);
		
	}
	static void Go(int N) {
		Queue<Integer> queue = new LinkedList<>();
		queue.offer(N);
		visited[N] = true;
		
		while(!queue.isEmpty()) {
			int now = queue.poll();
			int tmp = 0;
			for(int i=0; i<3; i++) {
				if(i == 0) {
					if(now%3 == 0) {
						tmp = now / 3;
					}else {
						continue;
					}
				}else if(i == 1) {
					if(now%2 == 0) {
						tmp = now / 2;
					}else {
						continue;
					}
				}else {
					tmp = now - 1;
				}
				
				if(tmp < 0 || visited[tmp]) {
					continue;
				}
				
				arr[tmp] = arr[now] + 1;
				queue.offer(tmp);
				visited[tmp] = true;
			}
		}
 		
	}
}
