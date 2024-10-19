import java.io.*;
import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int answer = 0;
        
        if(sticker.length == 1){
            answer = sticker[0];
            return answer;
        }
        int dp0[] = new int[sticker.length];
        //첫번째 스티커를 뗐을 때
        dp0[0] = sticker[0];
        dp0[1] = dp0[0];
        for(int i=2; i<sticker.length-1; i++){
            dp0[i] = Math.max(dp0[i-1], dp0[i-2]+sticker[i]);
        }
        answer = dp0[sticker.length-2];
        
        int dp1[] = new int[sticker.length];
        //두번째 스티커를 뗐을 때(첫번째 스티커를 안 뗐을 때)
        dp1[0] = 0;
        dp1[1] = sticker[1];
        for(int i=2; i<sticker.length; i++){
            dp1[i] = Math.max(dp1[i-1], dp1[i-2]+sticker[i]);
        }
        
        answer = Math.max(answer, dp1[sticker.length-1]);

        return answer;
    }
}