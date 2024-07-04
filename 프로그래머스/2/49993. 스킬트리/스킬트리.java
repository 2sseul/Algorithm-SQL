import java.io.*;
import java.util.*;

class Solution {
    public int solution(String skill, String[] skill_trees) {
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        
        int answer = 0;
        String check = "";
        String tmp = "";
        for(int i=0; i<skill.length(); i++){
            map.put(skill.charAt(i)+"", i+1);
            tmp += (i+1);
            map2.put(tmp, 1);
        }
        
        char skilltrees[] = skill.toCharArray();
        
        for(int i=0; i<skill_trees.length; i++){
            check = "";
            for(int j=0; j<skill_trees[i].length(); j++){
                if(map.containsKey(skill_trees[i].charAt(j)+"")){
                    check += (map.get(skill_trees[i].charAt(j)+""));
                }else{
                    continue;
                }
            }
            
            if(check.length() == 0){
                answer++;
            }else{
                if(map2.containsKey(check)){
                    answer++;
                }else{
                    continue;
                }
            }
        }
        
        return answer;
    }
}