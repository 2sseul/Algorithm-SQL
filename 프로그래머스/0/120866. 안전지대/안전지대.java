import java.io.*;
import java.util.*;

class Solution {
    static int[] moveX = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] moveY = {-1, 0, 1, -1, 1, -1, 0, 1};
    static boolean visited[][];
    public int solution(int[][] board) {
        visited = new boolean[board.length][board[0].length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 1){
                    Check(i, j, board);
                }
            }
        }
        int answer = 0;
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == 0){
                    answer++;
                }
            }
        }
        return answer;
    }
    static int[][] Check(int x, int y, int[][] map){
        for(int i=0; i<8; i++){
            int newX = x + moveX[i];
            int newY = y + moveY[i];
            if(newX < 0 || newX >= map.length || newY < 0 || newY >= map[0].length || visited[newX][newY] || map[newX][newY] == 1){
                continue;
            }
            map[newX][newY] = 2;
            visited[newX][newY] = true;
        }
        return map;
    }
}