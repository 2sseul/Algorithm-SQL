import java.io.*;
import java.util.*;

class Solution {
    public int solution(int storey) {
        String tmp = String.valueOf(storey);
        int num = 0;
        int add = 0;
        for(int i=tmp.length()-1; i>=0; i--){
            char now = tmp.charAt(i);
            if(now-48+add > 5){
                num += (10 - (now-48+add));
                add = 1;
            }else if(now-48+add < 5){
                num += (now-48)+add;
                add = 0;
            }else{
                if(i > 0 && tmp.charAt(i-1)-48+1 > 5){
                    num += (10 - (now-48+add));
                    add = 1;
                }else{
                    num += (now-48)+add;
                    add = 0;
                }
            }
        }
        if(add > 0){
            num += 1;
        }
        return num;
    }
}