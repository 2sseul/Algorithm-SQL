import java.io.*;
import java.util.*;

class Solution {
    public boolean solution(String[] phone_book) {
        int length = phone_book.length;
        Arrays.sort(phone_book);
        
        boolean answer = true;
        for(int i=0; i<length-1; i++){
            String tmp = phone_book[i];
            String tmp2 = phone_book[i+1].replaceAll(" ","");
            if(tmp2.length() >= tmp.length()){
                if(tmp2.substring(0, tmp.length()).equals(tmp)){
                    answer = false;
                    break;
                }else{
                    continue;
                }
            }
        }
        return answer;
    }
}