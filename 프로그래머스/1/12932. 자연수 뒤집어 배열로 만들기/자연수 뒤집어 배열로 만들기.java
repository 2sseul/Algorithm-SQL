import java.util.*;

class Solution {
    public int[] solution(long n) {
        String tmp = String.valueOf(n);
        StringBuffer sb = new StringBuffer(tmp);
        String reverse = sb.reverse().toString();
        int[] answer = new int[reverse.length()];
        for(int i=0; i<reverse.length(); i++){
            answer[i] = Integer.valueOf(reverse.substring(i,i+1));
        }
        return answer;
    }
}