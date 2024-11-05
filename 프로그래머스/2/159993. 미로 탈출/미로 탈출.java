import java.io.*;
import java.util.*;

class Solution {
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
    static boolean lever;
    static boolean goal;
    static int moveX[] = {-1, 1, 0, 0};
    static int moveY[] = {0, 0, -1, 1};
    static boolean visited[][];
    static char map[][];
    static int startX, startY;
    static int sum = 0;
    public int solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++){
            map[i] = maps[i].toCharArray();
        }
        for(int i=0; i<map.length; i++){
            for(int j=0; j<map[0].length; j++){
                if(map[i][j] == 'S'){
                    startX = i;
                    startY = j;
                }
            }
        }
        BFS(startX, startY, "L");
        BFS(startX, startY, "E");
        
        if(sum == 0 || !goal){
            sum = -1;
        }
        return sum;
    }
    static void BFS(int SX, int SY, String arrive){
        visited = new boolean[map.length][map[0].length];
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(SX, SY, 0));
        visited[SX][SY] = true;
        
        while(!q.isEmpty()){
            Node n = q.poll();
            
            if(map[n.x][n.y] == 'L' && arrive.equals("L")){
                lever = true;
                startX = n.x;
                startY = n.y;
                sum = n.cnt;
            }
            
            if(lever && map[n.x][n.y] == 'E' && arrive.equals("E")){
                sum += n.cnt;
                goal = true;
                return;
            }
            
            for(int i=0; i<4; i++){
                int newX = n.x + moveX[i];
                int newY = n.y + moveY[i];
                if(newX < 0 || newY < 0 || newX >= map.length || newY >= map[0].length || map[newX][newY] == 'X' || visited[newX][newY]){
                    continue;
                }
                
                visited[newX][newY] = true;
                q.offer(new Node(newX, newY, n.cnt + 1));
                
            }
        }
    }
}