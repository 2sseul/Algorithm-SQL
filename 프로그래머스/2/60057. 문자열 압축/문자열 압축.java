import java.io.*;
import java.util.*;

class Solution {
    static TreeSet<String> map = new TreeSet<>(new Comparator<String>(){
        public int compare(String o1, String o2){
            return o1.length() - o2.length();
        }
    });
    public int solution(String s) {
        if(s.length() == 1){
            return 1;
        }
        
        for(int len=1; len <= s.length()/2; len++){
            map.add(WordCheck(len, s));
        }
        
        int answer = map.first().length();
        return answer;
    }
    static String WordCheck(int len, String s){
        String[] tmp = new String[s.length()/len];
        String elses = "";
        int cnt = 0;
        for(int i=0; i<s.length(); i+=len){
            tmp[cnt++] = s.substring(i, i+len);
            if(cnt == tmp.length){
                elses = s.substring(i+len, s.length());
                break;
            }
        }
        
        int c = 1;
        String words = "";
        String now = tmp[0];
        for(int i=1; i<tmp.length; i++){
            if(tmp[i].equals(now)){
                c++;
            }else{
                if(c >= 2){
                    words += c+""+now;   
                }else{
                    words += now;
                }
                now = tmp[i];
                c = 1;
            }
        }
        
        if(c >= 2){
            words += c+""+now;   
        }else{
            words += now;
        }
        
        return words+elses;
    }
}