import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		Queue<String[]> queue = new LinkedList<>();
		
		String answer = "";
		
		String s = br.readLine();
		String S = s;
		
		int cnt = 0;
		int c = 0;
		int st = 0;
		int ed = 0;
		int start = 0;
		int end = 0;
		int length = s.length();
		int i = 0;
		while(s.length() != 0) {
			if(s.charAt(i) == '<') {
				if(c == 0) {
					cnt++;
					start = i;
				}else if(cnt == 0){
					c = 0;
					ed = i;
					String tmp = s.substring(st, ed);
					String[] t = {tmp.trim(), "2"};
					queue.offer(t);
					i = 0;
					s = s.replaceFirst(tmp, "");
					length = s.length();
					continue;
				}
			}else if(cnt!=0 && s.charAt(i) == '>') {
				cnt = 0;
				end = i+1;
				String tmp = s.substring(start, end);
				String[] t = {tmp.trim(), "1"};
				queue.offer(t);
				i=0;
				s = s.replaceFirst(tmp, "");
				length = s.length();
				continue;
			}else if(cnt == 0) {
				if(c == 0) {
					st = i;
				}else {
					if(s.charAt(i) == ' ') {
						c = 0;
						ed = i;
						String tmp = s.substring(st, ed);
						String[] t = {tmp.trim(), "2"};
						queue.offer(t);
						i = 0;
						s = s.replaceFirst(tmp, "");
						length = s.length();
						continue;
					}
				}
				c++;
			}
			
			
			if(i == s.length()-1) {
				c = 0;
				ed = i+1;
				String tmp = s.substring(st, ed);
				String[] t = {tmp.trim(), "2"};
				queue.offer(t);
				s = s.replace(tmp, "");
				length = s.length();
				break;
			}
			i++;
		}
		
		int n = queue.size();
		
		for(int j=0; j<n; j++) {
			String t[] = queue.poll();
			if(S.charAt(answer.length())==' ') {
				answer += " ";
			}
			if(t[1]=="2") {
				StringBuilder sb = new StringBuilder(t[0]);
				String tmp = sb.reverse().toString();
				answer += tmp;
			}else {
				answer += t[0];
			}
		}
		
		bw.write(answer);
		bw.flush();
		bw.close();
	}
}
