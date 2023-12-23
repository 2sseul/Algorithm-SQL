import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String ans = "";
		int sum = 0;
		
		int prize[] = {100, 100, 200, 200, 300, 300, 400, 400, 500};
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		for(int i=0; i<9; i++) {
			int num = Integer.parseInt(st.nextToken());
			if(num > prize[i]) {
				ans = "hacker";
				break;
			}else {
				sum+=num;
			}
			
			if(i==8 && sum<100) {
				ans="none";
			}else if(i==8 && sum>=100) {
				ans="draw";
			}
		}
		
		System.out.println(ans);
	}
}
