import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        for(int i=0; i<n; i++){
            String tmp1 = Integer.toBinaryString(arr1[i]);
            String tmp2 = Integer.toBinaryString(arr2[i]);
            
            if(tmp1.length() < n){
                tmp1 = String.format("%"+n+"s", tmp1).replace(' ', '0');
            }
            if(tmp2.length() < n){
                tmp2 = String.format("%"+n+"s", tmp2).replace(' ', '0');
            }
            String tmp = "";
            for(int j=0; j<n; j++){
                if(tmp1.charAt(j) == '1' || tmp2.charAt(j) == '1'){
                    tmp += "#";
                }else{
                    tmp += " ";
                }
            }
            answer[i] = tmp;
        }
        return answer;
    }
}