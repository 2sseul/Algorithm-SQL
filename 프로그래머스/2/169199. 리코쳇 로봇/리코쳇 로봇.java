import java.io.*;
import java.util.*;

class Solution {
    //상좌하우 0 1 2 3
    static int goX[] = {-1, 0, 1, 0};
    static int goY[] = {0, -1, 0, 1};
    static int N;
    static int M;
    static int visited[][];
    static char map[][];
    static int ans;
    static boolean row[];
    static class Node{
        int x;
        int y;
        Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }
    public int solution(String[] board) {
        map = new char[board.length][board[0].length()];
        for(int i=0; i<board.length; i++){
            map[i] = board[i].toCharArray();
        }
        N = board.length;
        M = map[0].length;
        visited = new int[N][M];
        row = new boolean[4];
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                if(map[i][j] == 'R'){
                    Robot(i, j);
                    break;
                }
            }
        }
        
        if(ans == 0){
            ans = -1;
        }
        return ans;
    }
    static void Robot(int x, int y){
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(x, y));
        visited[x][y] = 1;
        
        while(!queue.isEmpty()){
            Node n = queue.poll();
            
            int newX = n.x;
            int newY = n.y;
            
            //n의 가야하는 방향을 지정
            for(int i=0; i<4; i++){
                int nX = newX + goX[i];
                int nY = newY + goY[i]; 

                if(nX < 0 || nX >= N || nY < 0 || nY >= M || map[nX][nY] == 'D'){
                    if(row[i]){
                        row[i] = false;
                    }
                    continue;
                }

                row[i] = true; 
            }
            
            for(int i=0; i<4; i++){
                int nX = newX;
                int nY = newY;
                if(row[i]){
                    while(true){
                        nX += goX[i];
                        nY += goY[i];

                        //다음이 밖으로 나갔을 때는 멈춰!
                        if(nX < 0 || nX >= N || nY < 0 || nY >= M 
                           || map[nX][nY] == 'D'){
                            nX -= goX[i];
                            nY -= goY[i];
                            break;
                        }
                    }

                    //도착지네?
                    if(map[nX][nY] == 'G'){
                        visited[nX][nY] = visited[newX][newY] + 1;
                        ans = visited[nX][nY]-1;
                        return;
                    }
                    
                    if(visited[nX][nY] != 0){
                        continue;
                    }
                    
                    visited[nX][nY] = visited[newX][newY]+1;
                    queue.offer(new Node(nX, nY));
                }else{
                    continue;
                }
            }
        }
    }
}