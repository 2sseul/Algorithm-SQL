import java.io.*;
import java.util.*;

class Solution {
    public int solution(int n) {
        int arr[] = new int[101];
        int cnt = 0;
        for(int i=1; i<=200; i++){
            if(i%3 == 0 || (i+"").contains("3")){
                continue;
            }else{
                arr[cnt] = i;
                cnt++;
                if(cnt >= 101){
                    break;
                }
            }
        }
        int answer = arr[n-1];
        return answer;
    }
}