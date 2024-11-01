import java.io.*;
import java.util.*;
class Solution {
    static HashMap<String, Integer> remove = new HashMap<>();
    static HashMap<String, Integer> reportlistsum = new HashMap<>();
    static HashMap<String, HashMap<String, Integer>> reportlist = new HashMap<>();
    public int[] solution(String[] id_list, String[] report, int k) {
        for(int i=0; i<report.length; i++){
            if(remove.containsKey(report[i])){
                continue;
            }else{
                remove.put(report[i], 1);
            }
        }
        for(String t : remove.keySet()){
            String tmp[] = t.split(" ");
            
            if(!reportlist.containsKey(tmp[0])){
                HashMap<String, Integer> map = new HashMap<>();
                map.put(tmp[1], 1);
                reportlist.put(tmp[0], map);
                if(reportlistsum.containsKey(tmp[1])){
                    reportlistsum.put(tmp[1], reportlistsum.get(tmp[1])+1);
                }else{
                    reportlistsum.put(tmp[1], 1);   
                }
            }else{
                if(reportlistsum.containsKey(tmp[1]) && !reportlist.get(tmp[0]).containsKey(tmp[1])){
                    reportlistsum.put(tmp[1], reportlistsum.get(tmp[1])+1);
                }else{
                    reportlistsum.put(tmp[1], 1);
                }
                if(!reportlist.get(tmp[0]).containsKey(tmp[1])){
                    reportlist.get(tmp[0]).put(tmp[1], 1);
                }else{
                    reportlist.get(tmp[0]).put(tmp[1], reportlist.get(tmp[0]).get(tmp[1]));
                }
            }
        }
        
        int[] answer = new int[id_list.length];
        for(int i=0; i<id_list.length; i++){
            for(String name : reportlistsum.keySet()){
                if(reportlistsum.get(name) >= k && reportlist.containsKey(id_list[i]) && reportlist.get(id_list[i]).containsKey(name) && reportlist.get(id_list[i]).get(name) == 1){
                    answer[i]++;
                }
            }    
        }
        
        
        return answer;
    }
}