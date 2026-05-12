import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int k, int[] score) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        int max = -1;
        int answer[] = new int[score.length];
        
        // k일 전까지는 모든 가수의 점수를 명예의 전당 목록에 올려서 기념
        // 만약 k > score.length 이면 score[i]가 큰지 작은지 확인 후 넣어야함
        for(int i=0; i<k; i++){
            if(i < score.length){
                pq.offer(score[i]);
                if(max < score[i]){
                    max = score[i];
                }
                answer[i] = pq.peek();
            } 
        }
        
        if(score.length >= k){
            for(int i=k; i<score.length; i++){
                if(i < score.length){
                    if(max < score[i]){
                        max = score[i];
                    }
                    if(pq.size() == k && pq.peek() < score[i]){
                        pq.poll();
                        pq.offer(score[i]);     
                    }
                }
                answer[i] = pq.peek();
            }
        }
        
        return answer;
    }
}