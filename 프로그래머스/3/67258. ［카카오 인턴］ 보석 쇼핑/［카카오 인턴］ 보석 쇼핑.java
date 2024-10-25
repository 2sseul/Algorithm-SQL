import java.io.*;
import java.util.*;

class Solution {
    static HashSet<String> total = new HashSet<>();
    static HashMap<String, Integer> count = new HashMap<>();
    static List<int[]> list = new ArrayList<>();
    static int total_gems = 0;
    public int[] solution(String[] gems) {
        for(int i=0; i<gems.length; i++){
            if(!total.contains(gems[i])){
                total.add(gems[i]);
            }
        }
        total_gems = total.size();
        int left = 0;
        int right = 0;
        count.put(gems[left], 1);
        int sum = 1;
        while(true){
            if(sum < total_gems){
                right++;
                if(right > gems.length-1){
                    break;
                }
                if(count.containsKey(gems[right])){
                    count.put(gems[right],count.get(gems[right])+1);
                }else{
                    count.put(gems[right], 1);
                }
                sum = count.size();
            }else if(sum == total_gems){
                int[] tmp = {left, right, right-left};
                list.add(tmp);
                if(count.get(gems[left])==1){
                    count.remove(gems[left]);
                }else{
                    count.put(gems[left], count.get(gems[left])-1);   
                }
                left++;
                sum = count.size();
            }
        }
        
        Collections.sort(list, new Comparator<>(){
            public int compare(int[] o1, int[] o2){
                if(o1[2] == o2[2]){
                    return o1[0] - o2[0];
                }
                return o1[2] - o2[2];
            }  
        });
        
        int[] answer = {list.get(0)[0]+1, list.get(0)[1]+1};
        return answer;
    }
}