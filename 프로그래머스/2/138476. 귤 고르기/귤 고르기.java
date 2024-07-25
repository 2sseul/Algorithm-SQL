import java.io.*;
import java.util.*;

class Solution {
    public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<tangerine.length; i++){
            if(!map.containsKey(tangerine[i])){
                map.put(tangerine[i], 1);
            }else{
                map.put(tangerine[i], map.get(tangerine[i])+1);
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
                }else{
                    return 0;
                }
            }
        });
        
        int sum = 0;
        int answer = 0;
        for(int i=0; i<map.size(); i++){
            if(sum < k){
                if(sum < map.get(arr[i])){
                    sum += map.get(arr[i]);
                    answer++;
                    continue;
                }else{
                    sum += map.get(arr[i]);
                    answer++;
                    if(sum > k){
                        break;
                    }else if(sum < k){
                        continue;
                    }else{
                        break;
                    }
                }
            }else{
                break;
            }
        }

        return answer;
    }
}