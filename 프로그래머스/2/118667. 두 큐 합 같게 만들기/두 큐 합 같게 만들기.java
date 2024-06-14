import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        long sum1 = 0;
        long sum2 = 0;
        for(int i=0; i<queue1.length; i++){
            sum1 += queue1[i];
            list1.add(queue1[i]);
        }
        for(int i=0; i<queue2.length; i++){
            sum2 += queue2[i];
            list2.add(queue2[i]);
        }
        
        if((sum1+sum2)%2 == 1){
            return -1;
        }

        int cnt = 0;
        
        while(true){
            if(sum1 > sum2){
                sum1 -= list1.get(0);
                sum2 += list1.get(0);
                list2.add(list1.get(0));
                list1.remove(list1.get(0));
                cnt++;
            }else if(sum1 < sum2){
                sum2 -= list2.get(0);
                sum1 += list2.get(0);
                list1.add(list2.get(0));
                list2.remove(list2.get(0));
                cnt++;
            }
            if(sum1 == sum2){
                return cnt;
            }else if(list1.size() == 0 || list2.size()==0 || cnt >= (queue1.length+queue2.length)*2){
                cnt = -1;
                break;
            }
        }
        
        return cnt;
    }
}