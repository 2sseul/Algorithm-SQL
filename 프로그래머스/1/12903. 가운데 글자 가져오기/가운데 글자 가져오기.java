class Solution {
    public String solution(String s) {
        int n = s.length();
        String mid = "";
        // 1인 경우 -> 전체 반환
        // 2인 경우 -> 전체 반환
        // 3인 경우 -> 가운데 반환
        // 4인 경우 -> 가운데 2글자 반환
        if(n <= 2){
            mid = s;
        }else if(n % 2 == 0){ // 짝수일 때
            mid += s.substring(n/2-1, (n/2)+1);
        }else{
            mid += s.charAt(n/2);
        }
        return mid;
    }
}