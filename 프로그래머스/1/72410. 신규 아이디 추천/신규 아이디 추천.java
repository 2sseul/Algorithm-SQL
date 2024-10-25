import java.io.*;
import java.util.*;

class Solution {
    static String id;
    static String ok[] = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z", "-", "_", ".", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"};
    static HashSet<String> set = new HashSet<>();
    public String solution(String new_id) {
        for(int i=0; i<ok.length; i++){
            set.add(ok[i]);
        }
        id = new_id;
        goSmall();
        goRemove(id);
        goDot();
        if(id.length() == 0){
            goLength();   
        }
        if(id.length() >= 16){
            goShort();
        }
        if(id.length() <= 2){
            goLong();
        }
        
        String answer = id;
        return answer;
    }
    static void goSmall(){
        id = id.toLowerCase();
    }
    static void goRemove(String ids){
        for(int i=0; i<ids.length(); i++){
            String tmp = ids.substring(i,i+1);
            if(!set.contains(tmp)){
                if(tmp.equals("+")){
                    id = id.replace("+", " ");
                }
                id = id.replace(tmp, " ");
            }
        }
        id = id.replaceAll(" ","");
    }
    static void goDot(){
        String check[] = {"\\.\\.", "\\.\\.\\.", "\\.\\.\\.\\.\\.", "\\.\\.\\.\\.\\.\\.\\.", "\\.\\.\\.\\.\\.\\.\\.\\.\\.\\.\\."};
        for(int i=check.length-1; i>=0; i--){
            id = id.replaceAll(check[i],".");
        }

        if(id.equals(".")){
            id = "";
        }else{
            if(id.length()>0 && id.substring(0, 1).equals(".")){
                id = id.substring(1, id.length());
            }
            if(id.length()>0 && id.substring(id.length()-1, id.length()).equals(".")){
                id = id.substring(0, id.length()-1);
            }            
        }

    }
    static void goLength(){
        id += "a";
    }
    static void goShort(){
        id = id.substring(0, 15);
        if(id.substring(id.length()-1, id.length()).equals(".")){
            id = id.substring(0, 14);
        }
    }
    static void goLong(){
        String tmp = id.substring(id.length()-1, id.length());
        while(id.length() != 3){
            id += tmp;
        }
    }
}