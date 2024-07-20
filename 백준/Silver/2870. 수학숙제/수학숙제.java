import java.io.*;
import java.util.*;

public class Main {
	static String num;
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringBuilder sb = new StringBuilder();
		
		List<String> list = new ArrayList<>();
		
		int N = Integer.parseInt(br.readLine());
		for(int i=0; i<N; i++) {
			String word = br.readLine();
			num = "";
			for(int j=0; j<word.length(); j++) {
				if(word.charAt(j)<65) {
					num += word.charAt(j);
				}else {
					if(num.length() > 0) {
						if(num.charAt(0) == '0') {
							Check0();
						}
						list.add(num);
						num = "";
					}else {
						continue;
					}
				}
			}
			if(num.length() > 0) {
				if(num.charAt(0) == '0') {
					Check0();
				}
				list.add(num);
			}else {
				continue;
			}
		}
		Collections.sort(list, new Comparator<>() {
			public int compare(String o1, String o2) {
				if(o1.length() == o2.length()) {
					return o1.compareTo(o2);
				}else {
					return o1.length() - o2.length();
				}
			}
		});
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(i)).append('\n');
		}
		
		bw.write(sb.toString());
		bw.close();
	}
	static void Check0() {
		int cnt = 0;
		int n = num.length();
		for(int i=0; i<n; i++) {
			if(cnt == 0 && num.charAt(0)=='0') {
				num = num.substring(1, num.length());
			}else {
				cnt++;
				return;
			}
		}
		if(num.length() == 0) {
			num = "0";
		}
	}
}
