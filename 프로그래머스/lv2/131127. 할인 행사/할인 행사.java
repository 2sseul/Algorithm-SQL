import java.util.*;
import java.io.*;

class Solution {
    public int solution(String[] want, int[] number, String[] discount) {
    Map<String,Integer> map = new HashMap<>();
		
		int want_length = want.length;
		int discount_length = discount.length;
		int ans = 0;
		for(int i=0;i<=discount_length-10;i++) {
			map.clear();
			for(int j=i;j<10+i;j++) {
				map.put(discount[j], map.getOrDefault(discount[j],0)+1);
			}
			for(int j=0;j<want_length;j++) {
				if(map.containsKey(want[j])) {
					if(map.get(want[j]) != number[j]) {
						break;
					}
					if(j == want_length-1) {
						ans++;
					}
				}else {
					break;
				}
			}
		}
		
        return ans;
    }
}