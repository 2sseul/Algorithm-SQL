import java.io.*;
import java.util.*;

class Solution {
    static int arr1[] = new int[706];
    static int arr2[] = new int[706];
    static int sum = 0;
    static int both = 0;
    public int solution(String str1, String str2) {
        
        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        
        Split(str1, arr1);
        Split(str2, arr2);
        
        Check();
        
        int answer = 0;
        
        if(sum == 0){
            answer = 1*65536;
        }else if(both == 0){
            answer = 0;
        }else{
            answer = 65536*both/sum;
        }
        return answer;
    }
    static void Check(){
        for(int i=0; i<706; i++){
            if(arr1[i]!=0 || arr2[i]!=0){
                sum += Math.max(arr1[i], arr2[i]);
                both += Math.min(arr1[i], arr2[i]);
            }
        }
    }
    static void Split(String str, int arr[]){
        for(int i=0; i<str.length()-1; i++){
            int tmp1 = (int)str.charAt(i) - 65;
            int tmp2 = (int)str.charAt(i+1) - 65;
            if(tmp1 >= 0 && tmp1 <= 26 && tmp2 >= 0 && tmp2 <= 26){
                int num = tmp1*26 + tmp2;
                arr[num]++;
            }else{
                continue;
            }
        }
    }
}