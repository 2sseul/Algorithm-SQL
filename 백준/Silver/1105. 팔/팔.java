import java.io.*;
import java.util.*;

public class Main {
	static String L;
	static String R;
	static boolean arr[];
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		L = st.nextToken();
		R = st.nextToken();
		sb = new StringBuilder(L);
		L = sb.reverse().toString();
		sb = new StringBuilder(R);
		R = sb.reverse().toString();
		
		arr = new boolean[Math.max(L.length(), R.length())];
	
		int answer = 0;
		
		if(L.length() != R.length()) {
			answer = 0;
		}else {
			Check(L.length());
			
//			System.out.println(Arrays.toString(arr));
			for(int i=0; i<arr.length; i++) {
				if(arr[i]) {
					answer++;
				}else {
//					System.out.println("!"+L.charAt(i));
					if(L.charAt(L.length()-i-1)==R.charAt(R.length()-i-1)) {
						continue;
					}else {
						break;
					}
				}
			}
		}
		
		
		sb.setLength(0);
		sb.append(answer);
		bw.append(sb.toString());
		bw.close();
	}
	static void Check(int len) {
		for(int i=0; i<len; i++) {
			if(L.charAt(i) == '8' && R.charAt(i) == '8') {
				arr[arr.length-i-1] = true;
			}
		}
	}
}
