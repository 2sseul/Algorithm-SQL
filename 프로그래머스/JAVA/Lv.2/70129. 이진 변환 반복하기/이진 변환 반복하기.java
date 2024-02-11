import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String s) {
        int zeroCnt = 0;
        int changeCnt = 0;
        
        int[] answer = new int[2];
        
        String tmp = s;
        
        while(true){
            int length = tmp.length();
            tmp = tmp.replaceAll("0", "");
            
            zeroCnt += (length - tmp.length());
            
            int c = tmp.length();
            
            String changeTmp = "";
            
            while(true){
                changeTmp += (c%2);
                c /= 2;
                
                if(c == 0){
                    break;
                }
            }
            
            StringBuffer sb = new StringBuffer(changeTmp);
            tmp = sb.reverse().toString();
            
            changeCnt++;
            
            if(tmp.equals("1")){
                break;
            }
        }
        
        answer[0] = changeCnt;
        answer[1] = zeroCnt;
        
        return answer;
    }
}