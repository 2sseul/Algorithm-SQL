import java.util.*;
import java.io.*;

class Solution {
    static int N,M;
    static boolean visited[][];
    static int count = Integer.MAX_VALUE;
    static int maps[][];
    static class Node{
        int x;
        int y;
        int cnt;
        Node(int x, int y, int cnt){
            this.x = x;
            this.y = y;
            this.cnt = cnt;
        }
    }
    public int solution(int[][] maps) {
        N = maps.length;
        M = maps[0].length;
        
        visited = new boolean[N][M];
        
        move(new Node(0,0,1), maps);
        
        if(count == Integer.MAX_VALUE){
            count = -1;
        }
        return count;
    }
    public static void move(Node node, int[][] maps){
        Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		
		while(!queue.isEmpty()) {
			Node new_Node = queue.poll();
			
			if(new_Node.x == N-1 && new_Node.y == M-1) {
				count = Math.min(count, new_Node.cnt);
			}
			
			int xR[] = {0,0,-1,1};
			int yC[] = {-1,1,0,0};
			
			for(int i=0;i<4;i++) {
				int newX = new_Node.x + xR[i];
				int newY = new_Node.y + yC[i];
				
				if(newX<0 || newX>=N || newY<0 || newY>=M || visited[newX][newY] || maps[newX][newY] == 0 ) {
					continue;
				}
				
				if(maps[newX][newY]==1 && !visited[newX][newY]) {				
					queue.add(new Node(newX, newY, new_Node.cnt+1));
					visited[newX][newY] = true;
				}
				
			}
		}
    }
}