import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String s = br.readLine();
		
		String ans = "";
		
		String aaaa = "AAAA";
		String bb = "BB";
		
		s = s.replaceAll("XXXX", aaaa);
		ans = s.replaceAll("XX", bb);
		
		if(ans.contains("X")) {
			ans = "-1";
		}
		
		System.out.println(ans);
	}
}
