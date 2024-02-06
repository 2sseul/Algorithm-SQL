import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int tc = Integer.parseInt(br.readLine());
		
		for(int i=0; i<tc; i++) {
			String tmp = br.readLine();
			int answer = 0;
			
			int arr[] = new int[tmp.length()];
			
			if(tmp.charAt(0) == 'O') {
				arr[0] = 1;
				answer += arr[0];
			}
			
			for(int j=1; j<tmp.length(); j++) {
				if(tmp.charAt(j) == 'O') {
					arr[j] = arr[j-1] + 1;
				}else {
					arr[j] = 0;
				}
				answer+= arr[j];
			}
			
			sb.append(answer).append('\n');
		}
		System.out.println(sb.toString());
	}
}
