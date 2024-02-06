import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int map[] = new int[26];
		
		String words = br.readLine();
		words = words.toLowerCase();
		
		int max = 0;
		
		for(int i=0; i<words.length(); i++) {
			map[words.charAt(i)-'a']++;
		}
		
		String tmp = "";
		for(int i=0; i<26; i++) {
			max = Math.max(max, map[i]);
		}
		
		for(int i=0; i<26; i++) {
			if(map[i] == max) {
				tmp += (char)(i+'a');
			}
		}
		
		if(tmp.length() > 1) {
			sb.append("?");
		}else {
			sb.append(tmp.toUpperCase());
		}
		
		System.out.println(sb.toString());
	}
}
