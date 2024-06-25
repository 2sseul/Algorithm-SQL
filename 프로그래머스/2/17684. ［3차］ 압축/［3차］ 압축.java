import java.io.*;
import java.util.*;

class Solution {
    public List<Integer> solution(String msg) {
    PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(String o1, String o2){
                if(o1.length() > o2.length()){
                    return -1;
                }else if(o2.length() < o1.length()){
                    return 1;
                }
                return 0;
            }
        });
        HashMap<String, Integer> map = new HashMap<>();
        List<Integer> answer = new ArrayList<>();
        
        for(int i=1; i<=26; i++){
            map.put(((char)(i+64))+"", i);
        }
        int num = 27;
        int start = 0;
        int cnt = 1;
        
    for(int i=0; i<msg.length(); i++){
        int max = -1;
        pq.clear();
        for(int j=1; j<msg.length()-i+1; j++){
            String tmp = msg.substring(i, i+j);
            if(map.containsKey(tmp)){
                pq.offer(tmp);
                max = Math.max(max, i+j);
            }
        }
        
        String word = pq.poll();
        answer.add(map.get(word));
        
        if(max != msg.length()){
            String longWord = word+msg.substring(max, max+1);
            if(!map.containsKey(longWord)){
                map.put(longWord, num);
                num++;
            }
        }
        
        if(word.length() >= 2){
            i += (word.length()-1);
        }
    }
        
        
        return answer;
    }
}