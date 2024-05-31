import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		String arr[] = new String[N];
		
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		Arrays.sort(arr);
		
		int ans = 1;
		for(int i=1; i<N; i++) {
			String word1 = arr[i-1];
			String word2 = arr[i];
			if(word2.length() >= word1.length()) {
				if(word2.substring(0, word1.length()).equals(word1)) {
					continue;
				}
			}
			ans++;
 		}
		
		sb.append(ans);
		bw.write(sb.toString());
		bw.close();
	}
}	
