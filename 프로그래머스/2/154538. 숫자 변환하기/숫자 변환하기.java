import java.io.*;
import java.util.*;

class Solution {
    static class Node{
        int r;
        int cnt;
        Node(int r, int cnt){
            this.r = r;
            this.cnt = cnt;
        }
    }
    static Queue<Node> q = new LinkedList<>();
    public int solution(int x, int y, int n) {
        int answer = 0;
        boolean arr[] = new boolean[1000001];
        q.offer(new Node(x, 0));
        arr[x] = true;
        while(!q.isEmpty()){
            Node now = q.poll();
            if(now.r == y){
                answer = now.cnt;
                break;
            }
            int nowX = now.r;
            
            int tmp[] = {nowX+n, nowX*2, nowX*3};
            for(int i=0; i<3; i++){
                int newX = tmp[i];
                if(newX > y || arr[newX]){
                    continue;
                }
                arr[newX] = true;
                q.offer(new Node(newX, now.cnt+1));
            }
        }
        if(answer == 0 && x != y){
            answer = -1;
        }
        return answer;
    }
}