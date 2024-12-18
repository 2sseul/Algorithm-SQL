import java.io.*;
import java.util.*;

class Solution {
    public String solution(String[] survey, int[] choices) {
        int count[][] = new int[4][2];
        for(int i=0; i<survey.length; i++){
            String tmp[] = survey[i].split("");
            String personal = "";
            int num = 0;
            
            if(choices[i] < 4){
                personal = tmp[0];
                num = 4 - choices[i];
            }else if(choices[i] >= 5){
                personal = tmp[1];
                num = choices[i] - 4;
            }
            
            switch(personal){
                case "R" : count[0][0] += num;
                    break;
                case "T" : count[0][1] += num;
                    break;
                case "C" : count[1][0] += num;
                    break;
                case "F" : count[1][1] += num;
                    break;
                case "J" : count[2][0] += num;
                    break;
                case "M" : count[2][1] += num;
                    break;
                case "A" : count[3][0] += num;
                    break;
                case "N" : count[3][1] += num;
                    break;
            }
        }
        String answer = "";
        if(count[0][0] >= count[0][1]){
            answer += "R";
        }else{
            answer += "T";
        }
        if(count[1][0] >= count[1][1]){
            answer += "C";
        }else{
            answer += "F";
        }
        if(count[2][0] >= count[2][1]){
            answer += "J";
        }else{
            answer += "M";
        }
        if(count[3][0] >= count[3][1]){
            answer += "A";
        }else{
            answer += "N";
        }
        return answer;
    }
}