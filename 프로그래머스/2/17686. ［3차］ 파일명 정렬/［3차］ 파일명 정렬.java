import java.io.*;
import java.util.*;

class Solution {
    public String[] solution(String[] files) {
        PriorityQueue<String[]> pq = new PriorityQueue<>(new Comparator<>(){
            public int compare(String[] o1, String[] o2){
                if(o1[1].compareTo(o2[1]) == 0){
                    int number1 = Integer.valueOf(o1[2]);
                    int number2 = Integer.valueOf(o2[2]);
                    if(number1 > number2){
                        return 1;
                    }else if(number1 < number2){
                        return -1;
                    }else{
                        int own1 = Integer.valueOf(o1[3]);
                        int own2 = Integer.valueOf(o2[3]);
                        if(own1 < own2){
                            return -1;
                        }else if(own1 > own2){
                            return 1;
                        }else{
                            return 0;
                        }
                    }
                }else{
                    return o1[1].compareTo(o2[1]);
                }
            }
        });
        
        String tmps[] = new String[files.length];
        
        for(int i=0; i<files.length; i++){
            tmps[i] = files[i].toUpperCase();
            String file = tmps[i];
            String head = file.charAt(0)+"";
            String num = "";
            String tail = "";
            for(int j=1; j<file.length(); j++){
                char btmp = file.charAt(j-1);
                //숫자일경우
                char tmp = file.charAt(j);
                if(48<=tmp && tmp<=57){
                    if(tail.length() == 0){
                        //num에 넣어준다.
                        num += tmp;
                    }else{
                        //이미 num을 분리한 상황.
                        tail += tmp;
                    }
                //문자일경우
                }else{
                    if(num.length() == 0){
                        //head분리. head에 넣어준다.
                        head += tmp;
                    }else{
                        tail += tmp;
                    }
                }
            }
            int number = Integer.valueOf(num);
            String tmp[] = {files[i], head, number+"", i+""};
            pq.offer(tmp);
        }
        
        String[] answer = new String[files.length];
        
        int cnt = 0;
        while(!pq.isEmpty()){
            answer[cnt] = pq.poll()[0];
            cnt++;
        }
        return answer;
    }
}