import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		PriorityQueue<String> pq = new PriorityQueue<>(new Comparator<>() {
			public int compare(String o1, String o2) {
				return 0;
			}
		});

		
		StringBuilder sb = new StringBuilder();
		
		String word = br.readLine();
		
		char arr[] = word.toCharArray();
		int cnt[] = new int[2];
		
		for(int i=0; i<word.length(); i++) {
			if(word.charAt(i) == '0') {
				cnt[0]++;
			}else {
				cnt[1]++;
			}
		}
		
		cnt[0] /= 2;
		cnt[1] /= 2;

		int c = 0;
		for(int i=word.length()-1; i>0; i--) {
			if(arr[i] == '0') {
				c++;
				arr[i] = '2';
				if(c == cnt[0]) {
					break;
				}
			}else {
				continue;
			}
		}
		
		int n = 0;
		for(int i=0; i<word.length(); i++) {
			if(arr[i] == '1') {
				n++;
				arr[i] = '2';
				if(n == cnt[1]) {
					break;
				}
			}else {
				continue;
			}
		}

		String ans = "";
		for(int i=0; i<word.length(); i++) {
			if(arr[i] == '2') {
				continue;
			}else {
				ans += arr[i];
			}
		}
		
		sb.append(ans);
		bw.write(sb.toString());
		bw.close();
	}
}
