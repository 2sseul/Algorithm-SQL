import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(String[] operations) {
        PriorityQueue<Integer> pq_asc = new PriorityQueue<>();
        
        PriorityQueue<Integer> pq_desc = new PriorityQueue<>(Collections.reverseOrder());
        
        int cnt = 0;
        for(int i=0; i<operations.length; i++){
            String[] arr = operations[i].split(" ");
            if(arr[0].equals("I")){
                pq_asc.offer(Integer.valueOf(arr[1]));
                pq_desc.offer(Integer.valueOf(arr[1]));
                cnt++;
            }else{
                if(arr[1].equals("1")){
                    if(cnt > 0){
                        int tmp = pq_desc.poll();
                        pq_asc.remove(tmp);
                        cnt--;
                    }else{
                        continue;
                    }
                }else{
                    if(cnt > 0){
                        int tmp = pq_asc.poll();
                        pq_desc.remove(tmp);
                        cnt--;
                    }else{
                        pq_desc.clear();
                        continue;
                    }
                }
            }
        }
        
        if(cnt == 0){
            pq_desc.clear();
            pq_asc.clear();
        }
        
        int[] answer = new int[2];
        
        if(pq_desc.size() == 0){
            answer[0] = 0;
            if(pq_asc.size() == 0){
                answer[1] = 0;
            }else{
                answer[1] = pq_asc.poll();
                answer[0] = answer[1];
            }
        }else{
            answer[0] = pq_desc.poll();
            if(pq_asc.size() == 0){
                answer[1] = answer[0];
            }else{
                answer[1] = pq_asc.poll();
            }
        }
        
        return answer;
    }
}