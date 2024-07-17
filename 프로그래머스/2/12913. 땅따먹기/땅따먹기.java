import java.io.*;
import java.util.*;

class Solution {
    int solution(int[][] land) {
        int N = land.length;
        int R = 4;
        
        int idx = 0;
        for(int i=N-1; i>=1; i--){
            for(int j=0; j<4; j++){
                int max = 0;
                for(int k=0; k<4; k++){
                    if(j!=k){
                        max = Math.max(land[i][k], max);
                    }
                }
                land[i-1][j] += max;
            }
        }
        
        int answer = Math.max(land[0][3] ,Math.max(land[0][2],Math.max(land[0][0], land[0][1])));

        return answer;
    }
}