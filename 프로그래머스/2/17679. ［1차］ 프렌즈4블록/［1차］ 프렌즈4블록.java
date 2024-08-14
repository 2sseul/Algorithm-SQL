import java.io.*;
import java.util.*;

class Solution {
    static char[][] map;
    static boolean[][] visited;
    static int M, N;
    static int ans;

    public int solution(int m, int n, String[] board) {
        M = m;
        N = n;
        
        map = new char[m][n];
        visited = new boolean[m][n];
        
        // 보드 초기화
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = board[i].charAt(j);
            }
        }
        
        // 반복해서 블록 제거
        while (true) {
            // 초기화
            for (int i = 0; i < m; i++) {
                Arrays.fill(visited[i], false);
            }
            
            boolean isAnyBlockRemoved = false;
            
            // 2x2 블록 체크
            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    if (map[i][j] != '@' && checkBlock(i, j)) {
                        isAnyBlockRemoved = true;
                    }
                }
            }
            
            if (!isAnyBlockRemoved) break; // 더 이상 제거할 블록이 없다면 종료
            
            // 제거된 블록의 수 계산 및 블록 제거
            countAndRemoveBlocks();
            
            // 블록 아래로 이동
            moveBlocksDown();
        }

        return ans;
    }

    static boolean checkBlock(int x, int y) {
        char block = map[x][y];
        if (map[x + 1][y] == block && map[x][y + 1] == block && map[x + 1][y + 1] == block) {
            visited[x][y] = true;
            visited[x + 1][y] = true;
            visited[x][y + 1] = true;
            visited[x + 1][y + 1] = true;
            return true;
        }
        return false;
    }

    static void countAndRemoveBlocks() {
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (visited[i][j]) {
                    map[i][j] = '@'; // 블록 제거
                    ans++;
                }
            }
        }
    }
    
    static void moveBlocksDown() {
        for (int j = 0; j < N; j++) {
            int emptyIndex = M - 1;
            for (int i = M - 1; i >= 0; i--) {
                if (map[i][j] != '@') {
                    map[emptyIndex][j] = map[i][j];
                    if (emptyIndex != i) {
                        map[i][j] = '@';
                    }
                    emptyIndex--;
                }
            }
        }
    }
}
