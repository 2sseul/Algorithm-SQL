import java.io.*;
import java.util.*;

public class Main {
	static int N, K;
	static int answer = Integer.MAX_VALUE;
	static boolean visited[];
	static class Move{
		int x;
		int cnt;
		Move(int x, int cnt){
			this.x = x;
			this.cnt = cnt;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		visited = new boolean[100001];
		
		BFS();
		
		System.out.println(answer);
		
	}
	static void BFS() {
		Queue<Move> queue = new LinkedList<>();
		queue.offer(new Move(N, 0));
		
		while(!queue.isEmpty()) {
			Move m = queue.poll();
			visited[m.x] = true;
			
			if(m.x == K) {
				answer = Math.min(answer, m.cnt);
				return;
			}
			
			if(m.x * 2 <= 100000 && !visited[m.x * 2]) {
				queue.offer(new Move(m.x*2, m.cnt));
			}
			if(m.x -1 >= 0 && !visited[m.x -1]) {
				queue.offer(new Move(m.x -1, m.cnt+1));
			}
			if(m.x + 1 <= 100000 && !visited[m.x + 1]) {
				queue.offer(new Move(m.x +1, m.cnt+1));
			}
		}
	}
}
