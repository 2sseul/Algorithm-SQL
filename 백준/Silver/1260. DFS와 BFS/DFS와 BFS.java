import java.io.*;
import java.util.*;

public class Main {
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	static int N, M, V;
	static int arr[][];
	static boolean visited_bfs[];
	static boolean visited_dfs[];
	static StringBuilder bfs = new StringBuilder();
	static StringBuilder dfs = new StringBuilder();
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		V = Integer.parseInt(st.nextToken());
		
		arr = new int[M*2][2];
		for(int i=0; i<M; i++) {
			st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
			arr[i+M][0] = arr[i][1];
			arr[i+M][1] = arr[i][0];
		}
		
		visited_bfs = new boolean[N+1];
		visited_dfs = new boolean[N+1];
		
		Arrays.sort(arr, new Comparator<>() {
			public int compare(int[] o1, int[] o2) {
				if(o1[0] > o2[0]) {
					return 1;
				}else if(o1[0] < o2[0]) {
					return -1;
				}else {
					if(o1[1] > o2[1]) {
						return 1;
					}else if(o1[1] < o2[1]) {
						return -1;
					}else {
						return 0;
					}
				}
			}
		});
		
		BFS(V);
		visited_dfs[V] = true;
		dfs.append(V).append(" ");
		DFS(V);
		
		dfs.append('\n').append(bfs.toString());
		bw.write(dfs.toString());
		bw.close();
	}
	static void BFS(int start) {
		Queue<Node> q = new LinkedList<>();
		for(int i=0; i<M*2; i++) {
			if(arr[i][0] == start) {
				q.offer(new Node(arr[i][0], arr[i][1]));
			}
		}
		visited_bfs[start] = true;
		bfs.append(start).append(" ");
		
		while(!q.isEmpty()) {
			Node n = q.poll();
			if(!visited_bfs[n.y]) {
				visited_bfs[n.y] = true;
				bfs.append(n.y).append(" ");
				for(int i=0; i<M*2; i++) {
					if(arr[i][0] == n.y && !visited_bfs[arr[i][1]]) {
						q.offer(new Node(n.y, arr[i][1]));
					}
				}
			}
		}
		
	}
	static void DFS(int start) {
		for(int i=0; i<M*2; i++) {
			if(arr[i][0] == start && !visited_dfs[arr[i][1]]) {
				visited_dfs[arr[i][1]] = true;
				dfs.append(arr[i][1]).append(" ");
				DFS(arr[i][1]);
			}else {
				continue;
			}
		}
	}
}
