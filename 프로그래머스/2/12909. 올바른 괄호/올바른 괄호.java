import java.io.*;
import java.util.*;

class Solution {
    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        boolean answer = true;
        for(int i=0; i<s.length(); i++){
            char now = s.charAt(i);
            if(stack.isEmpty()){
                if(now == ')'){
                    answer = false;
                    break;
                }else{
                    stack.push('(');
                }
            }else{
                char pre = stack.peek();
                if(pre == '(' && now == ')'){
                    stack.pop();
                    continue;
                }else{
                    stack.push(now);
                }
            }
        }
        if(stack.size() > 0){
            answer = false;
        }

        return answer;
    }
}