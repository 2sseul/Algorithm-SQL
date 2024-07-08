import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] topping) {
        HashMap<Integer,Integer> chulsu = new HashMap<>();
        HashMap<Integer,Integer> sister = new HashMap<>();
        
        for(int i=0; i<topping.length-1; i++){
            if(!chulsu.containsKey(topping[i])){
                chulsu.put(topping[i], 1);
            }else{
                chulsu.put(topping[i], chulsu.get(topping[i])+1);
            }
        }
        
        sister.put(topping[topping.length-1], 1);
                
        int answer = 0;
        
        if(chulsu.size() == sister.size()){
            answer++;
        }
        
        for(int i=topping.length-2; i>=0; i--){            
            if(chulsu.get(topping[i]) == 1){
                chulsu.remove(topping[i]);
            }else{
                chulsu.put(topping[i], chulsu.get(topping[i])-1);
            }
            
            if(sister.containsKey(topping[i])){
                sister.put(topping[i], sister.get(topping[i])+1);
            }else{
                sister.put(topping[i], 1);
            }
            
            if(chulsu.size() == sister.size()){
                answer++;
            }
        }

        return answer;
    }
}