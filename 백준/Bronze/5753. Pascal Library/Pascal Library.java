import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			
			if(N==0 && D==0) {
				break;
			}
			
			int alumi[] = new int[N];
			
			for(int i=0; i<D; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j=0; j<N; j++) {
					int num = Integer.parseInt(st.nextToken());
					if(num == 1) {
						alumi[j]++;	
					}
				}
			}
			
			int howMany = 0;
			
			for(int i=0; i<N; i++) {
				if(alumi[i]==D) {
					howMany++;
					System.out.println("yes");
					break;
				}
			}
			
			if(howMany == 0) {
				System.out.println("no");
			}
		}
		
	}
}
