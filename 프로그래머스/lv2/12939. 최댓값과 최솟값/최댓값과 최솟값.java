import java.util.*;

class Solution {
    public String solution(String s) {
        String[] tmp = s.split(" ");
        int[] array = new int[tmp.length];
        for(int i=0; i<tmp.length; i++){
            array[i] = Integer.valueOf(tmp[i]);
        }
        System.out.println(Arrays.toString(array));
        Arrays.sort(array);
        
        String answer = array[0]+" "+array[array.length-1];
        return answer;
    }
}