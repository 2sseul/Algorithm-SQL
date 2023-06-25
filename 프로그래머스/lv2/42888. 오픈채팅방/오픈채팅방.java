import java.util.*;

class Solution {
    public List<String> solution(String[] record) {
        List<String> name_list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();
        List<String> answer = new ArrayList<>();
        
        for(int i=0; i<record.length; i++){
            String[] temp = record[i].split(" ");
            if(temp[0].equals("Enter")){
                name_list.add("E"+temp[1]);
                map.put(temp[1],temp[2]);
            }else if(temp[0].equals("Leave")){
                name_list.add("L"+temp[1]);
            }else{
                map.put(temp[1],temp[2]);
            }
        }
        
        for(int i=0; i<name_list.size(); i++){
            if(name_list.get(i).substring(0,1).equals("E")){
                answer.add(map.get(name_list.get(i).substring(1,name_list.get(i).length()))+"님이 들어왔습니다.");
            }else{
                answer.add(map.get(name_list.get(i).substring(1, name_list.get(i).length()))+"님이 나갔습니다.");
            }
        }
        return answer;
    }
}