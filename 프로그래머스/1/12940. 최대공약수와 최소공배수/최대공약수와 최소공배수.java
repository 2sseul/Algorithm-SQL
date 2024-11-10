class Solution {
    public int[] solution(int n, int m) {
        int[] answer = {gcd(n, m), n*m/gcd(n,m)};
        return answer;
    }
    static int gcd(int x, int y){
        int n;
        while(y > 0){
            n = x % y;
            x = y;
            y = n;
        }
        return x;
    }
}