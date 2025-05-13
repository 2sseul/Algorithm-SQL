import java.io.*;
import java.util.*;

public class Main {
	static class Node{
		int now;
		int count;
		Node(int now, int count){
			this.now = now;
			this.count = count;
		}
	}
	static int n;
	static int m;
	static ArrayList<Integer>[] friendship;
	static boolean visited[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		n = Integer.parseInt(br.readLine());
		m = Integer.parseInt(br.readLine());
		
		friendship = new ArrayList[n+1];
		visited = new boolean[n+1];
		for(int i=0; i<n+1; i++) {
			friendship[i] = new ArrayList<>();
		}
				
		int tmp = 0;
		for(int i=0; i<m; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int friend1 = Integer.parseInt(st.nextToken());
			int friend2 = Integer.parseInt(st.nextToken());
			
			friendship[friend1].add(friend2);
			friendship[friend2].add(friend1);
		}
		
		bfs(1, 0);
		
		int answer = 0;
		for(int i=2; i<n+1; i++) {
			if(visited[i]) {
				answer++;
			}
		}
		
		System.out.println(answer);
		
		
	}
	static void bfs(int idx, int cnt) {
		Queue<Node> q = new LinkedList<>();
		q.offer(new Node(idx, cnt));
		visited[idx] = true;
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			
			if(n.count == 2) {
				break;
			}
			
			for(int i=0; i<friendship[n.now].size(); i++) {
				int newIdx = friendship[n.now].get(i);
				if(!visited[newIdx]) {
					q.offer(new Node(newIdx, n.count+1));
					visited[newIdx] = true;
				}
			}
		}
	}
}
