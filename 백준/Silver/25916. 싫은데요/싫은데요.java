import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int holl[] = new int[N];
		
		st = new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			holl[i] = Integer.parseInt(st.nextToken());
		}
		
		int left = 0, right = 1;
		int sum = holl[0], ans = 0;
	
		while(right < N){
			if(sum+holl[right] < M) {
				sum += holl[right];
				right++;
				ans = Math.max(ans, sum);
			}else if(sum+holl[right] == M) {
				ans = sum+holl[right];
				break;
			}else {
				sum -= holl[left];
				left++;
			}
		}
		
		System.out.println(ans);
	}
}