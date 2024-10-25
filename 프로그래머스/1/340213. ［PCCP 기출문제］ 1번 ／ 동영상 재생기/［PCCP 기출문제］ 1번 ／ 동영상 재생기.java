import java.io.*;
import java.util.*;

class Solution {
    static int pos_s, op_start_s, op_end_s, video_len_s;
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        pos_s = Integer.valueOf(pos.substring(0,2)) * 60 + Integer.valueOf(pos.substring(3,5));
        op_start_s = Integer.valueOf(op_start.substring(0,2)) * 60 + Integer.valueOf(op_start.substring(3,5));
        op_end_s = Integer.valueOf(op_end.substring(0,2)) * 60 + Integer.valueOf(op_end.substring(3,5));
        video_len_s = Integer.valueOf(video_len.substring(0,2)) * 60 + Integer.valueOf(video_len.substring(3,5));
        checkOP();
        checkED();
        
        for(int i=0; i<commands.length; i++){
            if(commands[i].equals("next")){
                goNext();
            }else{
                goPrev();
            }
        }
        
        String hour = (pos_s/60)+"";
        String min = (pos_s%60)+"";
        if(hour.length() == 1){
            hour = "0"+hour;
        }
        if(min.length() == 1){
            min = "0"+min;
        }
        String answer = hour+":"+min;
        return answer;
    }
    static void goPrev(){
        pos_s -= 10;
        checkOP();
        checkST();
    }
    static void goNext(){
        pos_s += 10;
        checkOP();
        checkED();
    }
    static void checkST(){
        if(pos_s <= 0){
            pos_s = 0;
        }
        checkOP();
    }
    static void checkED(){
        if(pos_s >= video_len_s){
            pos_s = video_len_s;
        }
        checkOP();
    }
    static void checkOP(){
        if(pos_s >= op_start_s && pos_s <= op_end_s){
            pos_s = op_end_s;
        }
    }
}