import java.io.*;
import java.util.*;

class Solution {
    static char[][] map;
    static boolean[][] visited;
    static List<Integer> answer = new ArrayList<>();
    static int sum = 0;
    static int moveX[] = {-1, 1, 0, 0};
    static int moveY[] = {0, 0, -1, 1};
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
    public List<Integer> solution(String[] maps) {
        map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[i].length(); j++){
                map[i][j] = maps[i].charAt(j);
            }
        }
        
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[i].length(); j++){
                if(map[i][j]!='X' && !visited[i][j]){
                    sum = map[i][j]-48;
                    Island(i, j);
                    
                }else{
                    continue;
                }
            }
        }
        
        Collections.sort(answer);
        if(answer.size() == 0){
            answer.add(-1);
        }
        return answer;
    }
    static void Island(int x, int y){
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(x, y, map[x][y]));
        visited[x][y] = true;
        
        while(!q.isEmpty()){
            Node n = q.poll();
            
            for(int i=0; i<4; i++){
                int newX = n.x + moveX[i];
                int newY = n.y + moveY[i];
                if(newX < 0 || newY < 0 || newX >= map.length || newY >= map[0].length || map[newX][newY] == 'X' || visited[newX][newY]){
                    continue;
                }
                visited[newX][newY] = true;
                sum += (map[newX][newY]-48);
                q.offer(new Node(newX, newY, n.cnt+map[newX][newY]-48));
            }    
        }
        
        answer.add(sum);
        return;
    }
}