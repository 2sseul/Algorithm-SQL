import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] data, int col, int row_begin, int row_end) {
        Arrays.sort(data, new Comparator<int[]>(){
           public int compare(int[] o1, int[] o2){
               if(o1[col-1] == o2[col-1]){
                   return o2[0] - o1[0];
               }
               return o1[col-1] - o2[col-1];
           } 
        });
        
        int[] arr = new int[row_end - row_begin + 1];
        
        for(int i=row_begin-1; i<=row_end-1; i++){
            int sum = 0;
            for(int j=0; j<data[i].length; j++){
                sum += (data[i][j] % (i+1));
            }
            arr[i+1-row_begin] = sum;
        }
        int answer = arr[0];
        for(int i=1; i<row_end - row_begin + 1; i++){
            answer = answer ^ arr[i];
        }
        return answer;
    }
}