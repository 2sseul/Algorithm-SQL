import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        
        int length = nums.length;
        
        for(int i=0;i<length;i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i],1);
            }
        }
        
        int half = length/2;
        int kind = map.size();
        int answer = 0;
        
        if(kind < half) {
			answer = kind;
		}else if(kind > half) {
			answer = half;
		}else {
			answer = half;
		}
        
        return answer;
    }
}