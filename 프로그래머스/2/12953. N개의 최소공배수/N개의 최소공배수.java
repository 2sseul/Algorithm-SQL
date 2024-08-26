import java.io.*;
import java.util.*;

class Solution {
    static int num[] = {2, 3, 5, 7};
    static int array[];

    public int solution(int[] arr) {
        array = new int[101];
        for(int i=0; i<arr.length; i++){
            Check(arr[i]);
        }
        
        int answer = 1;
        for(int i=0; i<=100; i++){
            if(array[i]!=0){
                answer *= (int)Math.pow(i, array[i]);
            }   
        }
        return answer;
    }
    static void Check(int n){
        int idx = 0;
        int tmp[] = new int[4];
        while(true){
            if(idx == 4){
                if(n != 1){
                    array[n] = Math.max(array[n], 1);
                }
                for(int i=0; i<4; i++){
                    array[num[i]] = Math.max(array[num[i]], tmp[i]);
                }
                break;
            }
            if(n % num[idx] == 0){
                tmp[idx]++;
                n /= num[idx];
                continue;
            }else{
                idx++;
                continue;
            }
        }
    }
}