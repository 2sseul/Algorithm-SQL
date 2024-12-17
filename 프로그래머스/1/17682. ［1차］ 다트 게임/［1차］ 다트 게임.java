import java.io.*;
import java.util.*;

class Solution {
    public int solution(String dartResult) {
        String bonus_option[] = new String[6];
        String bonus[] = dartResult.replaceAll("0|1|2|3|4|5|6|7|8|9", "").split("");
        String score_tmp[] = dartResult.replaceAll("S|D|T|\\*|\\#", " ").trim().split("\\s+");
        
        int score[] = new int[3];
        for(int i=0; i<3; i++){
            score[i] = Integer.valueOf(score_tmp[i]);
        }
        
        Cal(score, Options(bonus, Bonus(bonus, bonus_option)));
        
        int answer = score[0]+score[1]+score[2];
        return answer;
    }
    static int[] Cal(int[] score, String[] bonus_option){
        int sum = 0;
        for(int i=0; i<3; i++){
            if(bonus_option[i*2].equals("D")){
                score[i] = score[i]*score[i];
            }else if(bonus_option[i*2].equals("T")){
                score[i] = score[i]*score[i]*score[i];
            }
            
            if(bonus_option[i*2+1] == null){
                continue;
            }else if((int)bonus_option[i*2+1].charAt(0) == 35){
            // # -1
                score[i] *= -1;
            }else if((int)bonus_option[i*2+1].charAt(0) == 42){ 
            // * *2
                score[i] = score[i]*2;
                if(i >= 1){
                    score[i-1] *= 2;
                }
            }
        }
        return score;
    }
    static String[] Options(String[] bonus, String[] bonus_option){
        int cnt = 0;
        for(int i=0; i<bonus.length; i++){
            if((int)bonus[i].charAt(0) == 35 || (int)bonus[i].charAt(0) == 42){
                
                bonus_option[cnt*2-1] = bonus[i];
            }else{
                cnt++;
            }
        }
        return bonus_option; 
    }
    static String[] Bonus(String[] bonus, String[] bonus_option){
        int idx = 0;
        for(int i=0; i<bonus.length; i++){
            if(bonus[i].equals("D") || bonus[i].equals("S") || bonus[i].equals("T")){
                bonus_option[idx] = bonus[i];
                idx += 2;
            }
        }
        return bonus_option;                                
    }
}