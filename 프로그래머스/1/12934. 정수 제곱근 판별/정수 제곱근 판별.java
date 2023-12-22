class Solution {
    public long solution(long n) {
        long answer = 0;
        double num = Math.sqrt(n);
        double sosu = num - (long)num;
        if(sosu != 0){
            answer = -1;
        }else{
            answer = (long)(num+1)*(long)(num+1);
        }
        return answer;
    }
}