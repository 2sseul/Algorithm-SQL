import java.util.*;
import java.io.*;

class Solution {
    public String[] solution(String[] record) {
    HashMap<String,String> map = new HashMap<>();
		 int length = record.length;
		 List <String> temps = new ArrayList<>();
		 String[] temp = {};
	     for(int i=0;i<length;i++){
	     	String s = record[i];
	        temp = s.split(" ");
	        if(temp.length>=3) {
	        	map.put(temp[1], temp[2]);
	        }
	        if(temp[0].equals("Enter")) {
	          	temps.add("E"+temp[1]);
	        }else if(temp[0].equals("Leave")) {
	           	temps.add("L"+temp[1]);
	        }
	     }
        
	     String[] answer = new String[temps.size()];
	     for(int i=0;i<temps.size();i++) {
	    	 String how = temps.get(i).substring(0,1);
	    	 String nickname = temps.get(i).replaceFirst(how, "");
	    	 nickname = map.get(nickname);
	    	 if(how.equals("E")) {
	    		 answer[i] = nickname+"님이 들어왔습니다.";
	    	 }else {
	    		 answer[i] = nickname+"님이 나갔습니다.";
	    	 }
	     }
        return answer;
    }
}