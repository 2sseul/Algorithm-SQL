import java.io.*;
import java.util.*;

class Solution {
    public int[] solution(int[] sequence, int k) {
        int start = 0;
        int end = 0;
        int sum = sequence[start];
        int ans = Integer.MAX_VALUE;
        int[] answer = new int[2];
        
        while(start <= end){
            if(sum < k){
                end++;
                if(end == sequence.length){
                    break;
                }
                sum += sequence[end];
            }else if(sum > k){
                sum -= sequence[start];
                start++;
                if(start == sequence.length){
                    break;
                }
            }else{
                if(ans > end-start){
                    answer[0] = start;
                    answer[1] = end;
                    ans = end-start;
                }else{
                    sum -= sequence[start];
                    start++;
                    if(start == sequence.length){
                        break;
                    }
                    continue;
                }
            }
        }
        return answer;
    }
}