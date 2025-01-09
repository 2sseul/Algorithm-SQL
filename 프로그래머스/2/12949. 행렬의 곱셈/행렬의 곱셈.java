import java.util.*;

class Solution {
    public int[][] solution(int[][] arr1, int[][] arr2) {
        int[][] answer = new int[arr1.length][arr2[0].length];       
        
        int N = answer.length;
        int M = answer[0].length;
        
        for(int i=0; i<N; i++){
            for(int j=0; j<M; j++){
                for(int k=0; k<arr2.length; k++){
                    answer[i][j] += arr1[i][k] * arr2[k][j];
                }
            }
        }
        return answer;
    }
}