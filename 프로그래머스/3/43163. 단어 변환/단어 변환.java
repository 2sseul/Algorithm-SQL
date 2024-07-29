import java.io.*;
import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        String map[] = new String[words.length + 1];
        map[0] = begin;
        for(int i=0; i<words.length; i++){
            map[i+1] = words[i];
        }
        
        int visited[] = new int[map.length];
        
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        while(!q.isEmpty()){
            int n = q.poll();
            if(map[n].equals(target)){
                break;
            }
            for(int i=1; i<map.length; i++){
                int newX = i;
                int cnt = 0;

                for(int j=0; j<map[newX].length(); j++){
                    if(map[n].charAt(j) != map[newX].charAt(j)){
                        cnt++;
                    }
                }
                if(visited[newX] == 0 && cnt == 1){
                        visited[newX] = visited[n]+1;
                        q.offer(newX);
                }else{
                        continue;
                }
            }
        }
        
        int answer= 0;
        int count = 0;
        for(int i=0; i<visited.length; i++){
            if(map[i].equals(target)){
                answer = visited[i];
            }else{
                count++;
                continue;
            }
        }

        if(count == visited.length){
            answer = 0;
        }

        return answer;
    }
}