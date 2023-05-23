import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int[] fees, String[] records) {
		HashMap<String, Integer> map = new HashMap<>();
		String[] temp = {};
		int length = records.length;
		int cnt = 0;
		for(int i=0;i<length;i++) {
			temp = records[i].replace(":", "").split(" ");
			if(temp[2].equals("IN")) {
				int min = (Integer.valueOf(temp[0].substring(0, 2))*60)+Integer.valueOf(temp[0].substring(2,4));
				//이후에 입차했을 때
				if(map.containsKey(temp[1])) {
					map.put("O"+temp[1], min);
				//처음 입차했을 때
				}else if(!map.containsKey(temp[1]+"O")) {
					map.put(temp[1]+"O",min);
				}
			}else {
				int min = 0;
				//처음 출차했을 때
				if(map.containsKey(temp[1]+"O")){
					int outTime = (Integer.valueOf(temp[0].substring(0, 2))*60)+Integer.valueOf(temp[0].substring(2,4));
					map.put(temp[1], outTime-map.get(temp[1]+"O"));
					map.remove(temp[1]+"O");
				//이후에 출차했을 때
				}else if(map.containsKey("O"+temp[1])) {
                    min = map.get(temp[1]);
					int outTime = (Integer.valueOf(temp[0].substring(0, 2))*60)+Integer.valueOf(temp[0].substring(2,4));
					map.put(temp[1], (outTime-map.get("O"+temp[1]))+min);
					map.remove("O"+temp[1]);
				}
			}
		}
		//출차 안한애들 찾아서 더해주기
		List <String> list = new ArrayList<>();
		list.addAll(map.keySet());
		int min = 0;
		for(int i=0;i<list.size();i++) {
			if(list.get(i).contains("O")) {
				min = (23*60 + 59)-map.get(list.get(i)) ;
				//이전에 출차기록이 있을 경우
				if(map.containsKey(list.get(i).replace("O", ""))) {
					map.put(list.get(i).replace("O", ""), map.get(list.get(i).replace("O", ""))+min);
					map.remove(String.valueOf(list.get(i)));
				}
				//이전에 출차기록이 없는 경우
				else {
					map.put(list.get(i).replace("O", ""), min);
					map.remove(String.valueOf(list.get(i)));
				}
			}
		}
		//정렬
		list.clear();
		list.addAll(map.keySet());
		Collections.sort(list);
		int[] answer = new int[list.size()];
		int pay = 0;
		for(int i=0;i<list.size();i++) {
			int money = map.get(list.get(i))-fees[0];
			if(money<=0) {
				pay = fees[1];
			}else {
				if(money%fees[2]!=0) {
					pay = fees[1]+(((money/fees[2])+1)*fees[3]);
				}else {
					pay = fees[1]+((money/fees[2])*fees[3]);
				}
			}
			answer[i] = pay;
		}
        return answer;
    }	
}