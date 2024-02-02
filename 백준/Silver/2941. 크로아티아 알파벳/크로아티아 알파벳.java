import java.io.*;

public class Main {
	public static void main(String[] args) throws Exception{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String word = br.readLine();
		String tmp = word;
		int cnt = 0;
		
		String[] check = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
		
		while(true) {
			for(int i=0; i<check.length; i++) {
				if(tmp.contains(check[i])) {
					tmp = tmp.replaceFirst(check[i], " ");
					cnt++;
					break;
				}
				
			}
			if(word.equals(tmp)) {
				break;
			}
			
			word = tmp;
		}
		
		word = word.replaceAll("\\s", "");
		System.out.println(cnt+word.length());
		
	}
}
