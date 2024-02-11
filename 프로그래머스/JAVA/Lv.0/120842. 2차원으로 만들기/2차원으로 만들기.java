class Solution {
    public int[][] solution(int[] num_list, int n) {
        int num = num_list.length;
        int num2 = num/n;
        int list = 0; 
        int[][] answer = new int[num2][n];
        for(int i=0; i<num2; i++){
            for(int j=0; j<n; j++){
                answer[i][j] = num_list[list++];
            }
        }
        return answer;
    }
}