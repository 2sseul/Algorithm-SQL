import java.io.*;
import java.util.*;
import java.util.regex.Pattern;

class Solution {
    static ArrayList<ArrayList<String>> ban_user_list = new ArrayList<ArrayList<String>>();
    static HashSet<HashSet<String>> result = new HashSet<HashSet<String>>();
    public int solution(String[] user_id, String[] banned_id) {
        
        for(String banid : banned_id){
            ban_user_list.add(getMatchUserId(banid, user_id));
        }
        
        dfs(new HashSet<String>(), 0);
        
        return result.size();
    }
    static ArrayList<String> getMatchUserId(String ban, String[] user_id){
        String pattern = ban.replace("*", ".");
        
        ArrayList<String> matchUser = new ArrayList<String>();
        
        for(String userid : user_id){
            if(Pattern.matches(pattern, userid)){
                matchUser.add(userid);
            }
        }
        
        return matchUser;
    }
    static void dfs(HashSet<String> add, int depth){
        if(ban_user_list.size() == depth){
            result.add(new HashSet<>(add));
            return;
        }
        
        for(String userid: ban_user_list.get(depth)){
            if(!add.contains(userid)){
                add.add(userid);
                dfs(add, depth+1);
                add.remove(userid);
            }
        }
    }
}