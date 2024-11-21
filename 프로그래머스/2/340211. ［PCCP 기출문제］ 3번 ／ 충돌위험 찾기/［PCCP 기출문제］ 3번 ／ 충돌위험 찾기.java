import java.io.*;
import java.util.*;

// 최단거리지만, bfs가 아니라 계산으로 해결해보자.
class Solution {
    static HashMap<String, Integer> map = new HashMap<>();
    static String tmp = "";
    static int cnt = 0;
    public int solution(int[][] points, int[][] routes) {
        for(int i=0; i<routes.length; i++){
            cnt = 0;
            for(int j=0; j<routes[i].length-1; j++){
                int start[] = {points[routes[i][j]-1][0], points[routes[i][j]-1][1]};
                int end[] = {points[routes[i][j+1]-1][0], points[routes[i][j+1]-1][1]};
                if(j == 0){
                    tmp = tmp+"0."+start[0]+"."+start[1];   
                    if(!map.containsKey(tmp)){
                        map.put(tmp, 1);
                    }else{
                        map.put(tmp, map.get(tmp)+1);
                    }
                }
                Move(start, end, cnt);   
            }
        }
        int answer = 0;
        for(String key : map.keySet()){
            if(map.get(key) >= 2){
                answer++;
            }
        }
        return answer;
    }
    static void Move(int start[], int end[], int c){
        while(true){
            tmp = "";
            if(start[0] < end[0]){
                start[0]++;
            }else if(start[0] > end[0]){
                start[0]--;
            }else{
                if(start[1] < end[1]){
                    start[1]++;
                }else if(start[1] > end[1]){
                    start[1]--;
                }else{
                    cnt = c;
                    return;
                }
            }
            c++;
            tmp = tmp+c+"."+start[0]+"."+start[1];
            if(!map.containsKey(tmp)){
                map.put(tmp, 1);
            }else{
                map.put(tmp, map.get(tmp)+1);
            }
        }
    }
}