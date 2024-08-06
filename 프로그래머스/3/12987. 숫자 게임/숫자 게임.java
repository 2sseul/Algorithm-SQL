import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        int answer = 0;
        int cnt = B.length-1;
        for(int i=A.length-1; i>=0; i--){
            if(B[cnt] > A[i]){
                answer++;
                cnt--;
                if(cnt < 0){
                    break;
                }
            }
        }
        return answer;
    }
}