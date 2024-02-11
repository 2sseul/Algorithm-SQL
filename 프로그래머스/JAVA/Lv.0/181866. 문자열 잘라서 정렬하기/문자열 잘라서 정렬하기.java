import java.io.*;
import java.util.*;

class Solution {
    public List<String> solution(String myString) {
        String[] tmp = myString.trim().split("x");
        List<String> list = new ArrayList<>();
        for(int i=0; i<tmp.length; i++){
            if(tmp[i].length()!=0){
                list.add(tmp[i]);
            }
        }
        Collections.sort(list);
        return list;
    }
}