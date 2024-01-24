class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int student[] = new int[n+1];
        int answer = 0;
        student[n] = -99;
        for(int i=0; i<lost.length; i++){
            student[lost[i]-1]--;
        }
        for(int i=0; i<reserve.length; i++){
            student[reserve[i]-1]++;
        }
        
        if(student[0]==-1 && student[1] == 1){
            student[0]++;
            student[1]--;
        }
        
        for(int i=1; i<n; i++){
            if(student[i] == -1){
                if(student[i-1] == 1){
                    student[i]++;
                    student[i-1]--;
                }else if(student[i+1] == 1){
                    student[i]++;
                    student[i+1]--;
                }
            }
        }
        
        for(int i=0; i<n+1; i++){
            if(student[i] >= 0){
                answer++;
            }
        }
        
        return answer;
    }
}