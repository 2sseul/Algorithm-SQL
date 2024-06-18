import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(Integer o1, Integer o2){
                return o1-o2;
            }
        });
        
        for(int i=0; i<scoville.length; i++){
            pq.offer(scoville[i]);   
        }
        
        int cnt = 0;
        while(!pq.isEmpty()){
            if(pq.size()==1){
                int num = pq.peek();
                if(num < K){
                    cnt = -1;
                    break;
                }
            }
            int smallOne = pq.poll();
            if(smallOne >= K){
                break;
            }
            int smallTwo = pq.poll();
            
            int newOne = smallOne + smallTwo*2;
            cnt++;
            pq.offer(newOne);
        }
        
        return cnt;
    }
}