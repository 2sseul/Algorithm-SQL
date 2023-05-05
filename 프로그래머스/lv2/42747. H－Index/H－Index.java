import java.util.*;
import java.io.*;

class Solution {
    public int solution(int[] citations) {
        Arrays.sort(citations);
        List<Integer> list = new ArrayList<>();
        int length = citations.length;
        for(int i=0;i<length;i++){
            list.add(citations[i]);
        }
        Collections.reverse(list);
        
        int up = 0;
        int down = 0;
        int num = 0;
        for(int i=1; i<=1000; i++){
            up = 0;
            down = 0;
            for(int j=length-1; j>=0; j--){
                if(list.get(j)>=i){
                    up++;
                }
            }
            if(up>=i){
                num = Math.max(num, i);
            }
        }
        
        int answer = num;
        return answer;
    }
}