import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();
		
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());
		
		List<Character> list = new ArrayList<>();
		
		String what = "0123456789ABCDEFG";
		
		while(true) {
			list.add(what.charAt(m%n));
			m /= n;
			
			if(m == 0) {
				break;
			}
		}
		
		for(int i=0; i<list.size(); i++) {
			sb.append(list.get(list.size()-i-1));
		}
		
		System.out.println(sb);
	}
}
