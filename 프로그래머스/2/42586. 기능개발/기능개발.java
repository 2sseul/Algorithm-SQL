import java.io.*;
import java.util.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
        Stack<Integer> stack = new Stack<>();
        List<Integer> answer = new ArrayList<>();
        int cnt = 0;
        for(int i=0; i<progresses.length; i++){
            //배포까지 걸리는 시간 계산
            int day = (100 - progresses[i])/speeds[i];
            if(speeds[i]*day+progresses[i] < 100){
                day += 1;
            }
            if(stack.isEmpty()){
                stack.push(day);
            }else{
                int pre = stack.peek();
                if(pre < day){
                    answer.add(cnt+1);
                    cnt = 0;
                    stack.push(day);
                }else{
                    cnt++;
                    continue;
                }
            }
        }
        answer.add(cnt+1);
        return answer;
    }
}