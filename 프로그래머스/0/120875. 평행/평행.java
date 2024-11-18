import java.io.*;
import java.util.*;

class Solution {
    static HashMap<int[], Integer> map = new HashMap<>();
    public int solution(int[][] dots) {
        for(int i=0; i<dots.length/2; i++){
            boolean visited[] = new boolean[dots.length];
            int tmp[] = new int[dots.length];
            visited[i] = true;
            tmp[0] = i;
            Combi(1, i, tmp, dots, visited);
        }
        int answer = 0;
        for(int[] key : map.keySet()){
            double firstX = dots[key[0]][0] - dots[key[1]][0];
            double firstY = dots[key[0]][1] - dots[key[1]][1];
            double secondX = dots[key[2]][0] - dots[key[3]][0];
            double secondY = dots[key[2]][1] - dots[key[3]][1];
            double first = firstY / firstX;
            double second = secondY / secondX;
            if(first == second){
                
                answer++;
            }
            if(answer >= 2){
                answer = 1;
            }
        }
        return answer;
    }
    static void Combi(int depth, int idx, int[] tmp, int[][] dots, boolean[] visited){
        if(depth == 4){
            int arr[] = tmp.clone();
            map.put(arr, 1);
            
            return;
        }
        for(int i=0; i<dots.length; i++){
            if(!visited[i]){
                tmp[depth] = i;
                visited[i] = true;
                Combi(depth+1, i, tmp, dots, visited);
                visited[i] = false;
            }
        }
    }
}