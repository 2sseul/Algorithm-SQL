import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] order) {
        Stack<Integer> assistant = new Stack<>();
        int box = 1;
        int idx = 0;
        int count = 0;
        while(true){
            if(idx >= order.length || box > order.length){
                break;
            }
            if(assistant.isEmpty()){
                if(order[idx] == box){
                    count++;
                    idx++;
                    box++;
                }else{
                    assistant.push(box);
                    box++;
                }
            }else{
                if(order[idx] == box){
                    count++;
                    idx++;
                    box++;
                }else if(order[idx] == assistant.peek()){
                    assistant.pop();
                    count++;
                    idx++;
                }else{
                    assistant.push(box);
                    box++;
                }
            }
        }

        if(idx < order.length){
            while(!assistant.isEmpty()){
                if(order[idx] == assistant.peek()){
                    count++;
                    idx++;
                    assistant.pop();
                }else{
                    break;
                }
            }   
        }
        
        return count;
    }
}