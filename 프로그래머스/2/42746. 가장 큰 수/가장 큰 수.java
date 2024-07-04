import java.io.*;
import java.util.*;

class Solution {
    static PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<>(){
        public int compare(String o1, String o2){
            if(o1.length() == o2.length()){
                return o2.compareTo(o1);
            //o1과 o2의 길이가 다를 때
            }else{
                String tmp1 = o1+o2;
                String tmp2 = o2+o1;
                return tmp2.compareTo(tmp1);
            }
        }
    });
    public String solution(int[] numbers) {
        
        String[] check = new String[numbers.length];
        for(int i=0; i<numbers.length; i++){
            pq.offer(numbers[i]+"");
        }

        String answer = "";
        while(!pq.isEmpty()){
            answer += pq.poll();
        }
        
        if(answer.charAt(0) == '0'){
            answer = answer.replace("0","");
        }
        
        if(answer.length() == 0){
            answer = "0";
        }
        
        return answer;
    }
}