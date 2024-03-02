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
	public static void main(String[] args) throws Exception{
		StringBuilder sb = new StringBuilder();
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		PriorityQueue<Node> pq = new PriorityQueue<>(new Comparator<>() {
			public int compare(Node o1, Node o2) {
				if(o1.y > o2.y) {
					return 1;
				}else if(o1.y < o2.y) {
					return -1;
				}else {
					if(o1.x > o2.x) {
						return 1;
					}else if(o1.x < o2.x) {
						return -1;
					}else {
						return 0;
					}
				}
			}
		});
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			pq.offer(new Node(x, y));
		}
		
		while(!pq.isEmpty()) {
			Node n = pq.poll();
			sb.append(n.x).append(" ").append(n.y).append('\n');
		}
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
	}
}
