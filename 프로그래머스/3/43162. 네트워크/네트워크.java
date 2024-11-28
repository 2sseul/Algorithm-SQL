import java.io.*;
import java.util.*;

class Solution {
    static ArrayList<Integer>[] network;
    static boolean[] visited;
    static int answer = 0;
    public int solution(int n, int[][] computers) {
        network = new ArrayList[computers.length];
        visited = new boolean[computers.length];
        
        //각 컴퓨터와 연결되어 있는 컴퓨터 목록을 network에 넣기
        for(int i=0; i<computers.length; i++){
            network[i] = new ArrayList<>();
            for(int j=0; j<computers[i].length; j++){
                if(computers[i][j] == 1){
                    network[i].add(j);
                }
            }
        }
        
        for(int i=0; i<computers.length; i++){
            if(!visited[i]){
                visited[i] = true;
                BFS(i);
                //DFS(i);
                answer++;
            }
        }
        return answer;
    }
    static void BFS(int node){
        Queue<Integer> q = new LinkedList<>();
        q.offer(node);
        
        while(!q.isEmpty()){
            int now = q.poll();
            for(int i=0; i<network[now].size(); i++){
                int next = network[now].get(i);
                if(!visited[next]){
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
    }
    static void DFS(int node){
        for(int i=0; i<network[node].size(); i++){
            int next = network[node].get(i);
            if(!visited[next]){
                visited[next] = true;
                DFS(next);
            }else{
                continue;
            }
        }
    }
}