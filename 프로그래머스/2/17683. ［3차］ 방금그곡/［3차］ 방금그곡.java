import java.io.*;
import java.util.*;

class Solution {
    static String[] replace = {"A#", "a", "C#", "c", "D#", "d", "F#", "f", "G#", "g", "B#", "b"};
    public String solution(String m, String[] musicinfos) {
        String[][] musicinfo = new String[musicinfos.length][4];
        for(int i=0; i<musicinfos.length; i++){
            musicinfo[i] = musicinfos[i].split(",");
        }
        for(int i=0; i<musicinfo.length; i++){
            for(int j=0; j<12; j+=2){
                musicinfo[i][3] = musicinfo[i][3].replaceAll(replace[j], replace[j+1]);
            }
        }
        for(int i=0; i<12; i+=2){
            m = m.replaceAll(replace[i], replace[i+1]);
        }
        
        int time[] = new int[musicinfo.length];
        for(int i=0; i<musicinfo.length; i++){
            int hour = Integer.valueOf(musicinfo[i][1].substring(0,2)) - Integer.valueOf(musicinfo[i][0].substring(0,2));
            int min = Integer.valueOf(musicinfo[i][1].substring(3,5)) - Integer.valueOf(musicinfo[i][0].substring(3,5));
            int howlong = (hour*60) + min;
            time[i] = howlong;
            int num = musicinfo[i][3].length();
            if(howlong > num){
                for(int j=0; j<howlong/num-1; j++){
                    musicinfo[i][3] += musicinfo[i][3];
                    if(musicinfo[i][3].length() >= m.length()){
                        break;
                    }
                }
                musicinfo[i][3] += musicinfo[i][3].substring(0, howlong%num);   
            }else{
                musicinfo[i][3] = musicinfo[i][3].substring(0, howlong);
            }
        }
        
        String answer = "(None)";
        List<String[]> list = new ArrayList<>();
        for(int i=0; i<musicinfo.length; i++){
            if(musicinfo[i][3].contains(m)){
                String tmp[] = {musicinfo[i][0], musicinfo[i][2], time[i]+""};
                list.add(tmp);
            }
        }
        
        if(list.size() > 1){
            Collections.sort(list, new Comparator<>(){
               public int compare(String o1[], String o2[]){
                   if(Integer.valueOf(o1[2])==Integer.valueOf(o2[2])){
                       return o1[0].compareTo(o2[0]);
                   }
                   return Integer.valueOf(o2[2]) - Integer.valueOf(o1[2]);
               } 
            });          
        }
        
        if(list.size() != 0){
            answer = list.get(0)[1];
        }

        return answer;
    }
}