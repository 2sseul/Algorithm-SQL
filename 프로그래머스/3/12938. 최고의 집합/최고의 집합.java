import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        if(s/n == 0){
            answer = new int[1];
            answer[0] = -1;
        }else{
            int tmp = s%n;
            for(int i=0; i<n; i++){
                answer[i] = s/n;
            }
            if(tmp > 0){
                for(int i=n-1; i>0; i--){
                    if(tmp > 0){
                        answer[i]++;
                        tmp--;
                    }
                }
            }
        }
        return answer;
    }
}