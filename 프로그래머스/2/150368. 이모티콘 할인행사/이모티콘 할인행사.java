import java.io.*;
import java.util.*;

class Solution {
    static int rate[] = {10, 20, 30, 40};
    static boolean visited[] = new boolean[4];
    static List<int[]> list = new ArrayList<>();
    static int emoticons_cnt;
    static int tmp[];
    static PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<>(){
        public int compare(int[] o1, int[] o2){
            if(o1[0] > o2[0]){
                return -1;
            }else if(o1[0] < o2[0]){
                return 1;
            }else{
                if(o1[1] > o2[1]){
                    return -1;
                }else if(o1[1] < o2[1]){
                    return 1;
                }else{
                    return 0;
                }
            }
        }
    });
    public int[] solution(int[][] users, int[] emoticons) {
        emoticons_cnt = emoticons.length;
        tmp = new int[emoticons_cnt];
        Rate(0, users, emoticons);
        
        int[] answer = q.poll();
        return answer;
    }
    static void Rate(int c, int[][] users, int[] emoticons){
        if(c == emoticons_cnt){
            int plus = 0;
            int sum = 0;
            for(int i=0; i<users.length; i++){
                int each = 0;
                for(int j=0; j<emoticons.length; j++){
                    if(tmp[j] >= users[i][0]){
                        each += (emoticons[j]*(100-tmp[j])/100);
                    }else{
                        continue;
                    }
                }
                if(each >= users[i][1]){
                    plus++;
                }else{
                    sum += each;
                    each = 0;
                }
            }
            int case1[] = {plus, sum};
            q.offer(case1);
            return;
        }
        for(int i=0; i<4; i++){
            tmp[c] = rate[i];
            Rate(c+1, users, emoticons);
        }
    }
}