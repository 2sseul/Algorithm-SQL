import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[] babbling) {
        int length = babbling.length;
        for(int i=0; i<length; i++){
            String temp = babbling[i];
            temp = temp.replaceAll("ayaaya|yeye|woowoo|mama", " ");
            temp = temp.replaceAll("aya|ye|woo|ma", "");
            babbling[i] = temp;
        }
        
        int answer = 0;
        for(int i=0; i<length; i++){
            if(babbling[i].length()==0){
                answer++;
            }
        }
        return answer;
    }
}