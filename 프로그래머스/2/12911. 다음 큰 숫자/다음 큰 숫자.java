import java.io.*;
import java.util.*;

class Solution {
    static int cnt[] = new int[2];
    static int next[];
    public int solution(int n) {
        int num = n;
        Cal(num);
        
        int answer = n+1;
        while(true){
            next = new int[2];
            Cal2(answer);

            if(cnt[1] == next[1]){
                break;
            }
            answer++;
        }
        
        return answer;
    }
    static void Cal(int num){
        if(num == 1 || num == 0){
            cnt[num]++;
            return;
        }
        if(num % 2 == 0){
            num /= 2;
            cnt[0]++;
            Cal(num);
        }else{
            num /= 2;
            cnt[1]++;
            Cal(num);
        }
    }
    static void Cal2(int n){
        if(n == 1 || n == 0){
            next[n]++;
            return;
        }
        if(n % 2 == 0){
            n /= 2;
            next[0]++;
            Cal2(n);
        }else{
            n /= 2;
            next[1]++;
            Cal2(n);
        }
    }
}