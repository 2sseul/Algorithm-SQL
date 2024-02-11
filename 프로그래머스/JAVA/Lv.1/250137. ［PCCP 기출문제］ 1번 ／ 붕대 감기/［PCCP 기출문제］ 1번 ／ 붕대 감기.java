import java.io.*;
import java.util.*;

class Solution {
    public int solution(int[] bandage, int health, int[][] attacks) {
        int last_attack = attacks[attacks.length-1][0];
        int attack_cnt = 0;
        int heal_cnt = 0;
        int now_health = health;
        int full_time = bandage[0];
        int heal_sec = bandage[1];
        int heal_bonus = bandage[2];
        
        for(int i=1; i<last_attack+1; i++){
            //공격
            if(attacks[attack_cnt][0] == i){
                now_health -= attacks[attack_cnt][1];
                attack_cnt++;
                heal_cnt = 0;
                if(now_health <= 0){
                    return -1;
                }
            //힐
            }else{
                if(now_health < health){
                    heal_cnt++;
                    now_health += heal_sec;
                    if(heal_cnt == full_time){
                        heal_cnt = 0;
                        now_health += heal_bonus;
                    }
                    if(now_health > health){
                        now_health = health;
                    }
                }else{
                    heal_cnt++;
                    now_health = health;
                }

            }
        }
        
        if(now_health <= 0){
            now_health = -1;
        }
        return now_health;
    }
}