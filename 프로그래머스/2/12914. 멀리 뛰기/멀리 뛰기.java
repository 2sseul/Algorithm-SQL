import java.io.*;
import java.util.*;

class Solution {
    public long solution(int n) {
        int arr[] = new int[2001];
        arr[1] = 1;
        arr[2] = 2;
        arr[3] = 3;
        for(int i=4; i<2001; i++){
            arr[i] = (arr[i-1]+arr[i-2])%1234567;
        }
        long answer = arr[n];
        return answer;
    }
}