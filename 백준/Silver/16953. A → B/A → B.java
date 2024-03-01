import java.io.*;
import java.util.*;

public class Main {
	static boolean visited[];
	static int N, M, ans;
	static class Node{
		int x;
		int cnt;
		Node(int x, int cnt){
			this.x = x;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		visited = new boolean[1000000001];
		ans = 0;
		
		BFS(M, 0);
		
		if(ans == 0) {
			sb.append(-1);
		}else {
			sb.append(ans+1);
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
	}
	static void BFS(int x, int count) {
		Queue<Node> queue = new LinkedList<>();
		queue.offer(new Node(x, count));
		visited[x] = true;
		
		while(!queue.isEmpty()){
			Node n = queue.poll();
			if(n.x == N) {
				ans = n.cnt;
				return;
			}
			int newX = 0;
			if(n.x % 2 == 0) {
				newX = n.x / 2;
			}
			
			if(n.x % 10 == 1) {
				newX = n.x / 10;
			}
			
			if(newX < 0 || visited[newX]) {
				continue;
			}
			
			queue.offer(new Node(newX, n.cnt+1));
			visited[newX] = true;
		}
	}
}
