import java.util.*;
import java.io.*;

public class Main {
	static int N;
	static int num;
	static int rgbNum;
	static String map[][];
	static boolean visited[][];
	static boolean visitedRGB[][];
	static int[] xR = {-1,1,0,0};
	static int[] yC = {0,0,-1,1};
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
		
		N = Integer.parseInt(br.readLine());
		
		map = new String[N][N];
		visited = new boolean[N][N];
		visitedRGB = new boolean[N][N];

		for(int i=0; i<N; i++) {
			String tmp = br.readLine();
			for(int j=0; j<N; j++) {
				map[i] = tmp.split("");
			}
		}
		
		num = 0;
		rgbNum = 0;
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j].equals("R") && !visited[i][j]) {
					bfs(i, j, "G", "B");
					num++;
				}
				else if(map[i][j].equals("G") && !visited[i][j]) {
					bfs(i, j, "R", "B");
					num++;
				}else if(map[i][j].equals("B") && !visited[i][j]){
					bfs(i, j, "R", "G");
					num++;
					rgbNum++;
				}
			}
		}
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if(map[i][j].equals("R") || map[i][j].equals("G")) {
					if(!visitedRGB[i][j]) {
						rgbBFS(i, j, "B");
						rgbNum++;
					}
				}
			}
		}
		
		sb.append(num + " " + rgbNum);
		System.out.println(sb.toString());
		
	}
	
	static void bfs(int x, int y, String nonColor1, String nonColor2) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			visited[node.x][node.y] = true;
			
			for(int i=0; i<4; i++) {
				int newX = node.x + xR[i];
				int newY = node.y + yC[i];
				
				if(newX < 0 || newX >= N || newY < 0 || newY >= N || visited[newX][newY] || map[newX][newY].equals(nonColor1) || map[newX][newY].equals(nonColor2)) {
					continue;
				}
				
				queue.add(new Node(newX, newY));
				visited[newX][newY] = true;
			}
			
		}
	}
	
	static void rgbBFS(int x, int y, String nonColor) {
		Queue<Node> queue = new LinkedList<>();
		queue.add(new Node(x, y));
		
		while(!queue.isEmpty()) {
			Node node = queue.poll();
			visitedRGB[node.x][node.y] = true;
			
			for(int i=0; i<4; i++) {
				int newX = node.x + xR[i];
				int newY = node.y + yC[i];
				
				if(newX < 0 || newX >= N || newY < 0 || newY >= N || visitedRGB[newX][newY] ||  map[newX][newY].equals(nonColor)) {
					continue;
				}
				
				queue.add(new Node(newX, newY));
				visitedRGB[newX][newY] = true;
			}
			
		}
	}
}
