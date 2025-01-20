import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n, int[] works) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(Integer o1, Integer o2){
                return o2 - o1;
            }
        });
        
        for(int i=0; i<works.length; i++){
            pq.offer(works[i]);
        }
        
        while(!pq.isEmpty() && n > 0){
            int N = pq.poll();
            n--;
            N -= 1;
            if(N > 0){
                pq.offer(N);
            }
        }
        
        long answer = 0;
        int len = pq.size();
        for(int i=0; i<len; i++){
            answer += Math.pow(pq.poll(), 2);
        }
        return answer;
    }
}