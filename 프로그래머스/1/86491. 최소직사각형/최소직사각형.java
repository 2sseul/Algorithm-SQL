import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] sizes) {
        
        int large = 0;
        int small = 0;
        for(int i=0; i<sizes.length; i++){
            if(sizes[i][0] > sizes[i][1]){
                large = Math.max(large, sizes[i][0]);
                small = Math.max(small, sizes[i][1]);
            }else{
                large = Math.max(large, sizes[i][1]);
                small = Math.max(small, sizes[i][0]);
            }
        }
        int answer = large*small;
        return answer;
    }
}