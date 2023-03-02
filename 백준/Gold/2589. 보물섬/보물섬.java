import java.util.*;
import java.io.*;

public class Main {
	static int N, M, max;
	static char treasure_Island[][];
	static boolean checked[][];
	public static class Node{
		int x;
		int y;
		int howLong;
		Node(int x, int y, int howLong){
			this.x = x;
			this.y = y;
			this.howLong = howLong;
		}
	}
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		treasure_Island = new char[N][M];
		
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				treasure_Island[i][j] = s.charAt(j);
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<M;j++) {
				if(treasure_Island[i][j]=='L') {
					checked = new boolean[N][M];
					bfs(new Node(i,j,0));
				}
			}
		}
		System.out.println(max);
	}
	private static void bfs(Node node) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		checked[node.x][node.y]=true;
		while(!queue.isEmpty()) {
			Node now = queue.poll();

			int xR[] = {0, 0, -1, 1};
			int yC[] = {-1, 1, 0, 0};
			
			for(int k=0;k<4;k++) {
				int newX = now.x + xR[k];
				int newY = now.y + yC[k];
				
				if(newX < 0 || newX >= N || newY < 0 || newY >=M) {
					continue;
				}
				
				if(treasure_Island[newX][newY]=='L' && !checked[newX][newY]) {
					checked[newX][newY] = true;
					queue.add(new Node(newX, newY, now.howLong+1));
					max = Math.max(max,now.howLong+1);
				}
			}
		}
	}
}
