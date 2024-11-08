import java.io.*;
import java.util.*;

class Solution {
    static String[] baby = {"aya", "ye", "woo", "ma"};
    public int solution(String[] babbling) {
        for(int i=0; i<babbling.length; i++){
            String tmp = babbling[i];
            int num = tmp.length();
            for(int j=0; j<4; j++){
                if(tmp.contains(baby[j])){
                    tmp = tmp.replaceAll(baby[j], " ");
                }
            }
            babbling[i] = tmp;
        }
        
        int answer = 0;
        for(int i=0; i<babbling.length; i++){
            if(babbling[i].trim().length() == 0){
                answer++;
            }
        }

        return answer;
    }
}