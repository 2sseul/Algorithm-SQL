import java.io.*;
import java.util.*;

class Solution {
    static boolean visited[];
    static int N;
    public int solution(String[][] book_time) {
        int answer = 0;
        N = book_time.length;
        
        visited = new boolean[N];
        
        // 종료 시간에 10분씩 더하기
        book_time = timeFix(book_time, 10);
        
        // book_time을 오름차순으로 정렬
        Arrays.sort(book_time, new Comparator<String[]>(){
           public int compare(String[] o1, String[] o2) {
               if(o1[0].equals(o2[0])){
                    return o1[1].compareTo(o2[1]);
               }else{
                    return o1[0].compareTo(o2[0]);   
               }
           }
        });
        
        for(int i=0; i<N; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(i, book_time);
                answer++;
            }else{
                continue;
            }
        }
        return answer;
    }
    
    // dfs 돌면서 다음에 넣을 수 있는 방을 찾아서 넣어준다.
    static void dfs(int idx, String[][] time){
        for(int i=0; i<N; i++){
            if(!visited[i] && time[idx][1].compareTo(time[i][0]) <= 0){
                visited[i] = true;
                dfs(i, time);
                break;
            }
        }
    }
    
    // 대실 종료 시간에 + 10분
    // 단, 23:59에는 더이상 손님이 들어오지 않으니 + 10분 하지 않음.
    static String[][] timeFix(String[][] time, int cleanTime){
        for(int i=0; i<N; i++){
            String[] tmp = time[i][1].split(":");
            int hour = Integer.parseInt(tmp[0]);
            int minute = Integer.parseInt(tmp[1])+cleanTime;
            if(minute >= 60) {
                hour++; minute -= 60;
            }
            if(hour >= 24) {
                hour = 23; minute = 59;
            }
            String hours = hour+"";
            String minutes = minute+"";
            if(hour < 10){
                hours = "0"+hour;
            }
            if(minute < 10){
                minutes = "0"+minute;
            }
            time[i][1] = hours+":"+minutes;
        }
        return time; 
    }
}