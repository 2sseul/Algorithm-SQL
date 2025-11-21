import java.io.*;
import java.util.*;

class Solution {
    static int n, m;
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
    // 상 하 좌 우
    static int[] moveX = {-1, 1, 0, 0};
    static int[] moveY = {0, 0, -1, 1};
    static int answer = 0;
    static boolean[][] visited;
    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;
        visited = new boolean[n][m];
        answer = BFS(0, 0, maps);
        return answer;
    }
    static int BFS(int x, int y, int[][] maps){
        Queue<Node> q = new LinkedList<>();
        visited[x][y] = true;
        q.offer(new Node(x, y, 0));
        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.x == n-1 && now.y == m-1){
                return now.cnt+1;
            }
            for(int i=0; i<4; i++){
                int newX = now.x + moveX[i];
                int newY = now.y + moveY[i];
                if(newX < 0 || newX >= n || newY < 0 || newY >= m || visited[newX][newY] || maps[newX][newY] == 0){
                    continue;
                }
                q.offer(new Node(newX, newY, now.cnt+1));
                visited[newX][newY] = true;
            }
        }
        return -1;
    }
}