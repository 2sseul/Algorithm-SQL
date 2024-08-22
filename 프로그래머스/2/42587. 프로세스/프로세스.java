import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] priorities, int location) {
        int count = 0;
        Deque<Integer[]> q = new LinkedList<>();
        List<Integer[]> list = new ArrayList<>();
        List<Integer[]> list_desc = new ArrayList<>();
        for(int i=0; i<priorities.length; i++){
            Integer tmp[] = {i, priorities[i]};
            list.add(tmp);
            list_desc.add(tmp);
        }
        
        Collections.sort(list_desc, new Comparator<>(){
            public int compare(Integer[] o1, Integer[] o2){
                if(o1[1] > o2[1]){
                    return -1;
                }else if(o1[1] < o2[1]){
                    return 1;
                }
                return 0;
            }
        });
        
        int max = list_desc.get(0)[1];
        int answer = 0;
        
        while(list.size() != 0){
            if(list.size() == 0){
                break;
            }
            q.offer(list.get(0));
            Integer[] now = q.poll();

            if(now[1] < max){
                list.remove(now);
                list.add(now);
            }else{
                count++;
                
                if(now[0] == location){
                    answer = count;
                    break;
                }
                list.remove(now);
                list_desc.remove(now);
                max = list_desc.get(0)[1];
            }
            
        }   
        
        return answer;
    }
}