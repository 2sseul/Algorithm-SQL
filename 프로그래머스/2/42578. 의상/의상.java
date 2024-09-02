import java.io.*;
import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String,Integer> closet = new HashMap<>();
        for(int i=0; i<clothes.length; i++){
            if(!closet.containsKey(clothes[i][1])){
                closet.put(clothes[i][1], 1);
            }else{
                closet.put(clothes[i][1], closet.get(clothes[i][1])+1);
            }
        }
 
        int ans = 1;
        for(String key: closet.keySet()){
            ans *= (closet.get(key)+1);
        }
        
        return ans-1;
    }
}