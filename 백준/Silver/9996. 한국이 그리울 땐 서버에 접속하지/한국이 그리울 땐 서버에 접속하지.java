import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		String s = br.readLine();
		
		int middleIndex = s.lastIndexOf("*");
		String pattern1 = s.substring(0,middleIndex);
		String pattern2 = s.substring(s.lastIndexOf("*")+1);
		
		for(int i=0;i<N;i++) {
			String ans = "NE";
			String file = br.readLine();
			int length = file.length();
			if(pattern1.length()+pattern2.length() > file.length()) {
				ans = "NE";
			}else {
				if(file.substring(0,pattern1.length()).equals(pattern1)&&file.substring(file.length()-pattern2.length()).equals(pattern2)) {
					ans = "DA";
				}				
			}
			sb.append(ans).append('\n');
		}
		System.out.println(sb.toString());
	}
}
