import java.io.*;
import java.util.*;

class Solution {
    static boolean used[];
    static String cities = "Z";
    static List<String> list = new ArrayList<>();
    public String[] solution(String[][] tickets) {
        
        used = new boolean[tickets.length];
        DFS(0, "ICN", "ICN ", tickets);
        Collections.sort(list);
        
        String[] answer = list.get(0).split(" ");
        return answer;
    }
    static void DFS(int count, String start, String route, String[][] tickets){
        if(count == tickets.length){
            list.add(route);
            return;
        }
        for(int i=0; i<tickets.length; i++){
            if(used[i] || !start.equals(tickets[i][0])){
                continue;    
            }
                used[i] = true;
                DFS(count+1, tickets[i][1], route+tickets[i][1]+" ", tickets);
                used[i] = false;
        }
    }
}