import java.io.*;
import java.util.*;

class Solution {
    static ArrayList<int[]> course = new ArrayList<>();
    public int solution(int k, int[][] dungeons) {
        int n = dungeons.length;
        
        for(int i=0; i<n; i++){
            boolean visited[] = new boolean[n];
            int tmp[] = new int[n];
            tmp[0] = i;
            visited[i] = true;
            Col(i, 1, n, visited, tmp);
        }
        
        int max = -1;
        for(int i=0; i<course.size(); i++){
            max = Math.max(max, DungeonOk(k, course.get(i), dungeons));
        }

        return max;
    }
    static int DungeonOk(int tired, int[] courses, int[][] dungeons){
        int cnt = 0;
        for(int i=0; i<courses.length; i++){
            if(dungeons[courses[i]][0] <= tired && tired-dungeons[courses[i]][1] >= 0){
                tired -= dungeons[courses[i]][1];
                cnt++;
            }
        }
        return cnt;
    }
    static void Col(int j, int depth, int n, boolean[] visited, int[] tmp){
        if(depth == n){
            course.add(tmp.clone());
            return;
        }
        for(int i=0; i<n; i++){
            if(!visited[i]){
                tmp[depth] = i;
                visited[i] = true;
                Col(i, depth+1, n, visited, tmp);
                visited[i] = false;
            }
        }
    }
}