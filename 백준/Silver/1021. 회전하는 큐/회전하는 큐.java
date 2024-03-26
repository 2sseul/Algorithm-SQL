import java.io.*;
import java.util.*;

public class Main {
	static int N, M, first, ans;
	static int arr[];
	static List<Integer> list = new ArrayList<>();
	static int visited[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		first = 0;
		ans = 0;
		
		arr = new int[M];
		st = new StringTokenizer(br.readLine());
		for(int i=0; i<M; i++) {
			int tmp = Integer.parseInt(st.nextToken());
			arr[i] = tmp;
		}
		
		for(int i=1; i<=N; i++) {
			list.add(i);
		}
		
		for(int i=0; i<M; i++) {
			visited = new int[list.size()];
			Move(arr[i]);
		}
		
		sb.append(ans);
		bw.write(sb.toString());
		bw.close();
		
	}
	static void Move(int x) {
		Queue<Integer> q = new LinkedList<>();
		q.add(first);
		visited[first] = 1;
		
		while(!q.isEmpty()) {
			int now = q.poll();
			int newX = 0;
			int num = list.size();
			
			if(list.get(now) == x) {
				ans += (visited[now]-1);
				list.remove(now);
				if(list.size() <= now) {
					first = (now + num+1)%num;
				}else {
					first = now;
				}
				break;
			}else {
				for(int i=0; i<2; i++) {
					if(i==0) {
						newX = (now + num-1)%num;
					}else {
						newX = (now + num+1)%num;
					}
					
					if(visited[newX] != 0) {
						continue;
					}
					
					q.offer(newX);
					visited[newX] = visited[now] + 1;
				}
			}
		}
		
	}
}
