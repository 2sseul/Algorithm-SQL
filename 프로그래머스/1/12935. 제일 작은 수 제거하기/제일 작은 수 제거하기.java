import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] arr) {
        int tmp[] = Arrays.copyOf(arr, arr.length);
        Arrays.sort(tmp);
        int small = tmp[0];
        int[] answer = new int[arr.length-1];
        int cnt = 0;
        for(int i=0; i<arr.length; i++){
            if(arr[i] != small){
                answer[cnt] = arr[i];
                cnt++;
            }
        }
        if(answer.length == 0){
            answer = new int[1];
            answer[0] = -1;
        }
        return answer;
    }
}