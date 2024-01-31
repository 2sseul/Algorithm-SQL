import java.io.*;
import java.util.*;

public class Main {
	static int goX[] = {-1, -2, -2, -1, 1, 2, 2, 1};
	static int goY[] = {-2, -1, 1, 2, -2, -1, 1, 2};
	static int l;
	static int startX, startY;
	static int endX, endY;
	static int map[][];
	static boolean visited[][];
	static class Node{
		int x;
		int y;
		Node(int x, int y){
			this.x = x;
			this.y = y;
		}
	}
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int tc = Integer.parseInt(br.readLine());
		for(int i=0; i<tc; i++) {
			l = Integer.parseInt(br.readLine());
			map = new int[l][l];
			visited = new boolean[l][l];
			
			StringTokenizer st = new StringTokenizer(br.readLine());
			startX = Integer.parseInt(st.nextToken());
			startY = Integer.parseInt(st.nextToken());
			
			st = new StringTokenizer(br.readLine());
			endX = Integer.parseInt(st.nextToken());
			endY = Integer.parseInt(st.nextToken());
			
			BFS(startX, startY);
			
			sb.append(map[endX][endY]).append('\n');			
		}
		System.out.println(sb.toString());
	}
	static void BFS(int x, int y) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			visited[node.x][node.y] = true;
			
			if(node.x == endX && node.y == endY) {
				return;
			}
			
			for(int i=0; i<8; i++) {
				int newX = node.x + goX[i];
				int newY = node.y + goY[i];
				
				if(newX < 0 || newX >= l || newY < 0 || newY >= l || visited[newX][newY]) {
					continue;
				}
				
				map[newX][newY] = map[node.x][node.y]+1;
				queue.add(new Node(newX, newY));
				visited[newX][newY] = true;
			}
		}
	}
}
