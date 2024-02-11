import java.io.*;
import java.util.*;

class Solution {
    static boolean visited[];
    static int number = 0;
    static List<Integer> list = new ArrayList<>();
    public List<Integer> solution(int[] numbers) {
        visited = new boolean[numbers.length];
        
        for(int i=0; i<numbers.length; i++){
            if(!visited[i]){
                check(numbers, i, 1, numbers[i]);
            }
        }
        
        Collections.sort(list);
        return list;
    }
    static void check(int[] numbers, int i, int count, int number){
        visited[i] = true;
        if(count == 2){
            if(!list.contains(number)){
                list.add(number);  
            }
            return;
        }
        
        for(int j=0; j<numbers.length; j++){
            if(i!=j && !visited[j]){
                visited[j] = true;
                check(numbers, j, count+1, number+numbers[j]);
                visited[j] = false;
            }
        }
    }
}