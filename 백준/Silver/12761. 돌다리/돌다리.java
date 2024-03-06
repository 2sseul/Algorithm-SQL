import java.io.*;
import java.util.*;

public class Main {
	static int A, B, N, M, ans;
	static boolean visited[] = new boolean[100001];
	static class Jump{
		int x;
		int cnt;
		Jump(int x, int cnt){
			this.x = x;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		A = Integer.parseInt(st.nextToken());
		B = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		ans = 0;
		
		BFS(N);
		
		System.out.println(ans);
	}
	static void BFS(int x) {
		Queue<Jump> queue = new LinkedList<>();
		queue.offer(new Jump(x, 0));
		visited[x] = true;
		
		while(!queue.isEmpty()) {
			Jump j = queue.poll();
			int now = j.x;
			int newX = 0;
			
			int arr[] = {now-1, now+1, now+A, now+B, now-A, now-B, now*A, now*B};
			
			if(now == M) {
				ans = j.cnt;
				return;
			}
			
			for(int i=0; i<8; i++) {
				newX = arr[i];
				
				if(newX < 0 || newX >= 100001 || visited[newX]) {
					continue;
				}
				
				queue.offer(new Jump(newX, j.cnt+1));
				visited[newX] = true;
			}
		}
	}
}
