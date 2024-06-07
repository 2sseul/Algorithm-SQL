import java.util.*;
import java.io.*;

public class Solution {
    static int N;
    public int solution(int n) {
        N = n;
        
        int cnt = 0;
        while(N != 0){
            if(N%2 == 0){
                N /= 2;
            }else{
                cnt++;
                N -= 1;
            }
            if(N == 1){
                cnt++;
                break;
            }
        }

        return cnt;
    }
}