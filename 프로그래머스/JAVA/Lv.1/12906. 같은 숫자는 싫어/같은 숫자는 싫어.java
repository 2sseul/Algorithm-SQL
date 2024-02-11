import java.util.*;
import java.io.*;

public class Solution {
    public int[] solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<arr.length; i++){
            if(stack.isEmpty()){
                stack.push(arr[i]);
            }else{
                int tmp = stack.peek();
                if(arr[i]==tmp){
                    continue;
                }else{
                    stack.push(arr[i]);
                }
            }
        }
        int num = stack.size();
        int[] answer = new int[stack.size()];
        for(int i=num-1; i>=0; i--){
            answer[i] = stack.pop();
         }

        return answer;
    }
}