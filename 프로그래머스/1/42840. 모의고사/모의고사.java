import java.io.*;
import java.util.*;

class Solution {
    static int[] math1 = {1, 2, 3, 4, 5};
    static int[] math2 = {2, 1, 2, 3, 2, 4, 2, 5};
    static int[] math3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
    static int sum1 = 0; 
    static int sum2 = 0; 
    static int sum3 = 0;
    public List<Integer> solution(int[] answers) {
        int max = 0;
        
        for(int i=0; i<answers.length; i++){
            if(answers[i] == math1[i%math1.length]){
                sum1++;
            }
            if(answers[i] == math2[i%math2.length]){
                sum2++;
            }
            if(answers[i] == math3[i%math3.length]){
                sum3++;
            }
        }
        
        max = Math.max(sum1, Math.max(sum2, sum3));
        
        List<Integer> list = new ArrayList<>();
        if(sum1 == max){
            list.add(1);
        }
        if(sum2 == max){
            list.add(2);
        }
        if(sum3 == max){
            list.add(3);
        }
        Collections.sort(list);
        return list;
    }
}