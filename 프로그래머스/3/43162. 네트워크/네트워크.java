class Solution {
    static boolean check[];
    static int cnt = 0;
    public int solution(int n, int[][] computers) {
        
        check = new boolean[n];
        
        for(int i=0; i<n; i++){
            if(!check[i]){
                DFS(i, computers, n);
                cnt++;
            }
        }

        return cnt;
    }
    static void DFS(int i, int[][] computers, int n){
        check[i] = true;
        
        for(int j=0; j<n; j++){
            if(i != j && computers[i][j] == 1 && !check[j]){
                DFS(j, computers, n);
            }
        }
    }
}