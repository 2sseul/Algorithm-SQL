import java.io.*;
import java.util.*;

class Solution {
    static HashMap<Integer, Integer> map = new HashMap<>();
    public int solution(int[] nums) {
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else{
                map.put(nums[i], map.get(nums[i])+1);
            }
        }
        int answer = 0;
        if(map.size() < nums.length/2){
            answer = map.size();
        }else{
            answer = nums.length/2;
        }

        return answer;
    }
}