import java.util.*;
import java.io.*;

class Solution {
    boolean solution(String s) {
        //Stack<Character> stack = new Stack<>();
        boolean answer = false;
        
        //s = s.replaceAll("\\(\\)","");
        //System.out.println(s);
        
        int cnt = 0;
        char tmp = 'E';
        for(int i=0; i<s.length(); i++){
            if(tmp == 'E'){
                if(s.charAt(i) == '('){
                    tmp = '(';
                    cnt++;
                }else{
                    tmp = ')';
                    cnt--;
                    break;
                }
            }else{
                if(tmp == '(' && s.charAt(i) == ')'){
                    cnt--;
                    if(cnt == 0){
                        tmp = 'E';
                    }else if(cnt > 0 ){
                        tmp = '(';
                    }else{
                        tmp = ')';
                    }
                }else if(tmp == '(' && s.charAt(i) == '('){
                    tmp = '(';
                    cnt++;
                }else{
                    cnt--;
                    break;
                }
            }
        }
        
        if(cnt == 0){
            answer = true;
        }

        return answer;
    }
}