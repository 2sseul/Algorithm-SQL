import java.io.*;
import java.util.*;

class Solution {
    static TreeMap<Integer, Integer> map = new TreeMap<>();
    static boolean visited[];
    public int solution(int[] elements) {
        visited = new boolean[elements.length];
        for(int i=0; i<elements.length; i++){
            map.put(elements[i], 1);
        }
        for(int i=2; i<=elements.length; i++){
            Check(i, elements);
        }
        int answer = map.size();
        return answer;
    }
    static void Check(int n, int[] elements){
        for(int i=0; i<elements.length; i++){
            int num = elements[i];
            int number = i;
            int cnt = 1;
            while(true){
                number++;
                if(number >= elements.length){
                    number = 0;
                }
                num += elements[number];
                cnt++;
                if(cnt == n){
                    map.put(num, 1);
                    break;
                }
            }
        }
    }
}