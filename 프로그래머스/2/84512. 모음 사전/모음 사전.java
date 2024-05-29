import java.io.*;
import java.util.*;

class Solution {
    static PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<>(){
        public int compare(String o1, String o2){
            return o1.compareTo(o2);
        }
    });
    static int length;
    static String result[];
    static String arr[] = {"A", "E", "I", "O", "U"};
    public int solution(String word) {
        
        for(int i=1; i<=5; i++){
            result = new String[i];
            cal(0,0,i);
        }
        
        int cnt = 0;
        while(!pq.isEmpty()){
            String now = pq.poll();
            cnt++;
            if(now.equals(word)){
                return cnt;
            }else{
                continue;
            }
        }
        return cnt;
    }
    
    public void cal(int index, int start, int len){
        if(index == len){
            String tmp = "";
            for(int i=0; i<len; i++){
                tmp+=result[i];
            }
            pq.offer(tmp);
            return;
        }
        for(int i=start; i<5; i++){
            result[index] = arr[i];
            cal(index+1, 0, len);
        }
    }
}