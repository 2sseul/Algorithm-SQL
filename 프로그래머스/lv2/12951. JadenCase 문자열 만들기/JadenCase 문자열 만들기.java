import java.util.*;

class Solution {
    public String solution(String s) {
        s = s.toLowerCase();
        String[] temp = s.split(" ");
        
        String answer = "";
            for(int i=0; i<temp.length; i++){
                if(temp[i].length()==0){
                    answer += " ";
                }else{
                                    temp[i] = temp[i].substring(0,1).toUpperCase() + temp[i].substring(1, temp[i].length());
                if(i!=temp.length-1){
                    answer += temp[i]+" "; 
                }else{
                    answer += temp[i];
                }
                }

            }
        
        if(s.substring(s.length()-1, s.length()).equals(" ")){
            answer+= " ";
        }

        
        return answer;
    }
}