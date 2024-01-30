import java.util.*;

class Solution {
    public String solution(String s) {
        String answer = "";
        char[] tmp = new char[s.length()];
        tmp = s.toCharArray();
        Arrays.sort(tmp);
        for(int i=s.length()-1; i>=0; i--){
            answer += (""+tmp[i]);
        }
        return answer;
    }
}