import java.io.*;
import java.util.*;

class Solution {
    public List<Integer> solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<genres.length; i++){
            if(!map.containsKey(genres[i])){
                map.put(genres[i], plays[i]);
            }else{
                map.put(genres[i], map.get(genres[i])+plays[i]);
            }
        }
        
        List<String> list = new ArrayList<>();
        for(String key : map.keySet()){
            list.add(key);
        }
        Collections.sort(list, new Comparator<>(){
            public int compare(String o1, String o2){
                return map.get(o2) - map.get(o1);
            }
        });
        
        int count[] = new int[list.size()];
            
        PriorityQueue<String[]> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(String[] o1, String[] o2){
                if(list.indexOf(o1[0]) < list.indexOf(o2[0])){
                    return -1;
                }else if(list.indexOf(o1[0]) > list.indexOf(o2[0])){
                    return 1;
                }else{
                    if(Integer.valueOf(o1[1]) > Integer.valueOf(o2[1])){
                        return -1;
                    }else if(Integer.valueOf(o1[1]) < Integer.valueOf(o2[1])){
                        return 1;
                    }else{
                        if(Integer.valueOf(o1[2]) > Integer.valueOf(o2[2])){
                            return 1;
                        }else if(Integer.valueOf(o1[2]) < Integer.valueOf(o2[2])){
                            return -1;
                        }else{
                            return 0;
                        }
                    }
                }
            }
        });
        
        for(int i=0; i<genres.length; i++){
            String tmp[] = {genres[i], plays[i]+"", i+"", list.indexOf(genres[i])+""};
            pq.offer(tmp);
        }
        
        List<Integer> answer = new ArrayList<>(); 
        while(!pq.isEmpty()){
            String now[] = pq.poll();
            if(count[Integer.valueOf(now[3])] < 2){
                count[Integer.valueOf(now[3])]++;
                answer.add(Integer.valueOf(now[2]));
            }
        }
        
        return answer;
    }
}