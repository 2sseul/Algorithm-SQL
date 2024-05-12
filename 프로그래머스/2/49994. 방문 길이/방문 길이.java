import java.io.*;
import java.util.*;

class Solution {
    public int solution(String dirs) {
        HashMap<String, Integer> map = new HashMap<>();
        int goX[] = {0, 0, -1, 1};
        int goY[] = {1, -1, 0, 0};
        
        char dir[] = dirs.toCharArray();
        
        int startX = 0;
        int startY = 0;
        int moveX = 0;
        int moveY = 0;
        
        for(int i=0; i<dir.length; i++){
            if(dir[i] == 'U'){
                moveX = startX + goX[0];
                moveY = startY + goY[0];
                if(moveY > 5){
                    continue;
                }
            }else if(dir[i] == 'D'){
                moveX = startX + goX[1];
                moveY = startY + goY[1];
                if(moveY < -5){
                    continue;
                }
            }else if(dir[i] == 'R'){
                moveX = startX + goX[3];
                moveY = startY + goY[3];
                if(moveX > 5){
                    continue;
                }
            }else if(dir[i] == 'L'){
                moveX = startX + goX[2];
                moveY = startY + goY[2];
                if(moveX < -5){
                    continue;
                }
            }
            String tmp1 = ""+startX+""+startY+""+moveX+""+moveY;
            String tmp2 = ""+moveX+""+moveY+""+startX+""+startY;
            
            if(!map.containsKey(tmp1) && !map.containsKey(tmp2)){
                map.put(tmp1, 1);
            }
            
            startX = moveX;
            startY = moveY;
        }
        
        int answer = map.size();
        return answer;
    }
}