import java.util.*;
import java.io.*;
class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int test_case = commands.length;
        
        int num = 0;
        int[] answer = new int[test_case];
        while(num<test_case){
            List<Integer> list = new ArrayList<>();
            for(int i=commands[num][0];i<=commands[num][1];i++){
                list.add(array[i-1]);
            }
            Collections.sort(list);
            answer[num] = list.get(commands[num][2]-1);
            num++;
        }
        
        return answer;
    }
}