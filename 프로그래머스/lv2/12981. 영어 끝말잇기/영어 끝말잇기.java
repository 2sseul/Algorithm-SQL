import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(int n, String[] words) {

        int length = words.length;
		boolean check[] = new boolean[length];
		check[0] = true;
		List<String> list = new ArrayList<>();
		list.add(words[0]);
		for(int i=1; i<length; i++) {
			String before = words[i-1].substring(words[i-1].length()-1);
			String now = words[i].substring(0, 1);
			if(before.equals(now) && !list.contains(words[i])) {
				check[i] = true;
				list.add(words[i]);
			}
		}
		
		int end = 0;
		boolean isFalse = false;
		for(int i=0;i<length;i++) {
			if(!check[i]) {
				end = i+1;
				isFalse = true;
				break;
			}
		}
		int who = end%n;
		int cnt = end/n;
		if(isFalse) {			
			if(who == 0) {
				who = n;
			}else{
				who = end%n;
				cnt += 1;
			}
		}else {
			who = 0;
			cnt = 0;
		}
        
        int[] answer = {who, cnt};

        return answer;
    }
}