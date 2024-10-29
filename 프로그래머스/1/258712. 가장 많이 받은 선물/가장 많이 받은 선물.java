import java.io.*;
import java.util.*;

class Solution {
    static HashMap<String, HashMap<String, Integer>> giftsgive = new HashMap<>();
    static HashMap<String, HashMap<String, Integer>> giftsreceive = new HashMap<>();
    static HashMap<String, Integer> presentLv = new HashMap<>();
    static HashMap<String, Integer> nextMonth = new HashMap<>();
    public int solution(String[] friends, String[] gifts) {
        for(int i=0; i<friends.length; i++){
            HashMap<String, Integer> innermap = new HashMap<>();
            HashMap<String, Integer> receivemap = new HashMap<>();
            for(int j=0; j<gifts.length; j++){
                String tmp[] = gifts[j].split(" ");
                if(tmp[0].equals(friends[i])){
                    if(innermap.containsKey(tmp[1])){
                        innermap.put(tmp[1], innermap.get(tmp[1])+1);    
                    }else{
                        innermap.put(tmp[1], 1);   
                    }
                }
                if(tmp[1].equals(friends[i])){
                    if(receivemap.containsKey(tmp[0])){
                        receivemap.put(tmp[0], receivemap.get(tmp[0])+1);    
                    }else{
                        receivemap.put(tmp[0], 1);   
                    }
                }
            }
            giftsreceive.put(friends[i], receivemap);
            giftsgive.put(friends[i], innermap);
        }
        
        for(int i=0; i<friends.length; i++){
            int givecnt = 0;
            for(int j=0; j<friends.length; j++){
                if(giftsgive.get(friends[i]).containsKey(friends[j])){
                    givecnt += giftsgive.get(friends[i]).get(friends[j]);   
                }
            }
            int receivecnt = 0;
            for(int j=0; j<friends.length; j++){
                if(giftsreceive.get(friends[i]).containsKey(friends[j])){
                    receivecnt += giftsreceive.get(friends[i]).get(friends[j]);   
                }
            }
            presentLv.put(friends[i], givecnt-receivecnt);
        }
        
        for(int i=0; i<friends.length; i++){
            for(int j=0; j<friends.length; j++){
                if(i == j){
                    continue;
                }
                if(!giftsreceive.get(friends[i]).containsKey(friends[j])){
                    giftsreceive.get(friends[i]).put(friends[j], 0);
                }
                if(!giftsgive.get(friends[i]).containsKey(friends[j])){
                    giftsgive.get(friends[i]).put(friends[j], 0);
                }
            }
        }
        
        for(int i=0; i<friends.length; i++){
            
            for(int j=0; j<friends.length; j++){
                if(i == j){
                    continue;
                }
                int max = 0;
                String name = "";
                // 내가 선물을 더 많이 줬던 사람을 찾기
                if(giftsgive.get(friends[i]).containsKey(friends[j]) && giftsreceive.get(friends[i]).containsKey(friends[j])){
                    if(giftsreceive.get(friends[i]).get(friends[j]) < giftsgive.get(friends[i]).get(friends[j])){
                        if(!nextMonth.containsKey(friends[i])){
                            nextMonth.put(friends[i], 1);
                        }else{
                            nextMonth.put(friends[i], nextMonth.get(friends[i])+1);
                        }
                    }else if(giftsreceive.get(friends[i]).get(friends[j]) == giftsgive.get(friends[i]).get(friends[j])){
                        if(presentLv.get(friends[i]) > presentLv.get(friends[j])){
                            if(!nextMonth.containsKey(friends[i])){
                                nextMonth.put(friends[i], 1);
                            }else{
                                nextMonth.put(friends[i], nextMonth.get(friends[i])+1);
                            }   
                        }else{
                            continue;
                        }
                    }
                }
                // 만약 나랑 선물을 주고받지 않았던 친구가 있으면?
                if(!giftsreceive.get(friends[i]).containsKey(friends[j]) && !giftsgive.get(friends[i]).containsKey(friends[j])){
                    //선물지수를 비교해서 선물을 받을지 말지 확인해준다.
                    if(presentLv.get(friends[i]) > presentLv.get(friends[j])){
                        if(!nextMonth.containsKey(friends[i])){
                            nextMonth.put(friends[i], 1);
                        }else{
                            nextMonth.put(friends[i], nextMonth.get(friends[i])+1);
                        }   
                    }
                }
            }
        }

        int answer = 0;
        for(int i=0; i<friends.length; i++){
            if(nextMonth.containsKey(friends[i]) && answer < nextMonth.get(friends[i])){
                answer = nextMonth.get(friends[i]);
            }
        }
        return answer;
    }
}