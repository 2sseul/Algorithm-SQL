import java.util.*;
import java.io.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
		
		int arrX[] = new int[10];
		int arrY[] = new int[10];
		
		for(int i=0;i<X.length();i++) {
			arrX[X.charAt(i)-48]++;
		}
		
		for(int i=0;i<Y.length();i++) {
			arrY[Y.charAt(i)-48]++;
		}
		
		List<Integer> list = new ArrayList<>();

		
		int common[] = new int[10];
		for(int i=0;i<10;i++) {
			common[i] = Math.min(arrX[i], arrY[i]);
		}
		
		//0 1 2 3 4 5 6
		//1 1 0 0 0 0 0
		
		boolean check = false;
		
		for(int i=0;i<10;i++) {
			for(int j=0;j<common[i];j++) {
				if(i!=0) {
					check = true;
				}
				list.add(i);
			}
		}
		
		if(check) {
			if(list.isEmpty()) {
				sb.append("-1");
			}else {
				Collections.sort(list);
				for(int i=list.size()-1;i>=0;i--) {
					sb.append(list.get(i));
				}
			}	
		}else{
            if(!list.isEmpty()){
			    sb.append("0");
            }else{
                sb.append("-1");
            }
		}
		
        String ans = sb.toString();
        return ans;
    }
}