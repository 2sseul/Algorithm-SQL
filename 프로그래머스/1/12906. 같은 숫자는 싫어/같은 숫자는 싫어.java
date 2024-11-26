import java.util.*;
import java.io.*;

public class Solution {
    public List<Integer> solution(int []arr) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<arr.length; i++){
            if(stack.size() == 0){
                stack.add(arr[i]);
            }else{
                int now = stack.peek();
                if(now != arr[i]){
                    stack.add(arr[i]);
                }
            }
        }

        ArrayList<Integer> answer = new ArrayList<>();
        while(!stack.isEmpty()){
            answer.add(stack.pop());
        }
        Collections.reverse(answer);
        return answer;
    }
}