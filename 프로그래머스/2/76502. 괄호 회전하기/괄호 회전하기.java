import java.io.*;
import java.util.*;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int cnt = 0;
        if(s.length()%2 == 1){
            answer = 0;
        }else{
            for(int i=0; i<s.length(); i++){
                Stack<Character> stack = new Stack<>();
                String check = s.substring(i, s.length())+s.substring(0, i);
                for(int j=0; j<check.length(); j++){
                    char now = check.charAt(j);
                    if(stack.isEmpty()){
                        stack.push(now);
                    }else{
                        char top = stack.peek();
                        if(now == ')' && top == '('){
                            stack.pop();
                        }else if(now == '}' && top == '{'){
                            stack.pop();
                        }else if(now == ']' && top == '['){
                            stack.pop();
                        }else{
                            stack.push(now);
                            continue;
                        }
                    }
                }
                if(stack.size() == 0){
                    answer++;
                }
            }
        }
        
        return answer;
    }
}