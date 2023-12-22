import java.util.*;

class Solution {
    public long solution(long n) {
        String arr[] = String.valueOf(n).split("");
        Arrays.sort(arr);
        String tmp = "";
        for(int i=arr.length-1; i>=0; i--){
            tmp+= arr[i];
        }
        long answer = Long.valueOf(tmp);
        return answer;
    }
}