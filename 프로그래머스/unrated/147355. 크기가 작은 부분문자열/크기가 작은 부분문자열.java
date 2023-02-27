import java.util.*;
import java.io.*;

class Solution {
    public int solution(String t, String p) {
        
        int length = p.length();
		
		long number = 0;
		for(int i=0;i<length;i++) {
			char tempNum = p.charAt(i);
			number += (((int)tempNum)-48)*Math.pow(10, length-i-1);
		}
		
		char arr[] = new char[length];
		
		int cnt = 0;
		for(int i=0;i+length<=t.length();i++) {
			String temp = t.substring(i, i+length);
			arr = temp.toCharArray();
			long num = 0;
			//01234.....43210
			for(int j=0;j<length;j++) {
				num += (((int)arr[j])-48)*Math.pow(10, length-j-1);
			}
			if(num <= number) {
				cnt++;
			}
		}
		
        return cnt;
    }
}