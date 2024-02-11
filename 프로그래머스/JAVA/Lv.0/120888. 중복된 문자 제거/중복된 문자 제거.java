import java.util.*;
import java.io.*;

class Solution {
    public String solution(String my_string) {
        HashMap<Character, Integer> map = new HashMap<>();
        
        String answer = "";
        
        char[] temp = my_string.toCharArray();
        
        for(int i=0; i<temp.length; i++){
            if(!map.containsKey(temp[i])){
                map.put(temp[i],1);
                answer+=temp[i];
            }
        }
        return answer;
    }
}