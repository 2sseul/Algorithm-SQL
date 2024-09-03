class Solution {
    public String solution(int n, int t, int m, int p) {
        String tmp = "";
        for(int i=0; i<=m*t; i++){
            tmp += Integer.toString(i, n)+"";
        }
        tmp = tmp.toUpperCase();
        String answer = "";
        int count = p-1;
        while(true){
            answer += tmp.charAt(count);
            count += m;
            if(answer.length() == t){
                break;
            }
        }
        return answer;
    }
}