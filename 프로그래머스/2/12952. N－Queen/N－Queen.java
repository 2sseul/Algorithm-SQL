import java.io.*;
import java.util.*;

//2차원을 1차원으로 축소해서 해결할 것!
class Solution {
    static int map[];
    static int count;
    public int solution(int n) {
        map = new int[n];
        Col(0, n);
        
        return count;
    }
    static boolean Valid(int x){
        for(int i=0; i < x; i++){
            if(map[x] == map[i]){
                return false;
            }
            if(Math.abs(x-i) == Math.abs(map[x] - map[i])){
                return false;
            }
        }
        return true;
    }
    static void Col(int depth, int n){
        if(depth == n){
            count++;
            return;
        }
        for(int i=0; i<n; i++){
            map[depth] = i;
            if(Valid(depth)){
                Col(depth+1, n);
            }
        }
    }
}