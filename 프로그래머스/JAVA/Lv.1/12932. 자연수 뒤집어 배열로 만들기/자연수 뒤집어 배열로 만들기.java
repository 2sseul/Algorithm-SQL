import java.util.*;

class Solution {
    public List<Integer> solution(long n) {
        List<Integer> list = new ArrayList<>();
        String[] tmp = String.valueOf(n).split("");
        int[] answer = new int[tmp.length];
        for(int i=tmp.length-1; i>=0; i--){
            list.add(Integer.valueOf(tmp[i]));
        }
        return list;
    }
}