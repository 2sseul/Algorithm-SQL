import java.io.*;
import java.util.*;

public class Main {
	static class Move{
		int x;
		int cnt;
		Move(int x, int cnt){
			this.x = x;
			this.cnt = cnt;
		}
	}
	static int family_count;
	static ArrayList<Integer>[] family;
	static boolean[] visited;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	
		family_count = Integer.parseInt(br.readLine())+1;
		family = new ArrayList[family_count];
		visited = new boolean[family_count];
		for(int i=0; i<family_count; i++) {
			family[i] = new ArrayList<>();
		}
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		int person1 = Integer.parseInt(st.nextToken());
		int person2 = Integer.parseInt(st.nextToken());
		
		int chonsu = Integer.parseInt(br.readLine());
		
		for(int i=0; i<chonsu; i++) {
			st = new StringTokenizer(br.readLine());
			int parent = Integer.parseInt(st.nextToken());
			int child = Integer.parseInt(st.nextToken());
		
			family[parent].add(child);
			family[child].add(parent);
		}
		
		int answer = BFS(person1, person2);
		System.out.println(answer);
	}
	static int BFS(int start, int end) {
		Queue<Move> q = new LinkedList<>();
		q.offer(new Move(start, 0));
		visited[start] = true;
		int cnt = 999;
		
		while(!q.isEmpty()) {
			Move m = q.poll();
			
 			if(m.x == end) {
				cnt = Math.min(cnt, m.cnt);
				return cnt;
			}
			
			for(int i=0; i<family[m.x].size(); i++) {
				if(!visited[family[m.x].get(i)]) {
					visited[family[m.x].get(i)] = true;
					q.offer(new Move(family[m.x].get(i), m.cnt+1));
				}
			}
		}
		
		return -1;
	}
}
