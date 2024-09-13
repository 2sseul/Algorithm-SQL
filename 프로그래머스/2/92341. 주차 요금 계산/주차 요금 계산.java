import java.io.*;
import java.util.*;

class Solution {
    static HashMap<String, String> map = new HashMap<>();
    static TreeMap<String, Integer> parking = new TreeMap<>();
    public int[] solution(int[] fees, String[] records) {
        for(int i=0; i<records.length; i++){
            String cars[] = records[i].split(" ");
            if(!map.containsKey(cars[1])){
                map.put(cars[1], cars[0]);
            }else{
                String in[] = map.get(cars[1]).split(":");
                String out[] = cars[0].split(":");
                int hour = (Integer.valueOf(out[0])-Integer.valueOf(in[0]))*60;
                int min = hour+Integer.valueOf(out[1])-Integer.valueOf(in[1]);
                //System.out.println(min);
                map.remove(cars[1]);
                if(parking.containsKey(cars[1])){
                    parking.put(cars[1], parking.get(cars[1])+min);
                }else{
                    parking.put(cars[1], min);
                }
            }
        }
        
        if(map.size() != 0){
            for(String key : map.keySet()){
                String in[] = map.get(key).split(":");
                int hour = (23-Integer.valueOf(in[0]))*60;
                int min = hour+59-Integer.valueOf(in[1]);
                if(parking.containsKey(key)){
                    parking.put(key, parking.get(key)+min);
                }else{
                    parking.put(key, min);
                }
            }
        }
        
        int answer[] = new int[parking.size()];
        
        //요금계산만 하면 됨!!!
        int cnt = 0;
        for(String key : parking.keySet()){
           int fee = 0;
           if(parking.get(key) >= fees[0]){
               int sum = parking.get(key) - fees[0];
               fee += fees[1];
               if(sum%fees[2] != 0){
                   fee += (sum/fees[2]+1)*fees[3];
               }else{
                   fee += (sum/fees[2])*fees[3];
               }
           }else{
               fee += fees[1];
           }
           answer[cnt++] = fee;
       }
        
        return answer;
    }
}