import java.io.*;
import java.util.*;

class Solution {
    static class Node{
        int sum;
        int idx;
        Node(int sum, int idx){
            this.sum = sum;
            this.idx = idx;
        }
    }
    static int answer = 0;
    static int dp[] = new int[2001];
    public int solution(int[] numbers, int target) {
        DP(numbers, target);
        //BFS(numbers, target);
        //answer = DFS(0, numbers, 0, target);
        return dp[target + 1000];
    }
    static void DP(int[] numbers, int target){
        dp[1000] = 1;
        for(int i=1; i<=numbers.length; i++){
            int nextDp[] = new int[2001];
            for(int j=0; j<= 2000; j++){
                if(dp[j] != 0){
                    nextDp[j + numbers[i - 1]] += dp[j];
                    nextDp[j - numbers[i - 1]] += dp[j];
                }
            }
            dp = nextDp;
        }
    }
    static void BFS(int[] numbers, int target){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, 0));
        
        while(!queue.isEmpty()){
            Node n = queue.poll();
            if(n.idx == numbers.length){
                if(n.sum == target){
                    answer++;
                }
                continue;
            }

            queue.add(new Node(n.sum+numbers[n.idx], n.idx+1));
            queue.add(new Node(n.sum-numbers[n.idx], n.idx+1));
        }
    }
    static int DFS(int sum, int[] numbers, int k, int target){
        if(k == numbers.length){
            if(sum == target){
                return 1;
            }
            return 0;
        }
        return DFS(sum + numbers[k], numbers, k+1, target) + DFS(sum - numbers[k], numbers, k+1, target);            
    }
}