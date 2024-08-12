import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, new Comparator<int[]>(){
            public int compare(int o1[], int o2[]){
                return o1[1] - o2[1];
            }
        });
        
        int answer = 1;
        int now = routes[0][1];
        for(int i=1; i<routes.length; i++){
            if(routes[i][0] <= now){
                continue;
            }else{
                answer++;
                now = routes[i][1];
            }
        }
        return answer;
    }
}