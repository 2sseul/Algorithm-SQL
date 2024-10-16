import java.io.*;
import java.util.*;

class Solution {
    static List<String> list = new ArrayList<>();
    static int answer = 0;
    public int solution(int cacheSize, String[] cities) {
        for(int i=0; i<cities.length; i++){
            String city = cities[i].toUpperCase();
            if(cacheSize == 0){
                answer += 5;
            }else{
                int num = list.size();
                if(num < cacheSize){
                    if(!list.contains(city)){
                        list.add(city);
                        answer += 5;
                    }else{
                        list.remove(city);
                        list.add(city);
                        answer += 1;
                    }
                }else{
                    if(!list.contains(city)){
                        list.remove(list.get(0));
                        list.add(city);
                        answer += 5;
                    }else{
                        list.remove(city);
                        list.add(city);
                        answer += 1;
                    }
                }
            }
            
        }
        return answer;
    }
}