import java.io.*;
import java.util.*;

class Solution {
    static boolean visited[][];
    static int oil;
    static int goX[] = {-1, 1, 0, 0};
    static int goY[] = {0, 0, -1, 1};
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    static TreeMap<Integer, Integer> map = new TreeMap();
    static int answer = 0;
    public int solution(int[][] land) {
        visited = new boolean[land.length][land[1].length];
        int cnt = 2; 
        for(int i=0; i<land.length; i++){
            for(int j=0; j<land[1].length; j++){
                if(land[i][j]==1 && !visited[i][j]){
                    land[i][j] = cnt;
                    BFS(land, i, j, cnt);
                    map.put(cnt, oil);
                    cnt++;
                    oil = 0;
                }
            }
        }
        
        Count(land);
        
        return answer;
    }
    
    static void BFS(int[][] land, int x, int y, int cnt){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        
        while(!queue.isEmpty()){
            Node node = queue.poll();
            oil++;
            visited[node.x][node.y] = true;
            
            for(int i=0; i<4; i++){
                int newX = node.x + goX[i];
                int newY = node.y + goY[i];
                
                if(newX < 0 || newX >= land.length || newY < 0 || newY >= land[1].length || visited[newX][newY] || land[newX][newY] != 1){
                    continue;
                }
                
                land[newX][newY] = cnt;
                queue.offer(new Node(newX, newY));
            }
        }
    }
    
    static void Count(int[][] land){
        List<Integer> list = new ArrayList<>();
        int sum = 0;
        for(int i=0; i<land[1].length; i++){
            sum = 0;
            list.clear();
            for(int j=0; j<land.length; j++){
                if(land[j][i] == 0){
                    continue;
                }else{
                    if(!list.contains(land[j][i])){
                        list.add(land[j][i]);
                        sum += map.get(land[j][i]);
                    }else{
                        continue;
                    }
                }
            }
            answer = Math.max(sum, answer);
        }
    }
}