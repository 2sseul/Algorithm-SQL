import java.io.*;
import java.util.*;

class Solution {
    public long solution(long n) {
        String number = n+"";
        String arr[] = new String[number.length()]; 
        for(int i=0; i<number.length(); i++){
            arr[i] = number.charAt(i)+"";
        }
        Arrays.sort(arr);
        String ans = "";
        for(int i=number.length()-1; i>=0; i--){
            ans += arr[i];
        }
        long answer = Long.parseLong(ans);
        return answer;
    }
}