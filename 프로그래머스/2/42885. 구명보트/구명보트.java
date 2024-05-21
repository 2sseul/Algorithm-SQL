import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        Deque<Integer> dq = new LinkedList<>();
        for(int i=0; i<people.length; i++){
            dq.offer(people[i]);
        }
        
        int answer = 0;
        
        while(!dq.isEmpty()){
            int sum = 0;
            int max = dq.pollLast();
            sum += max;
            while(!dq.isEmpty()){
                int first = dq.peekFirst();
                if(sum+first <= limit){
                    sum += dq.pollFirst();
                    break;
                }else{
                    break;
                }
            }
            answer++;
        }
        
        return answer;
    }
}
    