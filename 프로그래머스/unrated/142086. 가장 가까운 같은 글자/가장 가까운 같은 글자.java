import java.util.*;
import java.io.*;

class Solution {
    public int[] solution(String s) {
    List<Character> list = new ArrayList<>();
		
		for(int i=0;i<s.length();i++) {
			list.add(s.charAt(i));
		}
		
		int arr[] = new int[list.size()];
		arr[0] = -1;
		
		for(int i=1;i<list.size();i++) {
			int ans = 99999999;
			for(int j=0;j<i;j++) {
				char now = list.get(i);
				int nowNum = i;
				if(now == list.get(j)) {
					int isNum = Math.abs(j-nowNum);
					ans = Math.min(isNum, ans);
				}
			}
			if(ans == 99999999) {
				arr[i] = -1;
			}else {
				arr[i] = ans;
			}
		}
		
        return arr;
    }
}