import java.io.*;
import java.util.*;

class Solution {
    static class Village{
        int s;
        int a;
        int t;
        Village(int s, int a, int t){
            this.s = s;
            this.a = a;
            this.t = t;
        }
    }
    static ArrayList<ArrayList<Village>> town;
    static long distance[];
    public int solution(int N, int[][] road, int K) {
        int cnt = road.length;
        town = new ArrayList<ArrayList<Village>>();
        for(int i=0; i<N+1; i++){
            town.add(new ArrayList<Village>());
        }
        for(int i=0; i<cnt; i++){
            town.get(road[i][0]).add(new Village(road[i][0], road[i][1], road[i][2]));
            town.get(road[i][1]).add(new Village(road[i][1], road[i][0], road[i][2]));
        }
        
        distance = new long[N+1];
        Arrays.fill(distance, 999999);
        distance[1] = 0;
        Delivery();
        
        int answer = 0;
        for(int i=0; i<N+1; i++){
            if(distance[i] <= K){
                answer++;
            }
        }

        return answer;
    }
    static void Delivery(){
        Queue<Village> q = new LinkedList<>();
        q.addAll(town.get(1));
        
        while(!q.isEmpty()){
            Village v = q.poll();
            
            if(distance[v.a] > distance[v.s]+v.t){
                distance[v.a] = distance[v.s]+v.t;
                q.addAll(town.get(v.a));
            }
        }
    }
}