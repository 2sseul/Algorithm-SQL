import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		int middle = num/2;
		int answer = 0;
		String words = br.readLine();
		
		StringBuilder sb = new StringBuilder(words);
		
		String wordsRe = sb.reverse().toString();
		
		for(int i=0; i<middle; i++) {
			if(words.charAt(i) != wordsRe.charAt(i)) {
				answer++;
			}
		}
		
		System.out.println(answer);
	}
}	
