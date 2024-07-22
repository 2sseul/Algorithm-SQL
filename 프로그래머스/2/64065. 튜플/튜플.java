import java.io.*;
import java.util.*;

class Solution {
    public Integer[] solution(String s) {
        HashMap<Integer, Integer> map = new HashMap<>();
        String tmp = "";
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) >=48 && s.charAt(i) <= 57){
                tmp += s.charAt(i);
            }else{
                if(tmp.length()!=0){
                    if(map.containsKey(Integer.valueOf(tmp))){
                        map.put(Integer.valueOf(tmp) ,map.get(Integer.valueOf(tmp))+1);
                    }else{
                        map.put(Integer.valueOf(tmp), 1);   
                    }
                    tmp="";
                }else{
                    continue;
                }
            }
        }
        
        Integer arr[] = new Integer[map.size()];
        int cnt = 0;
        for(int mapKey : map.keySet()){
            arr[cnt++] = mapKey;
        }
        
        Arrays.sort(arr, new Comparator<Integer>(){
            public int compare(Integer o1, Integer o2){
                if(map.get(o1) > map.get(o2)){
                    return -1;
                }else if(map.get(o1) < map.get(o2)){
                    return 1;
                }
                return 0;
            }
        });
            
        return arr;
    }
}