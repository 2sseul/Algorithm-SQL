import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(int i: scoville){
            pq.offer(i);
        }
        
        int answer = 0;
        while(!pq.isEmpty()){
            if(pq.size() >= 2){
                int weakHotFood1 = pq.poll();
                int weakHotFood2 = pq.poll();   
                if(weakHotFood1 < K || weakHotFood2 < K){
                    answer++;
                    pq.offer(weakHotFood1 + (weakHotFood2 * 2));
                }else{
                    continue;
                }
            }else{
                int lastOne = pq.peek();
                if(lastOne >= K){
                    pq.poll();
                }else{
                    answer = -1;
                    break;
                }
            }
        }

        return answer;
    }
}