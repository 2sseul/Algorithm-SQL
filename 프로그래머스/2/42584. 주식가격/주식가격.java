import java.io.*;
import java.util.*;

class Solution {
    static Stack<Integer> stack = new Stack<>();
    static int answer[];
    static int m = 0;
    static int n = 0;
    public int[] solution(int[] prices) {
        answer = new int[prices.length];
        
        for(int i=0; i<prices.length-1; i++){
            int now = prices[i];
            int cnt = 0;
            for(int j=i+1; j<prices.length; j++){
                if(now <= prices[j]){
                    cnt++;
                    if(j == prices.length-1){
                        answer[i] = cnt;
                    }
                }else{
                    answer[i] = cnt+1;
                    if(cnt == 1){
                        cnt = 1;
                    }
                    break;
                }
            }
        }

        
        return answer;
    }
}