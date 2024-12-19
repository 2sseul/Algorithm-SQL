import java.io.*;
import java.util.*;

class Solution {
    public int solution(int left, int right) {
        int ans[] = new int[right+1];
        for(int i=left; i<= right; i++){
            int arr[] = new int[i+1];
            ans[i] = PrimeFactorization(i, arr);
        }
        return Cal(ans, left, right);
    }
    static int Cal(int ans[], int left, int right){
        int c = 0;
        for(int i=left; i<= right; i++){
            if(ans[i] % 2 == 0){
                c += i;
            }else{
                c -= i;
            }
        }
        return c;
    }
    static int Count(int arr[]){
        int cnt = 1;
        for(int i=0; i<arr.length; i++){
            if(arr[i] != 0){
                cnt *= (arr[i]+1);
            }
        }
        return cnt;
    }
    static int PrimeFactorization(int num, int arr[]){
        int idx = 2;
        while(true){
            if(num % idx == 0){
                arr[idx]++;
                num /= idx;
                if(num == 1){
                    break;
                }
            }else{
                idx++;
                if(idx > num){
                    break;
                }
            }
        }
        
        return Count(arr);
    }
}