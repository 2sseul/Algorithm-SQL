import java.util.*;
import java.io.*;

class Solution {
    public List<Integer> solution(int[] progresses, int[] speeds) {
		int length = progresses.length;
		int[] days = new int[length];
		for(int i=0;i<length;i++) {
			int day = 0;
			int num = (100-progresses[i])%speeds[i];
			if(num!=0) {
				day = ((100-progresses[i])/speeds[i])+1;
			}else {
				day = (100-progresses[i])/speeds[i];
			}
			days[i] = day;
		}
		
		int[] answer = new int[length];
		List<Integer> list = new ArrayList<>();
		
		int first = days[0];
		answer[0] = first;
		for(int i=1; i<length; i++) {
			if(days[i]<=first) {
				answer[i] = first;
			}else {
				first = days[i];
				answer[i] = first;
			}
		}
		
		int cnt = 1;
		for(int i=0;i<length-1;i++) {
			if(answer[i] == answer[i+1]) {
				cnt++;
			}else {
				list.add(cnt);
				cnt = 1;
			}
			if(i == length-2) {
				list.add(cnt);
			}
		}
		
		return list;
    }
}